package com.univer.baseEntity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.Objects;

@Entity
@Table(name = "addmaterial", schema = "on_line_school")
@Cacheable
@org.hibernate.annotations.Cache(
        usage = CacheConcurrencyStrategy.READ_WRITE)
public class AddmaterialEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idaddMaterial", nullable = false)
    private int idaddMaterial;
    @Basic
    @Column(name = "nameAddMaterial", nullable = false, length = 45)
    @NotBlank(message = "Поле додаткові матеріали повинно бути заповнене")
    private String nameAddMaterial;
    @Basic
    @Column(name = "idLecture", nullable = false, insertable=false, updatable = false)
    @NotNull
    private int idLecture;
    @Basic
    @Column(name = "resourseType", nullable = false, length = 45)
    @NotEmpty(message = "Поле повино містити тип ресурсів")
    private String resourseType;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   @JoinColumn(name = "idLecture")
    private LectureEntity lectureEntity;
    public LectureEntity getLectureEntity() {
        return lectureEntity;
    }

    public void setLectureEntity(LectureEntity lectureEntity) {
        this.lectureEntity = lectureEntity;
    }

    public int getIdaddMaterial() {
        return idaddMaterial;
    }

    public void setIdaddMaterial(int idaddMaterial) {
        this.idaddMaterial = idaddMaterial;
    }

    public String getNameAddMaterial() {
        return nameAddMaterial;
    }

    public void setNameAddMaterial(String nameAddMaterial) {
        this.nameAddMaterial = nameAddMaterial;
    }

    public int getIdLecture() {
        return idLecture;
    }

    public void setIdLecture(int idLecture) {
        this.idLecture = idLecture;
    }

    public String getResourseType() {
        return resourseType;
    }

    public void setResourseType(String resourseType) {
        this.resourseType = resourseType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddmaterialEntity that = (AddmaterialEntity) o;
        return idaddMaterial == that.idaddMaterial && idLecture == that.idLecture && Objects.equals(nameAddMaterial, that.nameAddMaterial) && Objects.equals(resourseType, that.resourseType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idaddMaterial, nameAddMaterial, idLecture, resourseType);
    }
}
