package com.midlearn.entity;

import com.midlearn.utils.Utils;

public class Permission extends CommonEntity<Integer> {
    private static int count;
    {
        this.id=++count;
    }
    public Permission(){}
    public Permission(String name){
        this.name=name;
    }

    public void add(){
        System.out.println("Name: "); setName(Utils.SC.nextLine());
    }
}
