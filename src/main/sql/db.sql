create database emailSpring;
use emailSpring;

create table Users(
	id int primary key auto_increment,
    firstname varchar(255) not null,
    lastname varchar(255),
    gender varchar(10),
    phoneNumber varchar(15),
    email varchar(255) unique not null,
    pword varchar(255) not null,
    created datetime default now(),
    role varchar(20) default 'user' 
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

delete from users where email = 'manwesulimo123@gmail';