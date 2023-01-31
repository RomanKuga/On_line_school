package com.univer.models;

import com.univer.service.AddMaterialService;

public class AddMaterial extends MasterModels implements Comparable {
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

    @Override
    public int getID() {
        return super.getID();
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

    @Override
    public int compareTo(Object o) {
        AddMaterial input = (AddMaterial) o;
        AddMaterialService typeSort = new AddMaterialService();
        switch (typeSort.getNumberTestComperble()) {
            case 1:
                System.out.println(this.getID());
                if (this.getID() > input.getID()) {
                    return 1;
                } else if (this.getID() < input.getID()) {
                    return -1;
                }

            break;
            case 2:
                if (this.lecturesId > input.lecturesId) {
                    return 1;
                } else if (this.lecturesId < input.lecturesId) {
                    return -1;
                }

            break;
            case 3:
                if (this.getResourceType().ordinal() > input.getResourceType().ordinal()) {
                    return 1;
                } else if (this.getResourceType().ordinal() < input.getResourceType().ordinal()) {
                    return -1;
                }

            break;
        }
return 0;
  }
}
