package com.midlearn.repository;

import com.midlearn.entity.Criteria;

import javax.crypto.Cipher;

public class CriteriaRepositoryImpl extends Repository<Criteria, String> {
    private static CriteriaRepositoryImpl instance;
    private CriteriaRepositoryImpl(){}
    public static CriteriaRepositoryImpl getInstance(){
        if(instance==null){
            instance=new CriteriaRepositoryImpl();
        }
        return instance;
    }
}
