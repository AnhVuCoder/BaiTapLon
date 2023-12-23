package com.midlearn.entity;

public class Department extends CommonEntity<Integer> {
    private static int count;
    private String name;
    private String managerId;
    {
        this.id=++count;
    }
    public Department(){
    }
    public Department(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }
    public void show(){
        System.out.printf("Id: %s\nName: %s\n",this.id,this.name);
    }
}
