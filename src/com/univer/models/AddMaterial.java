package com.univer.models;

import com.univer.service.AddMaterialService;

public  class AddMaterial extends MasterModels implements Comparable<AddMaterial> {
    private static int calc;

    private String nameAddMaterials;
    private Integer lectureId;
    private ResourceType resourceType;

    public AddMaterial(Integer id, String nameAddMaterials, Integer lectureId, ResourceType resourceType) {
        super(id);
        this.nameAddMaterials = nameAddMaterials;
        this.lectureId = lectureId;
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

    public Integer getLectureId() {
        return lectureId;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public AddMaterial() {
    }

    @Override
    public String toString() {
        return "//  AddMaterials id = " + getID() + "/  Назва додаткових матеріалів--  " + getNameAddMaterials() +
                "/ ID лекції-- " + getLectureId() + "/ Залучені типи додаткових завдань-- " + getResourceType() + "//";
    }

    @Override
    public int compareTo(AddMaterial o) {
        AddMaterialService typeSort = new AddMaterialService();
        switch (typeSort.getNumberTestComperble()) {
            case 1:
                System.out.println(this.getID());
                if (this.getID() >= o.getID()) {
                    return 1;
                } else if (this.getID() < o.getID()) {
                    return -1;
                }

            break;
            case 2:
                if (this.lectureId >= o.lectureId) {
                    return 1;
                } else {
                    return -1;
                }

            case 3:
                if (this.getResourceType().ordinal() >= o.getResourceType().ordinal()) {
                    return 1;
                } else if (this.getResourceType().ordinal() < o.getResourceType().ordinal()) {
                    return -1;
                }


            break;
        }
return 0;
  }
}
