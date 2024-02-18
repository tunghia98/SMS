CREATE DATABASE StudentManagementSystem
GO
USE StudentManagementSystem
GO
/*============================================ NGƯỜI DÙNG VÀ VAI TRÒ NGƯỜI DÙNG ================================*/
CREATE TABLE [Role] 
(
	RoleID VARCHAR(50) PRIMARY KEY NOT NULL,
	RoleName NVARCHAR(250) NOT NULL
)

GO

CREATE TABLE [User]
(
	[UserID] VARCHAR(50) PRIMARY KEY NOT NULL,
	RoleID VARCHAR(50) NOT NULL,
	Username VARCHAR(250) NOT NULL,
	[Password] VARCHAR(250) NOT NULL
)

GO

ALTER TABLE [User]
ADD CONSTRAINT FK_User_RoleID
FOREIGN KEY (RoleID) REFERENCES [Role](RoleID)

/*==============================================================================================================*/
GO

/*============================================== DÂN TỘC =======================================================*/

CREATE TABLE Ethnic
(
	EthnicID VARCHAR(50) PRIMARY KEY NOT NULL,
    EthnicName NVARCHAR(250)
)

/*==============================================================================================================*/

GO

/*============================================= TÔN GIÁO =======================================================*/
CREATE TABLE Religion
(
	ReligionID VARCHAR(50) PRIMARY KEY NOT NULL,
    ReligionName NVARCHAR(250)
)
/*=============================================================================================================*/

GO

/*=============================================== NĂM HỌC =====================================================*/
CREATE TABLE SchoolYear
(
	SchoolYearID VARCHAR(50) PRIMARY KEY NOT NULL,
	SchoolYearName NVARCHAR(250),
	StartDate DATETIME,
	EndDate DATETIME
)

-- Thêm dữ liệu vào bảng năm học 
-- Thêm một số bản ghi vào bảng SchoolYear
INSERT INTO SchoolYear (SchoolYearID, SchoolYearName, StartDate, EndDate)
VALUES ('2021-2022', N'Năm học 2021-2022', '2021-09-01', '2022-06-30'),
       ('2022-2023', N'Năm học 2022-2023', '2022-09-01', '2023-06-30'),
       ('2023-2024', N'Năm học 2023-2024', '2023-09-01', '2024-06-30');
/*=============================================================================================================*/

GO

/* =============================================== HỌC KỲ =====================================================*/
CREATE TABLE Semester
(
	SemesterID VARCHAR(50) PRIMARY KEY NOT NULL,
	SemesterName NVARCHAR(250),
	[StartDate] DATETIME,
	[EndDate] DATETIME,
	SchoolYearID VARCHAR(50),
)

GO

ALTER TABLE Semester
ADD CONSTRAINT FK_Semester_SchoolYearID
FOREIGN KEY (SchoolYearID) REFERENCES SchoolYear(SchoolYearID)
/*=============================================================================================================*/

GO

/*================================================ KHỐI LỚP ===================================================*/
CREATE TABLE Grade
(
	GradeID VARCHAR(50) PRIMARY KEY NOT NULL,
    GradeName NVARCHAR(250)
)
/*==============================================================================================================*/

GO

/*============================================== MÔN HỌC =======================================================*/
CREATE TABLE [Subject]
(
	SubjectID VARCHAR(50) PRIMARY KEY NOT NULL,
    SubjectName NVARCHAR(250),
    Coefficient INT,
    NumberOfLesson INT
)

INSERT INTO [Subject] (SubjectID, SubjectName, Coefficient, NumberOfLesson)
VALUES ('SUB001', N'Toán học', 2, 40);

INSERT INTO [Subject] (SubjectID, SubjectName, Coefficient, NumberOfLesson)
VALUES ('SUB002', N'Hóa học', 3, 30);

INSERT INTO [Subject] (SubjectID, SubjectName, Coefficient, NumberOfLesson)
VALUES ('SUB003', N'Ngữ văn', 2, 45);

INSERT INTO [Subject] (SubjectID, SubjectName, Coefficient, NumberOfLesson)
VALUES ('SUB004', N'Lịch sử', 2, 35);

INSERT INTO [Subject] (SubjectID, SubjectName, Coefficient, NumberOfLesson)
VALUES ('SUB005', N'Vật lý', 3, 32);

INSERT INTO [Subject] (SubjectID, SubjectName, Coefficient, NumberOfLesson)
VALUES ('SUB006', N'Địa lý', 1, 30);

INSERT INTO [Subject] (SubjectID, SubjectName, Coefficient, NumberOfLesson)
VALUES ('SUB007', N'Tiếng Anh', 2, 50);


/*==============================================================================================================*/

GO

/*============================================= HỌC LỰC ========================================================*/
CREATE TABLE AcademicLevel
(
    AcademicLevelID VARCHAR(50) PRIMARY KEY NOT NULL,
    AcademicLevelName NVARCHAR(250) NOT NULL,
    MinimumScore FLOAT NOT NULL,
    MaximumScore FLOAT NOT NULL,
    UnboundedScore FLOAT NOT NULL,

)
/*==============================================================================================================*/

GO

/*============================================= HẠNH KIỂM ========================================================*/
CREATE TABLE Conduct
(
    ConductID VARCHAR(50) PRIMARY KEY NOT NULL,
    ConductName NVARCHAR(250) NOT NULL
)
/*==============================================================================================================*/

GO

/*============================================ KẾT QUẢ CUỐI NĂM ================================================*/
CREATE TABLE AcademicResult
(
    ResultID VARCHAR(50) PRIMARY KEY NOT NULL,
    ResultName NVARCHAR(250) NOT NULL
)
/*==============================================================================================================*/

GO

