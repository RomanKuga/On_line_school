CREATE TABLE `course` (
                          `idCourse` int NOT NULL,
                          `Course_name` varchar(100) NOT NULL,
                          PRIMARY KEY (`idCourse`),
                          UNIQUE KEY `idCourse_UNIQUE` (`idCourse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

INSERT INTO `on_line_school`.`course` (`idCourse`, `Course_name`) VALUES (1, "History")
INSERT INTO `on_line_school`.`course` (`idCourse`, `Course_name`) VALUES (2, "Ukraine history")
INSERT INTO `on_line_school`.`course` (`idCourse`, `Course_name`) VALUES (3, "Algebra")
INSERT INTO `on_line_school`.`course` (`idCourse`, `Course_name`) VALUES (4, "Geometry")

CREATE TABLE `lecture` (
                           `idLecture` int NOT NULL,
                           `idCourse` int NOT NULL,
                           `name` varchar(45) NOT NULL,
                           `idPerson` int NOT NULL,
                           `description` varchar(45) DEFAULT NULL,
                           `dateTime` datetime NOT NULL,
                           PRIMARY KEY (`idLecture`),
                           UNIQUE KEY `idLecture_UNIQUE` (`idLecture`),
                           KEY `Course_idx` (`idCourse`),
                           CONSTRAINT `Course` FOREIGN KEY (`idCourse`) REFERENCES `course` (`idCourse`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

INSERT INTO `on_line_school`.`lecture` (`idLecture`, `idCourse`, `name`, `idPerson`, `description`, `dateTime`) VALUES (1, 1, "History 10st", 12, "Test1", "2023-01-12 11:11")
INSERT INTO `on_line_school`.`lecture` (`idLecture`, `idCourse`, `name`, `idPerson`, `description`, `dateTime`) VALUES (2, 1, "History 12st", 12, "Test1", "2023-01-14 12:00")
INSERT INTO `on_line_school`.`lecture` (`idLecture`, `idCourse`, `name`, `idPerson`, `description`, `dateTime`) VALUES (3, 2, "History Ukraine 10-12st", 12, "Test3", "2023-01-13 12:00")
INSERT INTO `on_line_school`.`lecture` (`idLecture`, `idCourse`, `name`, `idPerson`, `description`, `dateTime`) VALUES (4, 2, "History Ukraine 16-17st", 14, "Test4", "2023-01-20 12:00")
INSERT INTO `on_line_school`.`lecture` (`idLecture`, `idCourse`, `name`, `idPerson`, `description`, `dateTime`) VALUES (5, 3, "Algebra", 15, "Test5", "2023-01-24 12:00")

CREATE TABLE `person` (
                          `idperson` int NOT NULL,
                          `idCourse` int NOT NULL,
                          `role` varchar(45) NOT NULL,
                          `firstname` varchar(45) NOT NULL,
                          `secondName` varchar(45) NOT NULL,
                          `phone` decimal(10,0) NOT NULL,
                          `email` varchar(45) NOT NULL,
                          PRIMARY KEY (`idperson`),
                          UNIQUE KEY `idperson_UNIQUE` (`idperson`),
                          KEY `Course_idx` (`idCourse`),
                          CONSTRAINT `course_key2` FOREIGN KEY (`idCourse`) REFERENCES `course` (`idCourse`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

INSERT INTO `on_line_school`.`person` (`idperson`, `idCourse`, `role`, `firstname`, `secondName`, `phone`, `email`) VALUES (1, 1, "Student", "Petro", "Petrov", 0991234567, "twert1@gmail.com")
INSERT INTO `on_line_school`.`person` (`idperson`, `idCourse`, `role`, `firstname`, `secondName`, `phone`, `email`) VALUES (2, 1, "Student", "Ivan", "Ivanov", 0502345678, "gasdf455555@gmail.com")
INSERT INTO `on_line_school`.`person` (`idperson`, `idCourse`, `role`, `firstname`, `secondName`, `phone`, `email`) VALUES (3, 1, "Student", "Vasil", "Ivanchov", 0502345328, "hasd12f1@gmail.com")
INSERT INTO `on_line_school`.`person` (`idperson`, `idCourse`, `role`, `firstname`, `secondName`, `phone`, `email`) VALUES (4, 2, "Student", "Oksana", "Fedorishin", 0991238567, "dwertsddf@gmail.com")
INSERT INTO `on_line_school`.`person` (`idperson`, `idCourse`, `role`, `firstname`, `secondName`, `phone`, `email`) VALUES (5, 2, "Student", "Roman", "Kirpa", 0502345688, "yasdfwer@gmail.com")
INSERT INTO `on_line_school`.`person` (`idperson`, `idCourse`, `role`, `firstname`, `secondName`, `phone`, `email`) VALUES (6, 2, "Student", "Nataliya", "Kirpa", 0502349328, "basd12f1yutr@gmail.com")
INSERT INTO `on_line_school`.`person` (`idperson`, `idCourse`, `role`, `firstname`, `secondName`, `phone`, `email`) VALUES (7, 1, "Student", "Nataliya", "Kirpa", 0502349328, "basd12f1yutr@gmail.com")
INSERT INTO `on_line_school`.`person` (`idperson`, `idCourse`, `role`, `firstname`, `secondName`, `phone`, `email`) VALUES (8, 3, "Student", "Olena", "Perig", 0991234567, "vwert233@gmail.com")
INSERT INTO `on_line_school`.`person` (`idperson`, `idCourse`, `role`, `firstname`, `secondName`, `phone`, `email`) VALUES (9, 3, "Student", "Boris", "Napuda", 502345328, "zasd12f45@gmail.com")
INSERT INTO `on_line_school`.`person` (`idperson`, `idCourse`, `role`, `firstname`, `secondName`, `phone`, `email`) VALUES (10, 3, "Student", "Misha", "Ogrizko", 0502555328, "masd12f67@gmail.com")
INSERT INTO `on_line_school`.`person` (`idperson`, `idCourse`, `role`, `firstname`, `secondName`, `phone`, `email`) VALUES (11, 4, "Student", "Jana", "Janko", 0502345328, "iasd12f9887@gmail.com")
INSERT INTO `on_line_school`.`person` (`idperson`, `idCourse`, `role`, `firstname`, `secondName`, `phone`, `email`) VALUES (12, 1, "Teacher", "Fedor", "Kish", 0991234567, "wert@gmail.com")
INSERT INTO `on_line_school`.`person` (`idperson`, `idCourse`, `role`, `firstname`, `secondName`, `phone`, `email`) VALUES (14, 2, "Teacher", "Oleg", "Nemesh", 0502345678, "asdf@gmail.com")
INSERT INTO `on_line_school`.`person` (`idperson`, `idCourse`, `role`, `firstname`, `secondName`, `phone`, `email`) VALUES (15, 3, "Teacher", "Ivan", "Krug", 0502345328, "rasd12f@gmail.com")
INSERT INTO `on_line_school`.`person` (`idperson`, `idCourse`, `role`, `firstname`, `secondName`, `phone`, `email`) VALUES (13, 2, "Teacher", "Fedor", "Kish", 0991234567, "wert@gmail.com")


CREATE TABLE `homework` (
                            `idhomeWork` int NOT NULL,
                            `idLecture` int NOT NULL,
                            `task` varchar(45) NOT NULL,
                            PRIMARY KEY (`idhomeWork`),
                            UNIQUE KEY `idhomeWork_UNIQUE` (`idhomeWork`),
                            KEY `lectue_key_idx` (`idLecture`),
                            CONSTRAINT `lectue_key` FOREIGN KEY (`idLecture`) REFERENCES `lecture` (`idLecture`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

INSERT INTO `on_line_school`.`homework` (`idhomeWork`, `idLecture`, `task`) VALUES (1, 1, "Homeworktest")
INSERT INTO `on_line_school`.`homework` (`idhomeWork`, `idLecture`, `task`) VALUES (2, 2, "Homeworktest1")
INSERT INTO `on_line_school`.`homework` (`idhomeWork`, `idLecture`, `task`) VALUES (3, 1, "Homeworktest2")
INSERT INTO `on_line_school`.`homework` (`idhomeWork`, `idLecture`, `task`) VALUES (4, 2, "Homeworktest3")
INSERT INTO `on_line_school`.`homework` (`idhomeWork`, `idLecture`, `task`) VALUES (5, 3, "Homeworktest4")

CREATE TABLE `addmaterial` (
                               `idaddMaterial` int NOT NULL,
                               `nameAddMaterial` varchar(45) NOT NULL,
                               `idLecture` int NOT NULL,
                               `resourseType` varchar(45) NOT NULL,
                               PRIMARY KEY (`idaddMaterial`),
                               UNIQUE KEY `idaddMaterial_UNIQUE` (`idaddMaterial`),
                               UNIQUE KEY `nameAddMaterial_UNIQUE` (`nameAddMaterial`),
                               KEY `lecture_key2_idx` (`idLecture`),
                               CONSTRAINT `lecture_key2` FOREIGN KEY (`idLecture`) REFERENCES `lecture` (`idLecture`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

INSERT INTO `on_line_school`.`addmaterial` (`idaddMaterial`, `nameAddMaterial`, `idLecture`, `resourseType`) VALUES (1, "text stor 1", 1, "BOOK")
INSERT INTO `on_line_school`.`addmaterial` (`idaddMaterial`, `nameAddMaterial`, `idLecture`, `resourseType`) VALUES (2, "text stor 12", 2, "URL")
INSERT INTO `on_line_school`.`addmaterial` (`idaddMaterial`, `nameAddMaterial`, `idLecture`, `resourseType`) VALUES (3, "text stor 11", 3, "URL")
INSERT INTO `on_line_school`.`addmaterial` (`idaddMaterial`, `nameAddMaterial`, `idLecture`, `resourseType`) VALUES (4, "text stor 2", 4, "VIDEO")
INSERT INTO `on_line_school`.`addmaterial` (`idaddMaterial`, `nameAddMaterial`, `idLecture`, `resourseType`) VALUES (5, "text vaa", 5, "BOOK")
