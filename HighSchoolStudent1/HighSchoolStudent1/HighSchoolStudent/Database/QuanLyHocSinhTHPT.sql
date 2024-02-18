CREATE DATABASE StudentManagementSystem
GO
USE SMS_Java
GO
/*============================================ NGƯỜI DÙNG VÀ VAI TRÒ NGƯỜI DÙNG ================================*/
CREATE TABLE [Role] 
(
	Role_ID VARCHAR(50) PRIMARY KEY NOT NULL,
	Role_Name NVARCHAR(250) NOT NULL,
	[Status] INT
)

GO

CREATE TABLE [Function]
(
	Function_ID VARCHAR(50) PRIMARY KEY NOT NULL,
	Function_Name NVARCHAR(250) NOT NULL,
	[Status] INT
)

GO



CREATE TABLE Permission_Detail
(
	PermissionDetail_ID VARCHAR(50) PRIMARY KEY NOT NULL,
	Role_ID VARCHAR(50) NOT NULL,
	Function_ID VARCHAR(50) NOT NULL,
	[Action] NVARCHAR(250)
)

GO

ALTER TABLE Permission_Detail
ADD CONSTRAINT PermissionDetail_Role_ID
FOREIGN KEY (Role_ID) REFERENCES [Role](Role_ID)
go

ALTER TABLE Permission_Detail
ADD CONSTRAINT PermissionDetail_Function_ID
FOREIGN KEY (Function_ID) REFERENCES [Function](Function_ID)

GO


CREATE TABLE [User]
(
	[User_ID] VARCHAR(50) PRIMARY KEY NOT NULL,
	Username VARCHAR(250) NOT NULL,
	[Password] VARCHAR(250) NOT NULL,
	[Role_ID] VARCHAR(50) NOT NULL,
)

GO

ALTER TABLE [User]
ADD CONSTRAINT User_RoleID
FOREIGN KEY (Role_ID) REFERENCES [Role](Role_ID)

GO


/*==============================================================================================================*/
GO

/*=============================================================================================================*/

GO

/*=============================================== NĂM HỌC =====================================================*/
CREATE TABLE SchoolYear
(
	SchoolYear_ID VARCHAR(50) PRIMARY KEY NOT NULL,
	SchoolYear_Name NVARCHAR(250),
	[Start_Date] Varchar(10),
	[End_Date] Varchar(10)
)

/*=============================================================================================================*/

GO

/* =============================================== HỌC KỲ =====================================================*/
CREATE TABLE Semester
(
	Semester_ID VARCHAR(50) PRIMARY KEY NOT NULL,
	Semester_Name NVARCHAR(250),
	[Start_Date] varchar(10),
	[End_Date] varchar(10),
	SchoolYear_ID VARCHAR(50),
)

GO

ALTER TABLE Semester
ADD CONSTRAINT FK_Semester_SchoolYearID
FOREIGN KEY (SchoolYear_ID) REFERENCES SchoolYear(SchoolYear_ID)
/*=============================================================================================================*/

GO

/*================================================ KHỐI LỚP ===================================================*/
CREATE TABLE Grade
(
	Grade_ID VARCHAR(50) PRIMARY KEY NOT NULL,
    Grade_Name NVARCHAR(250)
)



/*==============================================================================================================*/

GO

/*============================================== MÔN HỌC =======================================================*/
CREATE TABLE [Subject]
(
	Subject_ID VARCHAR(50) PRIMARY KEY NOT NULL,
    Subject_Name NVARCHAR(250),
    Coefficient INT,
    Number_Of_Lesson INT
)


/*==============================================================================================================*/

GO

/*============================================== GIÁO VIÊN =====================================================*/
CREATE TABLE Teacher
(
	Teacher_ID VARCHAR(50) PRIMARY KEY NOT NULL,
    Teacher_Name NVARCHAR(250),
    Date_Of_Birth Varchar(10),
    Gender NVARCHAR(10),
    Phone VARCHAR(10),
    Email VARCHAR(250),
    [Address] NVARCHAR(250),
    [Status] INT,
    [Image] VARCHAR(250),
	Subject_ID VARCHAR(50),
)

GO

ALTER TABLE Teacher
ADD CONSTRAINT FK_Teacher_SubjectID 
FOREIGN KEY (Subject_ID) REFERENCES [Subject](Subject_ID)


ALTER TABLE [User]
ADD CONSTRAINT FK_User_TeacherID
FOREIGN KEY ([User_ID]) REFERENCES Teacher(Teacher_ID)

/*==============================================================================================================*/
GO

/*==============================================================================================================*/


INSERT INTO Teacher (Teacher_ID, Teacher_Name, Date_Of_Birth, Gender, Phone, Email, [Address], [Status])
VALUES 
    ('T001', N'Admin', '2003-09-22', N'Nam', '1234567890', 'quyquach@gmail.com', N'Quận 5', 1)

ALTER TABLE [User] 
ADD CONSTRAINT User_TeacherID
FOREIGN KEY ([User_ID]) REFERENCES Teacher(Teacher_ID)

INSERT INTO [User] VALUES
('T001', 'QuachQuy', '123456', 'RL001')



/*==============================================================================================================*/


GO

