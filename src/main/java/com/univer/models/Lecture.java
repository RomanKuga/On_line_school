package com.univer.models;

import com.univer.repository.RepositoryHomeWork;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Lecture extends MasterModels implements Serializable {

    @Serial
    private static final long serialVersionUID = 1766929690445523022L;
    private static int calc;
    private Integer id;
    private Integer courseID;
    private String name;
    private String description;
    private Integer personId;
    private LocalDateTime holdingTimeLecture;
    private String holdingTimeString;
    private int number;
    RepositoryHomeWork homeWork;

    public Lecture(Integer id, Integer courseID, String name, Integer personId, String description, RepositoryHomeWork homeWork, LocalDateTime holdingTimeLecture) {
        this.id = id;
        this.courseID = courseID;
        this.name = name;
        this.personId = personId;
        this.description = description;
        this.homeWork = homeWork;
        this.holdingTimeLecture = holdingTimeLecture;
        calc++;
    }

    public Lecture(Integer id, Integer courseID, String name, Integer personId, String description, String holdingTimeString) {
        this.id = id;
        this.courseID = courseID;
        this.name = name;
        this.personId = personId;
        this.description = description;
        this.holdingTimeString = holdingTimeString;
        calc++;
    }

    public LocalDateTime getHoldingTimeLecture() {
        return holdingTimeLecture;
    }

     public Lecture() {
       }
    public Lecture(Integer id, String name, String holdingTimeString, int number) {
        this.id = id;
        this.name = name;
        this.holdingTimeString = holdingTimeString;
        this.number = number;
    }

    public int getCalcLecture() {
        return calc;
    }

    public int getNumber() {
        return number;
    }

    public int getLecturePersonId() {
        return personId;
    }


    public int getID() {
        return id;
    }

    @Override
    public Integer getLectureId() {
        return super.getID();
    }


    public int getCourseIDLecture() {

        return courseID;
    }

    public RepositoryHomeWork getHomeWork() {
        return homeWork;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCourseID() {
        return courseID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPersonId() {
        return personId;
    }

    public String getHoldingTimeString() {
        return holdingTimeString;
    }

    @Override
    public String toString() {
        if (getHomeWork() != null) {
            return "//  Int object with id = " + getID() + "/  CourseID--  " + courseID + "/ NameLecture-- " + name +
                    "/ PersonID-- " + personId + "/ Description-- " + description + "/ HomeWork-- є домашнє завдання/" + "Date and time - " + holdingTimeString + "\n";
        } else {
            return "//  Int object with id = " + getID() + "/  CourseID--  " + courseID + "/ NameLecture-- " + name +
                    "/ PersonID-- " + personId + "/ Description-- " + description + "/ HomeWork--домашнє завдання відсутнє/" + "Date and time - " + holdingTimeString + "\n";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lecture that = (Lecture) o;
        return id.equals(that.id) && Objects.equals(courseID, that.courseID) && Objects.equals(name, that.name) && Objects.equals(personId, that.personId) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseID, name, personId, description, holdingTimeString);
    }
}
