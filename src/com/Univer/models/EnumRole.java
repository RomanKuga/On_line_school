package com.Univer.models;

public enum EnumRole {
    Студент, Вчитель;
    public EnumRole EnumRoleName(){
        return EnumRole.valueOf(name());
    }
}
