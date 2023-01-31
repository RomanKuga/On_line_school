package com.univer.models;

public class Person extends MasterModels implements Comparable {

    private static int calc;

    private Integer courseId;
    private Role role;
    private String firstName;
    private String secondName;
    private int personIDTmp;
    private String phone;
    private String email;

    public Person(Integer personID, Integer courseId, Role role, String firstName, String secondName, String phone, String email) {
        super(personID);
        this.courseId = courseId;
        this.role = role;
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone = phone;
        this.email = email;
        calc++;
        personIDTmp = personID;

    }

    public Person() {
    }

    @Override
    public int getID() {
        return super.getID();
    }

    public int getPersonID() {

        return personIDTmp;
    }

    public int getCourseId() {
        return courseId;
    }

    public Role getRole() {
        return role;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getCalcPerson() {
        return calc;
    }

    public void setCalcCorect() {
        calc--;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "//  Person id = " + getPersonID() + "/  CourseID--  " + getCourseId() +
                "/ FirstName-- " + getFirstName() + "/ SecondName-- " + getSecondName() + "/ Role-- " + getRole() +
                "/ Phone-- " + getPhone() + "/ Email-- " + getEmail() + "//";
    }

    @Override
    public int compareTo(Object o) {
        Person input = (Person) o;
        if (secondName.length() > input.secondName.length()) {
            for (int i = 0; i < secondName.length() - 1; i++) {
                if (this.secondName.charAt(i) > input.secondName.charAt(i)) {
                    return 1;
                } else if (this.secondName.charAt(i) < input.secondName.charAt(i)) {
                    return -1;
                }
            }
        }else {
            for (int i = 0; i < input.secondName.length() - 1; i++) {
                if (this.secondName.charAt(i) > input.secondName.charAt(i)) {
                    return 1;
                } else if (this.secondName.charAt(i) < input.secondName.charAt(i)) {
                    return -1;
                }
            }
        }
        return 0;
    }
}
