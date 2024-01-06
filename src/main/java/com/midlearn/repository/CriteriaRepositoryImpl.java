package com.midlearn.repository;

import com.midlearn.entity.CommonCriteriaAndStandard;
import com.midlearn.entity.Criteria;
import com.midlearn.entity.Evidence;

import javax.crypto.Cipher;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

public class CriteriaRepositoryImpl extends Repository<Criteria, String> implements AbstractInterface {
    private static CriteriaRepositoryImpl instance;
    private CriteriaRepositoryImpl(){}
    public static CriteriaRepositoryImpl getInstance(){
        if(instance==null){
            instance=new CriteriaRepositoryImpl();
        }
        return instance;
    }

    @Override
    public void restore() {
        Criteria c1=new Criteria("E1");
        Criteria c2=new Criteria("E2");
        Criteria c3=new Criteria("E3");
        Criteria c4=new Criteria("E4");
        Criteria c5=new Criteria("E5");
        CriteriaRepositoryImpl.getInstance().findAll().addAll(List.of(c1,c2,c3,c4,c5));
    }
}
