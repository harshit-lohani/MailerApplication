package com.harshit.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.harshit.beans.Credentials;
import com.harshit.beans.Mail;
import com.harshit.beans.MailLog;
import com.harshit.beans.MailLogMapper;
import com.harshit.beans.User;
import com.harshit.beans.UserMapper;
import com.harshit.service.CryptoService;

/**
 * This class serves as the DAO class and is used to access the mySQL database
 * using jdbcTemplate.
 * 
 * @author Harshit Lohani
 * @version 1.0
 * @since 2021-07-13
 */
@Repository
public class UserDao {

	private JdbcTemplate template;

	/**
	 * This method initialises the JdbcTemplate instance using the dispatcher
	 * servlet
	 * 
	 * @param template This variable holds the template instance created using
	 *                 dispatcher servlet
	 */
	public void setJdbcTemplate(JdbcTemplate template) {
		this.template = template;
	}

	/**
	 * This method runs the query to insert the user details into the Users mySQL
	 * table after encrypting the user password using CryptoService class
	 * 
	 * @param user This variable holds the details of the users trying to register
	 * @return int This returns 1 if the query is successful and 0 if the query is
	 *         unsuccessful
	 */
	public int save(User user) {
		String sql = "insert into Users(firstName, lastName, gender, phoneNumber, email, pword) values('"
				+ user.getFirstName() + "','" + user.getLastName() + "','" + user.getGender() + "','"
				+ user.getPhoneNumber() + "','" + user.getEmail() + "','" + CryptoService.encrypt(user.getPassword())
				+ "')";

		return template.update(sql);
	}

	/**
	 * This method runs the sql query to retrieve all users and add them to a list
	 * of type List<User> using UserMapper class
	 * 
	 * @return List<User> This returns the list of all the users present in the
	 *         database
	 */
	public List<User> getUsers() {
		return template.query("select * from Users", new UserMapper());
	}

	/**
	 * This method checks for the email address and password in the mysql database
	 * to validate the user credentials. It calls the CryptoService class to match
	 * the encrypted password
	 * 
	 * @param cred This variable holds the username and password entered by the user
	 *             during login
	 * @return User This returns the corresponding user object to the cred if record
	 *         is found, else returns null
	 */
	public User validateCredentials(Credentials cred) {

		List<User> list = getUserByEmail(cred.getUserEmail());

		if (list.isEmpty()) {
			System.out.println("NOTFOUND");
			return null;
		}

		User user = list.get(0);
		String cryptedPassword = CryptoService.encrypt(cred.getPassword());
		if (user.getPassword().compareTo(cryptedPassword) == 0) {
			return user;
		}

		return null;

	}

	/**
	 * This method runs the sql query to retrieve all the records having the given
	 * email in a list of List<User> type
	 * 
	 * @param email this variable holds the email of the user whose records we want
	 *              to access
	 * @return List<User> This returns the list of all the users that match the
	 *         given email
	 */
	public List<User> getUserByEmail(String email) {
		String sql = "select * from users where email = '" + email + "';";
		return template.query(sql, new UserMapper());
	}

	public List<MailLog> getMailLog(String userEmail) {
		String sql = "select * from maillog where email = '" + userEmail + "';";
		return template.query(sql, new MailLogMapper());
	}

	/**
	 * This method runs the sql query to insert the sent mail into MailLog relation
	 * 
	 * @param mail This variable holds the mail details i.e. to, body and subject
	 * @param cred This variable holds the user credentials to get userEmail
	 * @param stat This variable holds the boolean status valus if the mail was sent
	 *             or not
	 * @return int This returns 1 if the query is executed successfully, else 0
	 */
	public int addLog(Mail mail, Credentials cred, boolean stat) {
		String email = cred.getUserEmail();
		String toEmail = mail.getToEmail();
		String subject = mail.getSubject();
		String body = mail.getBody();
		String status = stat ? "Sent" : "Not sent";

		String sql = "insert into maillog(email, toemail, subject, body, status) values('" + email + "','" + toEmail
				+ "','" + subject + "','" + body + "','" + status + "')";

		return template.update(sql);
	}

	/**
	 * This method runs the sql query to delete the user with "id" as id from the
	 * user table
	 * 
	 * @param id This variable holds the id number of the user whose record we want
	 *           to delete
	 * @return int This returns 1 if the query is executed successfully, else 0
	 */
	public int delete(String id) {
		String sql = "delete from users where id = '" + id + "';";
		return template.update(sql);
	}

	/**
	 * This methods runs the sql query to retrieve the mail log from MailLog table
	 * corresponding to the id and return it as a MailLog object.
	 * 
	 * @param id This is the id of the mailLog we want to retrieve
	 * @return MailLog This returns the mail log corresponding to the id if present,
	 *         else null
	 */
	public MailLog getMailLogById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from maillog where id = '" + id + "';";
		List<MailLog> listMail = template.query(sql, new MailLogMapper());
		if (listMail.isEmpty()) {
			return null;
		} else {
			return listMail.get(0);
		}
	}

	public int deleteMailLog(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from maillog where id = '" + id + "';";
		return template.update(sql);
	}

}
