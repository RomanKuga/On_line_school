package com.univer.baseEntity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "lecture", schema = "on_line_school")
@Cacheable
@org.hibernate.annotations.Cache(
        usage = CacheConcurrencyStrategy.READ_WRITE)
public class LectureEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idLecture", nullable = false)
    private int idLecture;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idLecture", cascade = CascadeType.REMOVE)
    public List<HomeworkEntity> homeworkEntities;
    public List<HomeworkEntity> getHomeworkEntities() {
        return homeworkEntities;
    }
    public void setHomeworkEntities(List<HomeworkEntity> homeworkEntities) {
        this.homeworkEntities = homeworkEntities;
    }
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idLecture", cascade = CascadeType.ALL)
    public List<AddmaterialEntity> addMaterialEntities;
    public List<AddmaterialEntity> getAddMaterialEntities() {
        return addMaterialEntities;
    }
    public void setAddMaterialEntities(List<AddmaterialEntity> addMaterialEntities) {
        this.addMaterialEntities = addMaterialEntities;
    }
    @Basic
    @Column(name = "idCourse", nullable = false, insertable=false, updatable = false)
    @NotNull(message = "Поле курс повино бути заповнене")
    private int idCourse;
    @Basic
    @Column(name = "name", nullable = false, length = 45)
    @NotBlank(message = "Поле лекції повинно бути заповненим")
    private String name;

    @Basic
    @Column(name = "idPerson", nullable = false)
    @NotNull
    private int idPerson;
    @Basic
    @Column(name = "description", nullable = true, length = 45)
    @NotBlank
    private String description;
    @Basic
    @Column(name = "dateTime", nullable = false)
    @PastOrPresent(message = "Дата повинна знаходитись в минулому або тепер")
    private Timestamp dateTime;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idCourse")
    private CourseEntity courseEntity;
    public CourseEntity getCourseEntity() {
        return courseEntity;
    }
    public void setCourseEntity(CourseEntity courseEntity) {
        this.courseEntity = courseEntity;
    }



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
