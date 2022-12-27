package com.Univer.models;

public class Person extends MasterModels{

    private MasterModels personID;
    private Course courseId;
    private EnumRole role;
    private String firstName;
    private String secondName;

    public Person(MasterModels personID, Course courseId, EnumRole role, String firstName, String secondName ) {
        this.personID = personID;
        this.courseId=courseId;
        this.role=role;
        this.firstName=firstName;
        this.secondName=secondName;
    }

}
