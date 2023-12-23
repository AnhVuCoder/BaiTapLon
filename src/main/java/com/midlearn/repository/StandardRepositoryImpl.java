package com.midlearn.repository;

import com.midlearn.entity.Standard;

public class StandardRepositoryImpl extends Repository<Standard,String> {
    private static StandardRepositoryImpl instance;
    private StandardRepositoryImpl(){}
    public static StandardRepositoryImpl getInstance(){
        if(instance==null){
            instance=new StandardRepositoryImpl();
        }
        return instance;
    }
}
