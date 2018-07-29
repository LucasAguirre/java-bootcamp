USE highschool;


INSERT INTO Teacher (firstName,lastName,dateOfBirth) VALUES ('TeacherOneFirstName','TeacherOneLastName','9/28/1985');
INSERT INTO Teacher (firstName,lastName,dateOfBirth) VALUES ('TeacherTwoFirstName','TeacherTwoLastName','5/15/1966');
INSERT INTO Teacher (firstName,lastName,dateOfBirth) VALUES ('TeacherThreeFirstName','TeacherThreeLastName','12/25/2000');


INSERT INTO Course (name,assignedTeacher,hoursByWeek) VALUES ('CouserOneName',1,12);
INSERT INTO Course (name,assignedTeacher,hoursByWeek) VALUES ('CouserTwoName',2,20);
INSERT INTO Course (name,assignedTeacher,hoursByWeek) VALUES ('CouserThreeName',3,4);


INSERT INTO ScheduleTime (courseId,dayOfWeek,startHour,finishHour) VALUES (1,'Tuesday','14:00','18:00');
INSERT INTO ScheduleTime (courseId,dayOfWeek,startHour,finishHour) VALUES (1,'Wednesday','8:30','11:30');
INSERT INTO ScheduleTime (courseId,dayOfWeek,startHour,finishHour) VALUES (1,'Friday','10:30','15:30');	
INSERT INTO ScheduleTime (courseId,dayOfWeek,startHour,finishHour) VALUES (2,'Tuesday','11:00','12:15');	
INSERT INTO ScheduleTime (courseId,dayOfWeek,startHour,finishHour) VALUES (2,'Thursday','8:00','17:45');	
INSERT INTO ScheduleTime (courseId,dayOfWeek,startHour,finishHour) VALUES (2,'Friday','12:00','21:00');	
INSERT INTO ScheduleTime (courseId,dayOfWeek,startHour,finishHour) VALUES (3,'Wednesday','9:30','13:30');	
	
	
INSERT INTO Student (firstName,lastName,dateOfBirth) VALUES ('StudentOneFirstName','StudentOneLastName','6/22/1999');
INSERT INTO Student (firstName,lastName,dateOfBirth) VALUES ('StudentTwoFirstName','StudentTwoLastName','6/22/1999');
INSERT INTO Student (firstName,lastName,dateOfBirth) VALUES ('StudentThreeFirstName','StudentThreeLastName','1/1/1998');
INSERT INTO Student (firstName,lastName,dateOfBirth) VALUES ('StudentFourFirstName','StudentFourLastName','3/4/1998');
INSERT INTO Student (firstName,lastName,dateOfBirth) VALUES ('StudentFiveFirstName','StudentFiveLastName','4/11/1999');
INSERT INTO Student (firstName,lastName,dateOfBirth) VALUES ('StudentSixFirstName','StudentSixLastName','5/15/1993');
INSERT INTO Student (firstName,lastName,dateOfBirth) VALUES ('StudentSevenFirstName','StudentSevenLastName','7/29/1995');
INSERT INTO Student (firstName,lastName,dateOfBirth) VALUES ('StudentEightFirstName','StudentEightLastName','5/28/1993');
INSERT INTO Student (firstName,lastName,dateOfBirth) VALUES ('StudentNineFirstName','StudentNineLastName','7/4/1995');
INSERT INTO Student (firstName,lastName,dateOfBirth) VALUES ('StudentTenFirstName','StudentTenLastName','11/13/1999');
INSERT INTO Student (firstName,lastName,dateOfBirth) VALUES ('StudentElevenFirstName','StudentElevenLastName','10/7/2000');
INSERT INTO Student (firstName,lastName,dateOfBirth) VALUES ('StudentTwelveFirstName','StudentTwelveLastName','5/25/1997');
INSERT INTO Student (firstName,lastName,dateOfBirth) VALUES ('StudentThirteenFirstName','StudentThirteenLastName','6/26/1998');
INSERT INTO Student (firstName,lastName,dateOfBirth) VALUES ('StudentFourteenFirstName','StudentFourteenLastName','9/22/1999');
INSERT INTO Student (firstName,lastName,dateOfBirth) VALUES ('StudentFiveteenFirstName','StudentFiveteenLastName','7/1/1996');
INSERT INTO Student (firstName,lastName,dateOfBirth) VALUES ('StudentSixteenFirstName','StudentSixteenLastName','8/7/1999');
INSERT INTO Student (firstName,lastName,dateOfBirth) VALUES ('StudentSeventeenFirstName','StudentSeventeenLastName','2/19/1999');
INSERT INTO Student (firstName,lastName,dateOfBirth) VALUES ('StudentEightteenFirstName','StudentEightteenLastName','3/14/1999');
INSERT INTO Student (firstName,lastName,dateOfBirth) VALUES ('StudentNineteenFirstName','StudentNineteenLastName','3/15/1999');
INSERT INTO Student (firstName,lastName,dateOfBirth) VALUES ('StudentTwentyFirstName','StudentTwentyLastName','6/16/1998');
INSERT INTO Student (firstName,lastName,dateOfBirth) VALUES ('StudentTwentyOneFirstName','StudentTwentyOneLastName','6/22/1998');
INSERT INTO Student (firstName,lastName,dateOfBirth) VALUES ('StudentTwentyTwoFirstName','StudentTwentyTwoLastName','6/21/1999');
INSERT INTO Student (firstName,lastName,dateOfBirth) VALUES ('StudentTwentyThreeFirstName','StudentTwentyThreeLastName','5/21/1999');
INSERT INTO Student (firstName,lastName,dateOfBirth) VALUES ('StudentTwentyFourFirstName','StudentTwentyFourLastName','4/5/1998');
INSERT INTO Student (firstName,lastName,dateOfBirth) VALUES ('StudentTwentyFiveFirstName','StudentTwentyFiveLastName','9/19/1994');
INSERT INTO Student (firstName,lastName,dateOfBirth) VALUES ('StudentTwentySixFirstName','StudentTwentySixLastName','7/8/1991');
INSERT INTO Student (firstName,lastName,dateOfBirth) VALUES ('StudentTwentySevenFirstName','StudentTwentySevenLastName','7/9/1995');
INSERT INTO Student (firstName,lastName,dateOfBirth) VALUES ('StudentTwentyEightFirstName','StudentTwentyEightLastName','8/9/1995');
INSERT INTO Student (firstName,lastName,dateOfBirth) VALUES ('StudentTwentyNineFirstName','StudentTwentyNineLastName','11/7/1996');
INSERT INTO Student (firstName,lastName,dateOfBirth) VALUES ('StudentThirtyFirstName','StudentThirtyLastName','12/30/1999');