/*================================================ LỚP HỌC =======================================================*/
CREATE TABLE Class
(
	Class_ID VARCHAR(50) PRIMARY KEY NOT NULL,
    Class_Name NVARCHAR(250),
	Grade_ID VARCHAR(50),
	Quantity INT,
	SchoolYear_ID VARCHAR(50),
	Teacher_ID VARCHAR(50)
)

GO

ALTER TABLE Class
ADD CONSTRAINT FK_Class_Grade_ID
FOREIGN KEY (Grade_ID) REFERENCES Grade(Grade_ID)

ALTER TABLE Class
ADD CONSTRAINT FK_Class_SchoolYearID
FOREIGN KEY (SchoolYear_ID) REFERENCES SchoolYear(SchoolYear_ID)

/*=====================================================================================================================*/

GO

/* ========================================= GIÁO VIÊN - LỚP (CHỦ NHIỆM) ===============================================*/


ALTER TABLE Class
ADD CONSTRAINT FK_Class_TeacherID
FOREIGN KEY (Teacher_ID) REFERENCES Teacher(Teacher_ID)

/*======================================================================================================================*/

GO

/* ======================================== PHÂN CÔNG GIẢNG DẠY =========================================================*/
CREATE TABLE TeachingAssignment
(
	Assignment_ID VARCHAR(50) PRIMARY KEY NOT NULL,
    Teacher_ID VARCHAR(50),
    Class_ID VARCHAR(50),
	SchoolYear_ID VARCHAR(50),
	Subject_ID VARCHAR(50)

)

GO

ALTER TABLE TeachingAssignment
ADD CONSTRAINT FK_TeachingAssignment_TeacherID
FOREIGN KEY (Teacher_ID) REFERENCES Teacher(Teacher_ID)


GO

ALTER TABLE TeachingAssignment
ADD CONSTRAINT FK_TeachingAssignment_ClassID
FOREIGN KEY (Class_ID) REFERENCES Class(Class_ID)



/* ======================================================================================================================= */
GO
/*========================================= HỌC SINH ====================================================================*/
CREATE TABLE Student
(
	Student_ID VARCHAR(50) PRIMARY KEY NOT NULL,
    Student_Name NVARCHAR(250),
    Date_Of_Birth Varchar(10),
    Gender NVARCHAR(10),
    Phone VARCHAR(10),
    Email VARCHAR(250),
    [Address] NVARCHAR(250),
    [Status] INT,
    [Image] VARCHAR(250),
	Class_ID VARCHAR(50),
	FOREIGN KEY (Class_ID) REFERENCES Class(Class_ID)

)



/*=========================================================================================================================*/
GO

/*================================================= ĐIỂM HỌC SINH - MÔN HỌC================================================*/
CREATE TABLE Student_Mark_Subject
(
	Student_ID VARCHAR(50) NOT NULL,
	Subject_ID VARCHAR(50) NOT NULL,
	Semester_ID VARCHAR(50) NOT NULL,
	SchoolYear_ID VARCHAR(50) NOT NULL,
	Mark_1_1 FLOAT,
	Mark_1_2 FLOAT,
	Mark_1_15M FLOAT,
	Mark_2_1P FLOAT,
	Mark_3_F FLOAT,
	Mark_Avg FLOAT,
	PRIMARY KEY(Student_ID, SchoolYear_ID, Subject_ID, Semester_ID),
)

GO

ALTER TABLE Student_Mark_Subject
ADD CONSTRAINT FK_StudentMarkID_StudentID
FOREIGN KEY (Student_ID) REFERENCES Student(Student_ID)

GO

ALTER TABLE Student_Mark_Subject
ADD CONSTRAINT FK_StuRdentMarkID_SubjectID
FOREIGN KEY (Subject_ID) REFERENCES [Subject](Subject_ID)

GO

ALTER TABLE Student_Mark_Subject
ADD CONSTRAINT FK_StudentMarkID_SemesterID
FOREIGN KEY (Semester_ID) REFERENCES Semester(Semester_ID)

GO

ALTER TABLE Student_Mark_Subject
ADD CONSTRAINT FK_StudentMarkID_SchoolYearID
FOREIGN KEY (SchoolYear_ID) REFERENCES SchoolYear(SchoolYear_ID)

/*=========================================================================================================================*/


CREATE TABLE Student_Mark_Final
(
	Student_ID VARCHAR(6) NOT NULL,
	SchoolYear_ID VARCHAR(6) NOT NULL,
	Dis_Result VARCHAR(6) NOT NULL,
	Mark_1 FLOAT NOT NULL,
	Mark_2 FLOAT NOT NULL,
	Mark_Final FLOAT NOT NULL, 
	PRIMARY KEY(Student_ID, SchoolYear_ID)
)


CREATE TABLE Discipline
(
	Dis_ID VARCHAR(50),
	Dis_Content NVARCHAR(255),
	Dis_Score FLOAT
)


GO

CREATE TABLE Discliprorole
(
	Role_ID NVARCHAR(50),
	Role_Content NVARCHAR(255)

)
/*

use master
drop database StudentManagementSystem
delete from [User]
delete from Teacher
delete from [Class]
delete from Student
delete from teachingAssignment
select * from [user]
*/
