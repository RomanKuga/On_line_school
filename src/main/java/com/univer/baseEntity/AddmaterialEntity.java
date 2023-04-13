package com.univer.baseEntity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "addmaterial", schema = "on_line_school")
public class AddmaterialEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idaddMaterial", nullable = false)
    private int idaddMaterial;
    @Basic
    @Column(name = "nameAddMaterial", nullable = false, length = 45)
    private String nameAddMaterial;
    @Basic
    @Column(name = "idLecture", nullable = false)
    private int idLecture;
    @Basic
    @Column(name = "resourseType", nullable = false, length = 45)
    private String resourseType;

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
