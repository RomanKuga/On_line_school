package com.univer.models;

public enum Role {
    Student, Teacher;
    public Role EnumRoleName(){
        return Role.valueOf(name());
    }
}
