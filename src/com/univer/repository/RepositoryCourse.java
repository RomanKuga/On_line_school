package com.univer.repository;

import com.univer.models.Course;
import com.univer.models.MasterModels;

public  class RepositoryCourse extends RepositoryMaster {
    private  static int sizeDataCourse=5;
    private Course[] courseArray;
    private static RepositoryCourse INSTANCE;

    public RepositoryCourse (){
        super.interfaceRepository();
    }
    public static RepositoryCourse getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new RepositoryCourse() {
                @Override
                public void add(int index, MasterModels masterModels) {

                }
            };
        }

        return INSTANCE;
    }

    @Override
    public void add(MasterModels masterModels) {
        super.add(masterModels);
    }

    @Override
    public Course get(int index) {
        return (Course) super.get(index);
    }

    public Course[] getCourse() {
        this.courseArray=new Course[size()];
        for (int i=0; i<size(); i++){
            courseArray[i] = (Course) super.get(i);}
        return  courseArray;
    }

    @Override
    public <E> void getByld(int number) {
        super.getByld(number);
    }

    @Override
    public int getIndex() {
        return super.getIndex();
    }

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public void remove(int number) {
        super.remove(number);
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    public static int getSizeDataCourse() {
        return sizeDataCourse;
    }


}
