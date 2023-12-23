package com.midlearn.entity;

import com.midlearn.utils.Utils;

public class Role extends CommonEntity<Integer> {
    public static int count;
    private String name;

    public Role(String name){
        this.name=name;
    }

    {
        this.id=++count;
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
