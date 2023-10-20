drop database if exists course_system_management;

create database course_system_management;

create table course_system_management.student(
	id varchar(255) primary key not null,
    name varchar(50) not null,
    address varchar(255) not null,
    phone varchar(10) not null,
    email varchar(50) not null,
    class varchar(20) not null
);

create table course_system_management.faculty (
	id varchar(255) primary key not null,
    name varchar(50) not null,
    address varchar(255) not null,
    phone varchar(10) not null,
    email varchar(50) not null,
    department varchar(20) not null
);

create table course_system_management.course (
	id varchar(255) primary key not null,
    name varchar(50) not null,
    credit int not null,
    faculty_id varchar(255),
    foreign key (faculty_id) references faculty(id)
);

create table course_system_management.register (
	student_id varchar(255),
    course_id varchar(255),
    foreign key (student_id) references student(id),
    foreign key (course_id) references course(id)
);

create table course_system_management.account (
	student_id varchar(255),
    faculty_id varchar(255),
    username varchar(255) not null primary key,
    password varchar(255) not null,
    role varchar(10) not null,
    foreign key (student_id) references student(id),
    foreign key (faculty_id) references faculty(id)
);