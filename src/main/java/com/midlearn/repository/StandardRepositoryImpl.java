package com.midlearn.repository;

import com.midlearn.entity.CommonCriteriaAndStandard;
import com.midlearn.entity.Standard;

import java.util.List;

public class StandardRepositoryImpl extends Repository<Standard,String> implements AbstractInterface {
    private static StandardRepositoryImpl instance;
    private StandardRepositoryImpl(){}
    public static StandardRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new StandardRepositoryImpl();
        }
        return instance;
    }
    @Override
    public void restore() {
        Standard c1=new Standard("S1");
        Standard c2=new Standard("S2");
        Standard c3=new Standard("S3");
        Standard c4=new Standard("S4");
        StandardRepositoryImpl.getInstance().findAll().addAll(List.of(c1,c2,c3,c4));
    }
}
