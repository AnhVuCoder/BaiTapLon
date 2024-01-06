package com.midlearn.repository;

import com.midlearn.Test;
import com.midlearn.entity.Department;

import java.util.List;

public class DepartmentRepositoryImpl extends Repository<Department,Integer> implements AbstractInterface {
    private static DepartmentRepositoryImpl instance;
    private DepartmentRepositoryImpl(){}
    public static DepartmentRepositoryImpl getInstance(){
        if(instance==null){
            instance=new DepartmentRepositoryImpl();
        }
        return instance;
    }

    @Override
    public void restore() {
        Department d1=new Department("D1");
        Department d2=new Department("D2");
        Department d3=new Department("D3");
        Department d4=new Department("D4");
        Department d5=new Department("D5");
        List<Department> list=List.of(d1,d2,d3,d4,d5);
        DepartmentRepositoryImpl.getInstance().findAll().addAll(list);
    }
}
