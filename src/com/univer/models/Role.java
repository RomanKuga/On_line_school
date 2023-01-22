package com.univer.models;

public enum Role {
    Student, Teacher;
    public Role enumRoleName(){
        return Role.valueOf(name());
    }
}
