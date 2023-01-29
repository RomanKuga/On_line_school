package com.univer.models;

public class AddMaterial extends MasterModels {
    private static int calc;
    private Integer id;
    private String nameAddMaterials;
    private Integer lecturesId;
    private ResourceType resourceType;

    public AddMaterial(Integer id, String nameAddMaterials, Integer lecturesId, ResourceType resourceType) {
        super(id);
        this.nameAddMaterials = nameAddMaterials;
        this.lecturesId = lecturesId;
        this.resourceType = resourceType;
        calc++;
    }

    public static int getCalc() {
        return calc;
    }

    public Integer getId() {
        return id;
    }

    public String getNameAddMaterials() {
        return nameAddMaterials;
    }

    public Integer getLecturesId() {
        return lecturesId;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public AddMaterial() {
    }

    @Override
    public String toString() {
        return "//  AddMaterials id = " + getID() + "/  Назва додаткових матеріалів--  " + getNameAddMaterials() +
                "/ ID лекції-- " + getLecturesId() + "/ Залучені типи додаткових завдань-- " + getResourceType() + "//";
    }
}
