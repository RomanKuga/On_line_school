package com.univer.baseEntity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "course", schema = "on_line_school")
public class CourseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCourse", nullable = false)
    private int idCourse;
    @Basic
    @Column(name = "Course_name", nullable = false, length = 100)
    private String courseName;

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }




    @Override
    public String toString() {
        return "//  Course id = " +  getIdCourse()  + "/ Name Course--  " + getCourseName() + "//";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseEntity that = (CourseEntity) o;
        return idCourse == that.idCourse && Objects.equals(courseName, that.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCourse, courseName);
    }
}
