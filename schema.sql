drop database if exists course_system_management;

create database course_system_management;

USE course_system_management;

create table account (
    username varchar(255) not null primary key,
    password varchar(255) not null,
    role varchar(10) not null
);

create table student(
	id varchar(255) primary key not null,
    name varchar(50) not null,
    address varchar(255) not null,
    phone varchar(10) not null,
    email varchar(50) not null,
    class varchar(20) not null,
    account_id varchar(255),
    foreign key (account_id) references account(username)
);

create table faculty (
	id varchar(255) primary key not null,
    name varchar(50) not null,
    address varchar(255) not null,
    phone varchar(10) not null,
    email varchar(50) not null,
    department varchar(20) not null,
    account_id varchar(255),
    foreign key (account_id) references account(username)
);

create table course (
	id varchar(255) primary key not null,
    name varchar(50) not null,
    credit int not null,
    max_student int not null,
    faculty_id varchar(255),
    foreign key (faculty_id) references faculty(id)
);

create table register (
	student_id varchar(255),
    course_id varchar(255),
    foreign key (student_id) references student(id),
    foreign key (course_id) references course(id),
    constraint primary key(student_id, course_id)
);

