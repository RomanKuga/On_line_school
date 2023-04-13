package com.univer.baseEntity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "lecture", schema = "on_line_school")
@IdClass(LectureEntityPK.class)
public class LectureEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idLecture", nullable = false)
    private int idLecture;
    @Basic
    @Column(name = "idCourse", nullable = false)
    private int idCourse;
    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idPerson", nullable = false)
    private int idPerson;
    @Basic
    @Column(name = "description", nullable = true, length = 45)
    private String description;
    @Basic
    @Column(name = "dateTime", nullable = false)
    private Timestamp dateTime;

    public int getIdLecture() {
        return idLecture;
    }

    public void setIdLecture(int idLecture) {
        this.idLecture = idLecture;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LectureEntity that = (LectureEntity) o;
        return idLecture == that.idLecture && idCourse == that.idCourse && idPerson == that.idPerson && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(dateTime, that.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLecture, idCourse, name, idPerson, description, dateTime);
    }
}
