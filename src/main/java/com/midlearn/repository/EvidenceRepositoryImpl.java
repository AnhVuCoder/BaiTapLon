package com.midlearn.repository;

import com.midlearn.entity.Evidence;

public class EvidenceRepositoryImpl extends Repository<Evidence,String> {
    private static EvidenceRepositoryImpl instance;
    private EvidenceRepositoryImpl(){}
    public static EvidenceRepositoryImpl getInstance(){
        if(instance==null){
            instance=new EvidenceRepositoryImpl();
        }
        return instance;
    }
}
