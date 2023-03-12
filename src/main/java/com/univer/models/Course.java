package com.univer.models;

public class Course extends MasterModels implements Comparable<Course>{
    private static int calc;
    private String name;

    public  Course(Integer courseID, String name){
        super(courseID);
        this.name=name;
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


}
