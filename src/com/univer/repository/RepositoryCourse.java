package com.univer.repository;

import com.univer.models.Course;

public class RepositoryCourse extends RepositoryMaster<Course> {
    private  static int sizeDataCourse =5;
    private Course[] courseArray;
    private static RepositoryCourse INSTANCE;

    public RepositoryCourse (){
        super.repositoryMaster();
    }
    public static RepositoryCourse getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new RepositoryCourse();
        }

        return INSTANCE;
    }


    @Override
    public void repositoryMaster() {
        super.repositoryMaster();
    }

    @Override
    public void add(Course masterModels) {
        super.add(masterModels);
    }

    @Override
    public Course get(int index) {
        return super.get(index);
    }

    public Course[] getCourse() {
        this.courseArray=new Course[size()];
        for (int i=0; i<size(); i++){
            courseArray[i] = super.get(i);}
        return  courseArray;
    }

    @Override
    public <E> void getByld(int number) {
        super.getByld(number);
    }

//    @Override
//    public int getIndex() {
//        return super.getIndex();
//    }

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public void remove(int number) {
        super.remove(number);
    }

    public static int getSizeDataCourse() {
        return sizeDataCourse;
    }

}