/*============================================== GIÁO VIÊN =====================================================*/
CREATE TABLE Teacher
(
	TeacherID VARCHAR(50) PRIMARY KEY NOT NULL,
    TeacherName NVARCHAR(250),
    DateOfBirth DATETIME,
    Gender NVARCHAR(10),
    Phone VARCHAR(10),
    Email VARCHAR(250),
    [Address] NVARCHAR(250),
    [Status] BIT,
    [Image] VARCHAR(250),
	SubjectID VARCHAR(50),
	ClassID VARCHAR(50),
)

GO

ALTER TABLE Teacher
ADD CONSTRAINT FK_Teacher_SubjectID 
FOREIGN KEY (SubjectID) REFERENCES [Subject](SubjectID)

/*==============================================================================================================*/

GO

/*================================================ LỚP HỌC =======================================================*/
CREATE TABLE Class
(
	ClassID VARCHAR(50) PRIMARY KEY NOT NULL,
    ClassName NVARCHAR(250),
	GradeID VARCHAR(50) NOT NULL,
	Quantity INT,
	SchoolYearID VARCHAR(50),
	TeacherID VARCHAR(50),
)

GO

ALTER TABLE Class
ADD CONSTRAINT FK_Class_GradeID
FOREIGN KEY (GradeID) REFERENCES Grade(GradeID)

/*=====================================================================================================================*/

GO

/* ========================================= GIÁO VIÊN - LỚP (CHỦ NHIỆM) ===============================================*/


ALTER TABLE Teacher
ADD CONSTRAINT FK_Teacher_ClassID
FOREIGN KEY (ClassID) REFERENCES Class(ClassID)

GO 

ALTER TABLE Class
ADD CONSTRAINT FK_Class_TeacherID
FOREIGN KEY (TeacherID) REFERENCES Teacher(TeacherID)

/*======================================================================================================================*/

GO

/* ======================================== PHÂN CÔNG GIẢNG DẠY =========================================================*/
CREATE TABLE TeachingAssignment
(
	AssignmentID VARCHAR(50) PRIMARY KEY NOT NULL,
    TeacherID VARCHAR(50),
    ClassID VARCHAR(50),
    SubjectID VARCHAR(50),
	SchoolYearID VARCHAR(50),
    [DayOfWeek] NVARCHAR(250),
    [Period] INT
)

GO

ALTER TABLE TeachingAssignment
ADD CONSTRAINT FK_TeachingAssignment_TeacherID
FOREIGN KEY (TeacherID) REFERENCES Teacher(TeacherID)


GO

ALTER TABLE TeachingAssignment
ADD CONSTRAINT FK_TeachingAssignment_ClassID
FOREIGN KEY (ClassID) REFERENCES Class(ClassID)

GO

ALTER TABLE TeachingAssignment
ADD CONSTRAINT FK_TeachingAssignment_SubjectID
FOREIGN KEY (SubjectID) REFERENCES [Subject](SubjectID)

GO

ALTER TABLE TeachingAssignment
ADD CONSTRAINT FK_TeachingAssignment_SchoolYearID
FOREIGN KEY (SchoolYearID) REFERENCES SchoolYear(SchoolYearID)

GO


/* ======================================================================================================================= */
GO
/*========================================= HỌC SINH ====================================================================*/
CREATE TABLE Student
(
	StudentID VARCHAR(50) PRIMARY KEY NOT NULL,
    StudentName NVARCHAR(250),
    DateOfBirth DATETIME,
    Gender NVARCHAR(10),
    Phone VARCHAR(10),
    Email VARCHAR(250),
    [Address] NVARCHAR(250),
    [Status] BIT,
    [Image] VARCHAR(250),
    EthniCID VARCHAR(50),
    ReligionID VARCHAR(50)
    FOREIGN KEY (EthnicID) REFERENCES Ethnic(EthnicID),
    FOREIGN KEY (ReligionID) REFERENCES  Religion(ReligionID),
)

/*=========================================================================================================================*/
GO

/*================================================= ĐIỂM HỌC SINH - MÔN HỌC================================================*/
CREATE TABLE Student_Mark_Subject
(
	MarkID VARCHAR(50) PRIMARY KEY NOT NULL,
	StudentID VARCHAR(50) NOT NULL,
	SubjectID VARCHAR(50) NOT NULL,
	SemesterID VARCHAR(50) NOT NULL,
	SchoolYearID VARCHAR(50) NOT NULL,
	Mark_1_1 FLOAT,
	Mark_1_2 FLOAT,
	Mark_1_15M FLOAT,
	Mark_2_1P FLOAT,
	Mark_3_F FLOAT,
	Mark_Avg FLOAT
)

GO

ALTER TABLE Student_Mark_Subject
ADD CONSTRAINT FK_StudentMarkSubject_StudentID
FOREIGN KEY (StudentID) REFERENCES Student(StudentID)

GO

ALTER TABLE Student_Mark_Subject
ADD CONSTRAINT FK_StudentMarkSubject_SubjectID
FOREIGN KEY (SubjectID) REFERENCES [Subject](SubjectID)

GO

ALTER TABLE Student_Mark_Subject
ADD CONSTRAINT FK_StudentMarkSubject_SemesterID
FOREIGN KEY (SemesterID) REFERENCES Semester(SemesterID)

GO

ALTER TABLE Student_Mark_Subject
ADD CONSTRAINT FK_StudentMarkSubject_SchoolYearID
FOREIGN KEY (SchoolYearID) REFERENCES SchoolYear(SchoolYearID)

/*=========================================================================================================================*/



USE MASTER
GO
DROP DATABASE StudentManagementSystem

SELECT SYSDATETIME()

SELECT CURRENT_TIMEZONE();
```

SELECT * FROM SchoolYear

SELECT SYSDATETIMEOFFSET() AS CurrentDateTimeOffset;