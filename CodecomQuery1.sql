use Codecom;
create table Users
			(username varchar(20) not null primary key,
			password varchar(15) not null);
create table Messages
			(message_id int not null primary key,
			sender varchar(20) not null foreign key references Users(username) on delete cascade,
			message_body varchar(200) not null);
create table Replies
			(reply_id int not null primary key,
			message_id int not null foreign key references Messages(message_id) on delete cascade,
			replied_to varchar(20) not null foreign key references Users(username) on delete no action,
			replier varchar(20) not null foreign key references Users(username) on delete no action,
			reply_body varchar(100) not null);
create table Likes
			(like_id int not null primary key,
			message_id int not null foreign key references Messages(message_id) on delete cascade,
			liked_user varchar(20) not null foreign key references Users(username) on delete no action,
			liker varchar(20) not null foreign key references Users(username) on delete no action);
create table Dislikes
			(dislike_id int not null primary key,
			message_id int not null foreign key references Messages(message_id) on delete cascade,
			disliked_user varchar(20) not null foreign key references Users(username) on delete no action,
			disliker varchar(20) not null foreign key references Users(username) on delete no action);
create table Logout
			(logout_id int not null primary key,
			username varchar(20) not null foreign key references Users(username) on delete cascade,
			lastmessageseen int not null foreign key references Messages(message_id) on delete no action);

drop table Logout;
drop table Dislikes;
drop table Likes;
drop table Replies;
drop table Messages;
drop table Users;