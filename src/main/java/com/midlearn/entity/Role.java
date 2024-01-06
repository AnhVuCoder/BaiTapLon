package com.midlearn.entity;

import com.midlearn.utils.Utils;

public class Role extends CommonEntity<Integer> {
    public static int count;
    public Role(String name){
        this.name=name;
    }

    {
        this.id=++count;
    }

    public void add(){
        System.out.println("Name: "); setName(Utils.SC.nextLine());
    }
}
