package com.harshit.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.harshit.beans.Credentials;
import com.harshit.beans.Email;
import com.harshit.beans.Mail;
import com.harshit.beans.MailLog;
import com.harshit.beans.User;
import com.harshit.dao.UserDao;
import com.harshit.service.CheckingMails;
import com.harshit.service.IOServices;
import com.harshit.service.Mailer;

/**
 * This class serves as the Controller for all of the requests dispatched by the
 * servlet. The @Controller annotation allows the class to be found and
 * registered as a Controller Class during building process.
 * 
 * @author Harshit Lohani
 * @version 1.0
 * @since 2021-07-12
 */
@Controller
public class UserController {

	@Autowired
	private UserDao dao; // will inject DAO from the front controller.

	private Credentials userCred = null; // to hold the credentials of the user logged in right now.
	private User userUser = null; // to hold the details of the user logged in right now.
	private boolean isUserAdmin = false; // to hold the boolean value of the user being admin or not

	/**
	 * Reserved model attribute to hold the boolean value of isUserAdmin
	 * 
	 * @return boolean This returns true if the user is an admin, else false.
	 */
	@ModelAttribute("isAdmin")
	public boolean getVersion() {
		return isUserAdmin;
	}

	/**
	 * Reserved model attribute of name 'userUser' to hold the User object
	 * 
	 * @return User This returns the User object of the logged in user
	 */
	@ModelAttribute("userUser")
	public User getUserUser() {
		return userUser;
	}

	/**
	 * The displays a form to input data, "command" here is //a reserved attribute
	 * which is used to display object data into form
	 * 
	 * @param model This is the model used by SpringMVC
	 * @return String This returns the userForm.jsp webpage
	 */
	@RequestMapping(value = "/userForm", method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("command", new User());
		return "userForm";
	}

	/**
	 * The showLogin function adds a Credential object into the Model and maps it to
	 * the default key value of command. This allows the jsp page page to bind the
	 * form with the "command" attribute and maps the fields to the Credentials
	 * variables
	 * 
	 * @param model This is the model object used by SpringMVC
	 * @return String This returns the name of the jsp page containing login form
	 */
	@RequestMapping(value = "/showLogin", method = RequestMethod.GET)
	public String showLogin(Model model) {
		model.addAttribute("command", new Credentials());
		model.addAttribute("isUserAdmin", false);
		return "loginForm";
	}

	/**
	 * The showMailer function adds a Mail object into the Model and maps it to the
	 * default key value of "command". This allows the jsp page page to bind the
	 * form with the "command" attribute and maps the fields to the POJO class Mail
	 * variables
	 * 
	 * @param model This is the model object used by SpringMVC
	 * @return String This returns the name of the jsp page containing the mailer
	 *         form
	 */
	@RequestMapping(value = "/showMailer", method = RequestMethod.GET)
	public String showMailer(Model model) {
		model.addAttribute("command", new Mail());
		return "mailerForm";
	}

	/**
	 * This function creates a list of all User objects in the User Table and adds
	 * the list to Spring model which is then accessed by the viewUser.jsp page.
	 * 
	 * @param model This is the model object used by SpringMVC.
	 * @return String This returns the name of the jsp page showing the records of
	 *         all the users.
	 */
	@RequestMapping(value = "/viewUser", method = RequestMethod.GET)
	public String viewUser(Model m) {
		if (!this.isUserAdmin) {
			return "failure";
		}
		List<User> list = dao.getUsers();
		m.addAttribute("list", list);
		return "viewUser";
	}

	/**
	 * This fucntion creates a list of all Email object obtained from the user's
	 * gmail inbox and adds the list to Spring model which is then accessed by the
	 * inbox.jsp page.
	 * 
	 * @param model This is the model object used by SpringMVC.
	 * @return String This returns the name of the jsp page showing the inbox of the
	 *         user.
	 */
	@RequestMapping(value = "/showInbox", method = RequestMethod.GET)
	public String showInbox(Model model) {

		List<Email> newEmailList = CheckingMails.downloadEmails(userUser.getUserId(), userCred.getUserEmail(),
				userCred.getPassword());
		System.out.println("Emails recieved!");
		dao.updateInbox(userUser.getUserId(), newEmailList);
		System.out.println("Inbox Updated!");
		List<Email> inbox = dao.getInbox(userUser.getUserId());
		System.out.println("Inbox retireved!");
		model.addAttribute("inboxList", inbox);
		return "inboxNew";
	}

