package com.univer.models;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Person extends MasterModels implements Comparable<Person>, Serializable {

    @Serial
    private static final long serialVersionUID = 0xf427d7a2328852a0L;
    private static int calc;

    private Integer courseId;
    private Role role;
    private String roleString;
    private String firstName;
    private String secondName;
    private int personIDTmp;
    private String phone;
    private String email;

    public Person(int personID, Integer courseId, Role role, String firstName, String secondName, String phone, String email) {
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
    public Person(int personID, Integer courseId, String roleString, String firstName, String secondName, String phone, String email) {
        super(personID);
        this.courseId = courseId;
        this.roleString = roleString;
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone = phone;
        this.email = email;
        calc++;
        personIDTmp = personID;

    }

    public String getRoleString() {
        return roleString;
    }

    public int getPersonIDTmp() {
        return personIDTmp;
    }

    public Person() {
    }

    @Override
    public int getID() {
        return super.getID();
    }

    @Override
    public Integer getLectureId() {
        return 0;
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
                "/ Phone-- " + getPhone() + "/ Email-- " + getEmail() + "//"+"\n";
    }

    @Override
    public int compareTo(Person o) {

        if (secondName.length() > o.secondName.length()) {
            for (int i = 0; i < secondName.length() - 1; i++) {
                if (this.secondName.charAt(i) > o.secondName.charAt(i)) {
                    return 1;
                } else if (this.secondName.charAt(i) < o.secondName.charAt(i)) {
                    return -1;
                }
            }
        }else {
            for (int i = 0; i < o.secondName.length() - 1; i++) {
                if (this.secondName.charAt(i) > o.secondName.charAt(i)) {
                    return 1;
                } else if (this.secondName.charAt(i) < o.secondName.charAt(i)) {
                    return -1;
                }
            }
        }
        return 0;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person that = (Person) o;
        return Objects.equals(personIDTmp,that.personIDTmp) && Objects.equals(courseId, that.courseId)&& Objects.equals(roleString, that.roleString)&& Objects.equals(firstName, that.firstName)&& Objects.equals(secondName, that.secondName) && Objects.equals(phone, that.phone)&& Objects.equals(email, that.email);
    }
    @Override
    public int hashCode() {
        return Objects.hash(personIDTmp, courseId, roleString, firstName, secondName, phone, email);
    }
}
