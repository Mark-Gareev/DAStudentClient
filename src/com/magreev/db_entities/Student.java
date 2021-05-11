package com.magreev.db_entities;

import java.sql.Date;

public class Student {
    private String name;
    private String lastName;
    private String fatherName;
    private String studGroup;
    private String birthDate;
    private Integer id;

    public String getBirthDate() {
        return birthDate;
    }

    public Integer getId() {
        return id;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getStudGroup() {
        return studGroup;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public void setBirthDate(String date) {
        this.birthDate = date;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setStudGroup(String studGroup) {
        this.studGroup = studGroup;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setName(String name) {
        this.name = name;
    }
}
