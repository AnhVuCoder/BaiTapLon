package com.midlearn.repository;

import com.midlearn.entity.Permission;

import java.util.ArrayList;
import java.util.List;

public class PermissionRepositoryImpl extends Repository<Permission,Integer> implements AbstractInterface {
    private static PermissionRepositoryImpl instance;
    private PermissionRepositoryImpl(){}
    public static PermissionRepositoryImpl getInstance(){
        if(instance==null){
            instance=new PermissionRepositoryImpl();
        }
        return instance;
    }

    @Override
    public void restore() {
        Permission p1=new Permission("Create accreditation");
        Permission p2=new Permission("Create content for criteria");
        Permission p3=new Permission("Import evidence");
        Permission p4=new Permission("Add evidence for criteria");
        Permission p5=new Permission("Delete evidence for criteria");
        Permission p6=new Permission("Update evidence for criteria");
        Permission p7=new Permission("Authorize permission");
        Permission p8=new Permission("Create evidence");
        Permission p9=new Permission("Promulgate evidence");
        List<Permission> list= List.of(p1,p2,p3,p4,p5,p6,p7,p8,p9);
        PermissionRepositoryImpl.getInstance().findAll().addAll(list);
    }
}
