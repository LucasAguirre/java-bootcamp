
CREATE DATABASE highschool;
USE highschool;
CREATE USER sqluser IDENTIFIED BY 'sqluserpw';

grant usage on *.* to sqluser@localhost identified by 'sqluserpw';
grant all privileges on feedback.* to sqluser@localhost;

CREATE TABLE Student(
	registration_number	INT	NOT NULL AUTO_INCREMENT,
	firstName	VARCHAR(30)	NOT NULL,
	lastName	VARCHAR(30)	NOT NULL,
	dateOfBirth	date	NOT NULL,
	PRIMARY KEY (registration_number)
);


CREATE TABLE Teacher(
	id	INT NOT NULL AUTO_INCREMENT,
	firstName	VARCHAR(30)NOT NULL,
	lastName	VARCHAR(30)NOT NULL,
	dateOfBirth	date	NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE Course(
	id	INT NOT NULL AUTO_INCREMENT,
	name	VARCHAR(30)	NOT NULL,
	assignedTeacher	INT NOT NULL,
	hoursByWeek	INT	NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY(assignedTeacher) REFERENCES Teacher(id)
);


CREATE TABLE ScheduleTime(
	id	INT NOT NULL AUTO_INCREMENT,
	courseId	INT	NOT NULL,
	dayOfWeek	VARCHAR(20)	NOT NULL,
	startHour	VARCHAR(5)	NOT NULL,
	finishHour	VARCHAR(5)	NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY(courseId) REFERENCES Course(id)
);


CREATE TABLE StudentXCourse(
	studentId	INT NOT NULL,
	courseId	INT NOT NULL,
	partialNote1	INT,
	partialNote2	INT,
	partialNote3	INT,
	finalNote	INT,
	PRIMARY KEY (courseId,studentId),
	FOREIGN KEY(studentId) REFERENCES Student(registration_number),
	FOREIGN KEY(courseId) REFERENCES Course(id)
);