	/**
	 * This method loads the homepage screen
	 * 
	 * @return String This returns the homepage for the logged in user
	 */
	@RequestMapping("/showHomepage")
	public String showHomePage() {
		return "homepage";
	}

	/**
	 * This method loads the index page
	 * 
	 * @return String This returns the index page jsp
	 */
	@RequestMapping("/showIndex")
	public String showIndex() {
		return "index";
	}

	/**
	 * This method returns loads the profile page
	 * 
	 * @param model This variable holds the model used by SpringMVC
	 * @return String This returns the profile jsp page
	 */
	@RequestMapping("/showProfile")
	public String showProfile(Model model) {
		model.addAttribute("userModel", this.userUser);
		model.addAttribute("credModel", this.userCred);
		return "newProfile";
	}

	@RequestMapping("/showEditProfile")
	public String showEditProfile(Model model) {
		model.addAttribute("userModel", this.userUser);
		model.addAttribute("credModel", this.userCred);
		return "editProfile";
	}

	/**
	 * This method calls the UserDao getMailLog() method and stores the list. It
	 * adds the list as a model attribute for the viewMailLog jsp page to access
	 * 
	 * @param model This variable holds the model used by SpringMVC
	 * @return String this return the viewMailLog jsp page
	 */
	@RequestMapping("/showLogs")
	public String showMailLog(Model model) {
		List<MailLog> list = dao.getMailLog(userCred.getUserEmail());
		model.addAttribute("mailLogList", list);
		return "viewMailLog";
	}

	/**
	 * This method displays the body text of the selected mail and adds the body to
	 * the model attribute "body"
	 * 
	 * @param body  This variable holds the body of the email
	 * @param model This variable holds the model used by SpringMVC
	 * @return String This returns the JSP viewBody page
	 */
	@RequestMapping("/showBody/{body}")
	public String showBody(@PathVariable("body") String body, Model m) {
		m.addAttribute("body", body);
		return "viewBody";
	}

	/**
	 * The loginProcess function is mapped to the post method of login.
	 * ModelAttribute tag binds the Credentials cred to the model attribute
	 * "credentials". The Model m is singleton into which we will add the warning
	 * messages. dao is the autowired UserDao bean and calls the
	 * validateCredentials(Credentials credentials) and tries to validate the
	 * credential which returns the user if found, else returns null. When the user
	 * is found, we store the User and Credentials details and return the logged in
	 * homepage. Else it refreshes the page with the error message.
	 * 
	 * @param Credentials cred is initialized and created by front controller using
	 *                    form fields
	 * @param isAdmin     This is initialized by SpringMVC and holds the value true
	 *                    if the user has admin role
	 * @param model       This is the model object used by SpringMVC
	 * @return it returns the homepage jsp if the login in valid, else returns
	 *         showlogin page with an error message
	 */
	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public String loginProcess(@ModelAttribute("credentials") Credentials cred,
			@ModelAttribute("isAdmin") boolean isAdmin, Model model) {
		User user = dao.validateCredentials(cred);
		if (user != null) {
			this.userCred = cred;
			this.userUser = user;
			if (userUser.getRole().equals("admin")) {
				this.isUserAdmin = true;
			} else {
				this.isUserAdmin = false;
			}
			model.addAttribute("isAdmin", isUserAdmin);
			return "homepage";
		} else {
			model.addAttribute("message", "Wrong Credentials");
			return showLogin(model);
		}
	}

