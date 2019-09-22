create database seal;

use seal;

drop table if exists user;

create table user(
	id int auto_increment primary key ,
	username varchar(64) not null,
	password varchar(64) not null
)

insert into user(username, password) values('li.linlin', '$2a$10$Xzij/LYy2IOpFd6TPCU.MOBtDkBoPnPWvGO4kIY1lk9KU0W5vhEmi');
insert into user(username, password) values('zhaojiahong', '$2a$10$n4hQv/r6by7zUKFZ3rcOQeR80D3PUyozbWiCJhnZrv/IiFDGfZmmy');

drop table if exists role;

create table role(
	id int auto_increment primary key,
	user_id int not null,
	role varchar(20) not null
)