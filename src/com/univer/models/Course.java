package com.univer.models;

public class Course extends MasterModels implements Comparable{
    private static int calc;
    private String name;

    public  Course(Integer courseID, String name){
        super(courseID);
        this.name=name;
        calc++;
    }

    public Course() {

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
    public int compareTo(Object o) {
        Course input = (Course) o;
        if (name.length() > input.name.length()) {
            for (int i = 0; i < name.length() - 1; i++) {
                if (this.name.charAt(i) > input.name.charAt(i)) {
                    return 1;
                } else if (this.name.charAt(i) < input.name.charAt(i)) {
                    return -1;
                }
            }
        }else {
            for (int i = 0; i < input.name.length() - 1; i++) {
                if (this.name.charAt(i) > input.name.charAt(i)) {
                    return 1;
                } else if (this.name.charAt(i) < input.name.charAt(i)) {
                    return -1;
                }
            }
        }
        return 0;
    }
}