	/**
	 * This method is used to process the mail and send it using Mailer class
	 * 
	 * @param mail  This variable is autowired from the jsp form and contains the
	 *              mail information
	 * @param model This variable holds the Model object used by SpringMVC to
	 *              contain the model
	 * @return String This returns the same mailer page by calling showMailer
	 */
	@RequestMapping(value = "mailProcess", method = RequestMethod.POST)
	public String mailerProcess(@ModelAttribute("mail") Mail mail, Model model) {
		Mailer mailer = new Mailer(mail, userCred);
		boolean sent = mailer.callMailerSimple();
		if (sent) {
			model.addAttribute("message", "Mail Sent!");
		} else {
			model.addAttribute("message", "Mail not sent!");
		}
		dao.addLog(mail, userCred, sent);
		return showMailer(model);
	}

	/**
	 * This method is used to process the mail and send it using Mailer class
	 * 
	 * @param mail  This variable is autowired from the jsp form and contains the
	 *              mail information
	 * @param model This variable holds the Model object used by SpringMVC to
	 *              contain the model
	 * @return String This returns the same mailer page by calling showMailer
	 */
	@RequestMapping(value = "mailProcessWithAttachment", method = RequestMethod.POST)
	public String mailerProcessWithAttatchment(@ModelAttribute("mail") Mail mail, Model model) {
		// create a mailer class with all relevant fields
		Mailer mailer = new Mailer(mail, userCred);
		// try to upload the files if any
		boolean uploadStatus = IOServices.multiUploadFile(mail.getFiles());
		// try to send the mail with the files
		boolean mailStatus = mailer.callMailerSimple();
		System.out.println("Upload Status: " + uploadStatus);
		System.out.println("Mail Status: " + mailStatus);
		dao.addLog(mail, userCred, mailStatus);
		model.addAttribute("mailStatus", mailStatus);// add status to the file
		return showEmails(model);
	}

	/**
	 * This method saves the object user into the database. The @ModelAttribute puts
	 * requested data into user object from the Spring Form
	 * 
	 * @param user  This variable holds the user information
	 * @param model This variable holds the model used by SpringMVC
	 * @return String returns the address of the login page by calling
	 *         showLogin(Model m)
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("user") User user, Model model) {
		String userId = user.getUserId();
		boolean userExists = dao.userIdExists(userId);

		if (userExists) {
			model.addAttribute("message", "UserID already exists");
			return showLogin(model);
		} else {
			dao.save(user);
			dao.createUser(userId);
			return showLogin(model);
		}
	}

	@RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
	public String updateProfile(@ModelAttribute("user") User user, Model model) {
		dao.updateProfile(userUser.getId(), user);
		return showProfile(model);
	}

	/**
	 * This method displays the data into form for the given id The @PathVaribale
	 * puts URL data into a variable
	 * 
	 * @param id    This variable holds the id from Users table which needs to be
	 *              deleted
	 * @param model This variable holds the model used by SpringMVC
	 * @return String This returns the String to the same view users page by calling
	 *         the viewUser(Model model) method
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") String id, Model model) {
		if (("" + userUser.getId()).equals(id)) {
			model.addAttribute("message", "You cannot delete yourself!");
		} else {
			dao.delete(id);
		}

		return "redirect:/" + viewUser(model);
	}

	@RequestMapping(value = "/makeAdmin/{id}", method = RequestMethod.GET)
	public String makeAdmin(@PathVariable("id") String id, Model model) {
		dao.makeAdmin(id);
		return "redirect:/" + viewUser(model);
	}

	@RequestMapping(value = "/makeUser/{id}", method = RequestMethod.GET)
	public String makeUser(@PathVariable("id") String id, Model model) {
		dao.makeUser(id);
		return "redirect:/" + viewUser(model);
	}

	/**
	 * The function clears the value of cred and user and returns to the login page
	 * for the user to login again.
	 * 
	 * @param model This variable holds the model used by SpringMVC
	 * @return String This returns jsp page for login page by callins
	 *         showLogin(Model model) method
	 */
	@RequestMapping("/signout")
	public String signout(Model model) {
		this.userUser = null;
		this.userCred = null;
		return showLogin(model);
	}

