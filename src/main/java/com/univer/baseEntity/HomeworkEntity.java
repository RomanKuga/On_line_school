package com.univer.baseEntity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "homework", schema = "on_line_school")
public class HomeworkEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idhomeWork", nullable = false)
    private int idhomeWork;
    @Basic
    @Column(name = "idLecture", nullable = false)
    private int idLecture;
    @Basic
    @Column(name = "task", nullable = false, length = 45)
    private String task;

    public int getIdhomeWork() {
        return idhomeWork;
    }

    public void setIdhomeWork(int idhomeWork) {
        this.idhomeWork = idhomeWork;
    }

    public int getIdLecture() {
        return idLecture;
    }

    public void setIdLecture(int idLecture) {
        this.idLecture = idLecture;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeworkEntity that = (HomeworkEntity) o;
        return idhomeWork == that.idhomeWork && idLecture == that.idLecture && Objects.equals(task, that.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idhomeWork, idLecture, task);
    }
}
