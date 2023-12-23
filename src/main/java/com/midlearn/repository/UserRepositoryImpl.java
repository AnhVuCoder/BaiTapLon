package com.midlearn.repository;

import com.midlearn.entity.Permission;
import com.midlearn.entity.User;
import com.midlearn.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class UserRepositoryImpl extends Repository<User,String> implements AbstractInterface  {
    private static UserRepositoryImpl instance;
    private UserRepositoryImpl(){}
    public static UserRepositoryImpl getInstance(){
        if(instance==null){
            instance=new UserRepositoryImpl();
        }
        return instance;
    }

    @Override
    public void restore() {
        User u1=new User("A","111111",DepartmentRepositoryImpl.getInstance().findById(1),RoleRepositoryImpl.getInstance().findById(1));
        User u2=new User("B","222222",DepartmentRepositoryImpl.getInstance().findById(2),RoleRepositoryImpl.getInstance().findById(2));
        User u3=new User("C","333333",DepartmentRepositoryImpl.getInstance().findById(3),RoleRepositoryImpl.getInstance().findById(1));
        User u4=new User("D","111111",DepartmentRepositoryImpl.getInstance().findById(1),RoleRepositoryImpl.getInstance().findById(1));
        List<User> list=List.of(u1,u2,u3,u4);
        UserRepositoryImpl.getInstance().findAll().addAll(list);
    }
}
