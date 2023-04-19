package com.univer.baseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class LectureEntityPK implements Serializable {
    @Column(name = "idLecture", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLecture;
    @Column(name = "idPerson", nullable = false)
    @Id
    private int idPerson;

    public int getIdLecture() {
        return idLecture;
    }

    public void setIdLecture(int idLecture) {
        this.idLecture = idLecture;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LectureEntityPK that = (LectureEntityPK) o;
        return idLecture == that.idLecture && idPerson == that.idPerson;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLecture, idPerson);
    }
}
