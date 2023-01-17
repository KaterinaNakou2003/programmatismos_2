use Codecom;
create table Users
			(username varchar(20) not null primary key,
			password varchar(15) not null);
create table Messages
			(message_id int not null identity(1,1) primary key, /* balte identity(1003,1) */
			sender varchar(20) not null foreign key references Users(username) on delete cascade,
			message_body varchar(200) not null,
			typeofmessage int not null);
create table Likes
			(like_id int not null identity(1,1) primary key, /* balte identity(17,1) */
			message_id int not null foreign key references Messages(message_id) on delete cascade,
			liked_user varchar(20) not null foreign key references Users(username) on delete no action,
			liker varchar(20) not null foreign key references Users(username) on delete no action);
create table Logout
			(logout_id int not null identity(1,1) primary key, /* balte identity(2008,1) */
			username varchar(20) not null foreign key references Users(username) on delete cascade,
			lastmessageseen int not null foreign key references Messages(message_id) on delete no action);

/* drop table Logout;
drop table Likes;
drop table Messages;
drop table Users; */
