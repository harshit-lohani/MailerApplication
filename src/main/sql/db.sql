create database emailSpring;
use emailSpring;

create table Users(
	id int auto_increment unique not null,
    userid varchar(255) not null primary key,
    firstname varchar(255) not null,
    lastname varchar(255),
    gender varchar(10),
    phoneNumber varchar(15),
    email varchar(255) unique not null,
    pword varchar(255) not null,
    created datetime default now(),
    role varchar(20) default 'user',
    profile varchar(255) default 'noprofile.jpg'
    );
    
insert into Users(firstName, lastName, gender, email, pword) values(
	"Harshit",
    "Lohani",
    "Male",
    "manwesulimo123@gmail.com",
    "dcsdcds"
    );
    
select * from users;

delete from users where not(id = 1); 
delete from users;

drop table Users;

update users
set role = 'admin'
where email = 'manwesulimo123@gmail.com';

create table MailLog(
	id int primary key auto_increment,
    email varchar(255) not null references Users,
	toemail varchar(255) not null,
	subject varchar(255),
    body varchar(1024),
    sendtime datetime default now(),
    status varchar(30)
    );
    
select * from maillog;

drop table maillog;
    
select * from maillog where email = 'manwesulimo123@gmail.com';
insert into maillog(email, toemail, subject, body, status) values('manwesulimo123@gmail.com','harshitraj.lohani123@gmail.com','This is a test mail but you cant read this, only I can','This is the body which I havent encrypted!','Sent'); 
delete from users where email = 'manwesulimo123@gmail.com';

create table harshitlohani(
	email_uuid varchar(256) not null primary key,
	from_email varchar(1024) not null,
    subject varchar(1024),
    sent_date datetime,
    content text,
    attachment_count int,
    attachments varchar(225)
	);
    
drop table harshitlohani;
drop table manwesulimo;
select * from manwesulimo;
delete from users;
select * from users;

select * from manwesulimo;
delete from manwesulimo;