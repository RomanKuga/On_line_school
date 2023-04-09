package com.univer.models;

import java.util.Objects;

public class Course extends MasterModels implements Comparable<Course>{
    private static int calc;
    private String name;
private  Integer courseID;
    public  Course(Integer courseID, String name){
        super(courseID);
        this.name=name;
        this.courseID=courseID;
        calc++;
    }

    public Course() {

    }


    @Override
    public Integer getLectureId() {
        return 0;
    }

    public String getName() {
        return name;
    }

    public int getCourseID() {

        return super.getID();
    }

    public  int getCalcCourse() {

        return calc;
    }

    @Override
    public String toString() {
        return "//  Course id = " +  getCourseID()  + "/ Name Course--  " + getName() + "//";
    }

    @Override
    public int compareTo(Course o) {

        if (name.length() > o.name.length()) {
            for (int i = 0; i < name.length() - 1; i++) {
                if (this.name.charAt(i) > o.name.charAt(i)) {
                    return 1;
                } else if (this.name.charAt(i) < o.name.charAt(i)) {
                    return -1;
                }
            }
        }else {
            for (int i = 0; i < o.name.length() - 1; i++) {
                if (this.name.charAt(i) > o.name.charAt(i)) {
                    return 1;
                } else if (this.name.charAt(i) < o.name.charAt(i)) {
                    return -1;
                }
            }
        }
        return 0;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course that = (Course) o;
        return courseID.equals(that.courseID) && Objects.equals(name, that.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(courseID, name);
    }

}
