package com.midlearn.repository;

import com.midlearn.entity.Accreditation;

public class AccreditationRepositoryImpl extends Repository<Accreditation,String> {
    private static AccreditationRepositoryImpl instance;
    private AccreditationRepositoryImpl(){}
    public static AccreditationRepositoryImpl getInstance(){
        if(instance==null){
            instance=new AccreditationRepositoryImpl();
        }
        return instance;
    }
}