	@RequestMapping(value = "/deleteLog/{id}", method = RequestMethod.GET)
	public String deleteLog(@PathVariable("id") int id, Model model) {
		dao.deleteMailLog(id);
		return "redirect:/showLogs";
	}

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		MailLog mailLog = dao.getMailLogById(id);
		model.addAttribute("mailLog", mailLog);
		return "viewBody";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String startUpload(Model model) {
		return "uploadForm";
	}

	// Handler Method for file upload
	@RequestMapping(value = "/uploadProfile", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("profilePicture") MultipartFile file, Model model) {
//		String msg = "";

		boolean saved = IOServices.uploadProfile(file);
		if (saved) {
			dao.updateProfile(userUser.getId(), file.getOriginalFilename());
			userUser.setProfilePicture(file.getOriginalFilename());
		}

		model.addAttribute("message", "profile uploaded");
		return showProfile(model);
	}

	@RequestMapping(value = "/uploadFileMultiple", method = RequestMethod.POST)
	@ResponseBody
	public String uploadFile(@RequestParam("file") MultipartFile[] files, Model model) {
		String msg = "";
		int emptyCount = 0;
		for (MultipartFile file : files) {
			if (!file.isEmpty()) {
				BufferedOutputStream bos = null;
				try {
					byte[] fileBytes = file.getBytes();
					// location to save the file
					String newPath = "E:\\JavaProjects\\EmailSpringDB\\src\\main\\temp\\";
					String fileName = newPath + file.getOriginalFilename();
					bos = new BufferedOutputStream(new FileOutputStream(new File(fileName)));
					bos.write(fileBytes);
					msg = msg + "Upload successful for " + file.getOriginalFilename() + "<br />";
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (bos != null) {
						try {
							bos.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			} else {
				emptyCount++;
			}
		}
		// Equal means no file is selected for upload
		if (files.length == emptyCount) {
			msg = "Upload failed as no file is selected";
		}
		return msg;
	}

	@RequestMapping("/readEmail/{emailUUID}")
	public String readEmail(@PathVariable("emailUUID") String emailUUID, Model model) {

		Email email = dao.getEmailByUUID(userUser.getUserId(), emailUUID);
		System.out.println(email.getSubject());
		model.addAttribute("email", email);
		return "readEmailNew";
	}

	@RequestMapping("/searchEmail")
	public String searchEmail(@RequestParam("searchString") String query, Model model) {
		List<Email> emailList = dao.searchEmail(userUser.getUserId(), query);
		model.addAttribute("inboxList", emailList);
		return "inboxNew";
	}

	@RequestMapping("/showStarred")
	public String showStarred(Model model) {
		List<Email> emailList = dao.getStarred(userUser.getUserId());
		model.addAttribute("inboxList", emailList);
		return "inboxNew";
	}

	@RequestMapping("/showEmails")
	public String showEmails(Model model){
		List<Email> emailList = dao.getInbox(userUser.getUserId());
		model.addAttribute("inboxList", emailList);
		return "inboxNew";
	}

	@RequestMapping(value = "/download/{filename:.+}", method = RequestMethod.GET)
    public void downloadPDFResource( HttpServletRequest request, HttpServletResponse response, @PathVariable("filename") String fileName) {
        String dataDirectory = "E:\\JavaProjects\\EmailSpringDB\\src\\main\\temp\\Attachments\\";
        Path file = Paths.get(dataDirectory, fileName);
        System.out.println(fileName);
        System.out.println(file);
        System.out.println(dataDirectory);
        if (Files.exists(file)) 
        {
//            response.setContentType("");
            response.addHeader("Content-Disposition", "attachment; filename="+fileName);
            try
            {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            } 
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else {
        	System.out.println("File not find!");
        }
	}
	
	@RequestMapping("/toggleStarred/{emailUUID}")
	public String toggleStarred(Model model, @PathVariable("emailUUID") String emailUUID) {
		dao.toggleStarred(userUser.getUserId(), emailUUID);
		return readEmail(emailUUID, model);
	}
		
}
