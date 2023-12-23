package com.midlearn.repository;

import com.midlearn.entity.Role;

import java.util.List;

public class RoleRepositoryImpl extends Repository<Role,Integer> implements AbstractInterface {
    private static RoleRepositoryImpl instance;
    private RoleRepositoryImpl(){}
    public static RoleRepositoryImpl getInstance(){
        if(instance==null){
            instance=new RoleRepositoryImpl();
        }
        return instance;
    }

    @Override
    public void restore() {
        Role r1=new Role("Instructor");
        Role r2=new Role("Manager");
        Role r3=new Role("AuthorizePerson");
        List<Role> list= List.of(r1,r2,r3);
        RoleRepositoryImpl.getInstance().findAll().addAll(list);
    }
}
