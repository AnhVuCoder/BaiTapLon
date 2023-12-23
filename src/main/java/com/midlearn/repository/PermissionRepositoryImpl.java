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
        Permission p1=new Permission("Add accreditation");
        Permission p2=new Permission("Add standard");
        Permission p3=new Permission("Add criteria");
        Permission p4=new Permission("Authorize permission");
        Permission p5=new Permission("Add evidence");
        Permission p6=new Permission("Update evidence");
        Permission p7=new Permission("Delete evidence");
        Permission p8=new Permission("Assign evidence for criteria");
        List<Permission> list= List.of(p1,p2,p3,p4,p5,p6,p7,p8);
        PermissionRepositoryImpl.getInstance().findAll().addAll(list);
    }
}
