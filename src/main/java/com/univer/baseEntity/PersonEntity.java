package com.univer.baseEntity;

import jakarta.persistence.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.Objects;

@Entity
@Table(name = "person", schema = "on_line_school")
@Cacheable
@org.hibernate.annotations.Cache(
        usage = CacheConcurrencyStrategy.READ_WRITE)
public class PersonEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idPerson", nullable = false)
    private int idPerson;
    @Basic
    @Column(name = "idCourse", nullable = false, insertable=false, updatable = false)
    private int idCourse;
    @Basic
    @Column(name = "role", nullable = false, length = 45)
    private String role;
    @Basic
    @Column(name = "firstname", nullable = false, length = 45)
    private String firstname;
    @Basic
    @Column(name = "secondName", nullable = false, length = 45)
    private String secondName;
    @Basic
    @Column(name = "phone", nullable = false, precision = 0)
    private int phone;
    @Basic
    @Column(name = "email", nullable = false, length = 45)
    private String email;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idCourse")
    private CourseEntity courseEntity;
    public CourseEntity getCourseEntity() {
        return courseEntity;
    }
    public void setCourseEntity(CourseEntity courseEntity) {
        this.courseEntity = courseEntity;
    }
    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonEntity that = (PersonEntity) o;
        return idPerson == that.idPerson && idCourse == that.idCourse && phone == that.phone && Objects.equals(role, that.role) && Objects.equals(firstname, that.firstname) && Objects.equals(secondName, that.secondName) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPerson, idCourse, role, firstname, secondName, phone, email);
    }
}
