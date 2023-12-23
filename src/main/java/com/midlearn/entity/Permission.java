package com.midlearn.entity;

import com.midlearn.utils.Utils;

public class Permission extends CommonEntity<Integer> {
    private static int count;
    private String name;
    {
        this.id=++count;
    }
    public Permission(){

    }
    public Permission(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void add(){
        System.out.println("Name: "); setName(Utils.SC.nextLine());
    }
    public void show(){
        System.out.printf("Id: %s\nName: %s\n",this.id,this.name);
    }
}