INSERT INTO StudentXCourse VALUES (1,1,4,NULL,NULL,NULL);
INSERT INTO StudentXCourse VALUES (2,1,5,NULL,NULL,NULL);
INSERT INTO StudentXCourse VALUES (3,1,6,NULL,NULL,NULL);
INSERT INTO StudentXCourse VALUES (4,1,8,NULL,NULL,NULL);
INSERT INTO StudentXCourse VALUES (5,1,9,NULL,NULL,NULL);
INSERT INTO StudentXCourse VALUES (6,1,3,NULL,NULL,NULL);
INSERT INTO StudentXCourse VALUES (7,1,4,NULL,NULL,NULL);
INSERT INTO StudentXCourse VALUES (8,1,5,NULL,NULL,NULL);
INSERT INTO StudentXCourse VALUES (9,1,7,NULL,NULL,NULL);
INSERT INTO StudentXCourse VALUES (10,1,7,NULL,NULL,NULL);
INSERT INTO StudentXCourse VALUES (11,2,4,8,NULL,NULL);
INSERT INTO StudentXCourse VALUES (12,2,8,8,NULL,NULL);
INSERT INTO StudentXCourse VALUES (13,2,9,8,NULL,NULL);
INSERT INTO StudentXCourse VALUES (14,2,10,8,NULL,NULL);
INSERT INTO StudentXCourse VALUES (15,2,10,4,NULL,NULL);
INSERT INTO StudentXCourse VALUES (16,2,7,4,NULL,NULL);
INSERT INTO StudentXCourse VALUES (17,2,8,2,NULL,NULL);
INSERT INTO StudentXCourse VALUES (18,2,6,2,NULL,NULL);
INSERT INTO StudentXCourse VALUES (19,2,3,10,NULL,NULL);
INSERT INTO StudentXCourse VALUES (20,2,4,5,NULL,NULL);
INSERT INTO StudentXCourse VALUES (21,3,8,7,9,8);
INSERT INTO StudentXCourse VALUES (22,3,7,8,7,7);
INSERT INTO StudentXCourse VALUES (23,3,7,8,8,8);
INSERT INTO StudentXCourse VALUES (24,3,8,7,8,8);
INSERT INTO StudentXCourse VALUES (25,3,9,5,4,6);
INSERT INTO StudentXCourse VALUES (26,3,10,7,4,7);
INSERT INTO StudentXCourse VALUES (27,3,10,4,5,6);
INSERT INTO StudentXCourse VALUES (28,3,10,6,4,7);
INSERT INTO StudentXCourse VALUES (29,3,5,8,5,6);
INSERT INTO StudentXCourse VALUES (30,3,7,8,6,7);