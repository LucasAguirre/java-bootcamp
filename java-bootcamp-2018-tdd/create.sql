CREATE DATABASE Market;

USE Market;
CREATE USER sqluser IDENTIFIED BY 'sqluserpw';

grant usage on *.* to sqluser@localhost identified by 'sqluserpw';
grant all privileges on feedback.* to sqluser@localhost;


CREATE TABLE Users(
	nickName VARCHAR(30)	NOT NULL,
	firstName	VARCHAR(30)	NOT NULL,
	lastName	VARCHAR(30)	NOT NULL,
	password	VARCHAR(30)	NOT NULL,
	PRIMARY KEY (nickName)
);

CREATE TABLE Products(
	name VARCHAR(30)	NOT NULL,
	category	VARCHAR(30)	NOT NULL,
	price	DOUBLE(5,2)	NOT NULL,
	PRIMARY KEY (name)
);

CREATE TABLE Carts(
	id	int	NOT NULL AUTO_INCREMENT,
	nickName VARCHAR(30)	NOT NULL,
	PRIMARY KEY (id,nickName),
	FOREIGN KEY(nickName) REFERENCES Users(nickName) ON DELETE CASCADE
);
CREATE TABLE CartRows(
	id	int	NOT NULL,
	name VARCHAR(30)	NOT NULL,
	quantity	int	NOT NULL,
	PRIMARY KEY (id,name),
	FOREIGN KEY(id) REFERENCES Carts(id) ON DELETE CASCADE,
	FOREIGN KEY(name) REFERENCES Products(name) ON DELETE CASCADE
);
