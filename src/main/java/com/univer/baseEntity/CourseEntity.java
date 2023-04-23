package com.univer.baseEntity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "course", schema = "on_line_school")
//@Cacheable
//@org.hibernate.annotations.Cache(
//        usage = CacheConcurrencyStrategy.READ_WRITE)
public class CourseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCourse", nullable = false)
    private Long idCourse;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idCourse", cascade = CascadeType.ALL)
    public List<LectureEntity> lectureEntities;
    public List<LectureEntity> getLectureEntity() {
        return lectureEntities;
    }

    public void setLectureEntities(List<LectureEntity> lectureEntities) {
        this.lectureEntities = lectureEntities;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idCourse", cascade = CascadeType.ALL)
    public List<PersonEntity> personEntities;
    public List<PersonEntity> getPersonEntities() {
        return personEntities;
    }

    public void setPersonEntities(List<PersonEntity> personEntities) {
        this.personEntities = personEntities;
    }

    @Basic
    @Column(name = "Course_name", nullable = false, length = 100)
    private String courseName;

    public Long getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Long idCourse) {
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
