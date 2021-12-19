package ru.dima.studySpringMVC.models;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Student {
    private int id;
    @NotEmpty(message = "Name can't be empty")
    @Size(min=2,max=10,message = "Name has unreal size")
    private String name;
    @NotEmpty(message = "Group can't be empty")
    private String group;
    public Student(){};

    public Student(int id, String name, String group) {
        this.id = id;
        this.name = name;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
