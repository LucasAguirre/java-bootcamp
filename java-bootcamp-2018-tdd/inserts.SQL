USE Market;

INSERT INTO Users (nickName,firstName,lastName,password) VALUES ('User1NickName','User1FirstName','User1LastName','User1Password');
INSERT INTO Users (nickName,firstName,lastName,password) VALUES ('User2NickName','User2FirstName','User2LastName','User2Password');
INSERT INTO Users (nickName,firstName,lastName,password) VALUES ('User3NickName','User3FirstName','User3LastName','User3Password');
INSERT INTO Users (nickName,firstName,lastName,password) VALUES ('User4NickName','User4FirstName','User4LastName','User4Password');
INSERT INTO Users (nickName,firstName,lastName,password) VALUES ('User5NickName','User5FirstName','User5LastName','User5Password');
INSERT INTO Users (nickName,firstName,lastName,password) VALUES ('User6NickName','User6FirstName','User6LastName','User6Password');
INSERT INTO Users (nickName,firstName,lastName,password) VALUES ('User7NickName','User7FirstName','User7LastName','User7Password');

INSERT INTO Products (name,category,price) VALUES ('Product1Name','Category1',10);
INSERT INTO Products (name,category,price) VALUES ('Product2Name','Category2',20);
INSERT INTO Products (name,category,price) VALUES ('Product3Name','Category2',30);
INSERT INTO Products (name,category,price) VALUES ('Product4Name','Category3',40);
INSERT INTO Products (name,category,price) VALUES ('Product5Name','Category3',50);
INSERT INTO Products (name,category,price) VALUES ('Product6Name','Category3',60);

INSERT INTO Carts (nickName) VALUES ('User6NickName');
INSERT INTO Carts (nickName) VALUES ('User7NickName');

INSERT INTO CartRows (id,name,quantity) VALUES (1,'Product6Name',1);
INSERT INTO CartRows (id,name,quantity) VALUES (1,'Product5Name',2);
INSERT INTO CartRows (id,name,quantity) VALUES (2,'Product1Name',1);
INSERT INTO CartRows (id,name,quantity) VALUES (2,'Product2Name',2);
INSERT INTO CartRows (id,name,quantity) VALUES (2,'Product3Name',3);

