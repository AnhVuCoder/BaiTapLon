package com.midlearn.entity;

public class Department extends CommonEntity<Integer> {
    private static int count;
    private String name;

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

    public void show(){
        System.out.printf("Id: %s\nName: %s\n",this.id,this.name);
    }
}
