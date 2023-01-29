package com.univer.repository;

import com.univer.models.MasterModels;

import java.util.List;

public  class RepositoryCourse extends RepositoryMaster {

    private static RepositoryCourse INSTANCE;

    public RepositoryCourse (){

        super.interfaceRepository();
    }

    public List<MasterModels> getCourseList() {
        return super.getModelsList();
    }

    @Override
    public List<MasterModels> findAll() {
        return super.findAll();
    }
    public static RepositoryCourse getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new RepositoryCourse();
        }
        return INSTANCE;
    }
    // @Override
//    public MasterModels[] findAll() {
//        Simpleiterator iterator = new Simpleiterator(newArray);
//        while (iterator.hesNext()){
//            if (iterator.next()==null){
//                iterator.remove();
//            }
//        }
//        return  iterator.getModel();
//
//    }
//    @Override
//    public void interfaceRepository() {
//        super.interfaceRepository();
//    }
//
//    @Override
//    public List<MasterModels> getModelsList() {
//        return super.getModelsList();
//    }


//    @Override
//    public void add(MasterModels masterModels) {
//        super.add(masterModels);
//    }
//
//    @Override
//    public Course get(int index) {
//        return (Course) super.get(index);
//    }
//
//    public Course[] getCourse() {
//        this.courseArray=new Course[size()];
//        for (int i=0; i<size(); i++){
//            courseArray[i] = (Course) super.get(i);}
//        return  courseArray;
//    }
//
//
//
//    @Override
//    public int getIndex() {
//        return super.getIndex();
//    }
//
//    @Override
//    public int size() {
//        return super.size();
//    }
//
//    @Override
//    public void remove(int number) {
//        super.remove(number);
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return super.isEmpty();
//    }
//
//    public static int getSizeDataCourse() {
//        return sizeDataCourse;
//    }


}
