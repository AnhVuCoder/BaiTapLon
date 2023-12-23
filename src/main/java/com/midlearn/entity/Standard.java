package com.midlearn.entity;

import java.util.ArrayList;
import java.util.List;

public class Standard extends CommonCriteriaAndStandard {
    private static int count;
    {
        this.id=String.format("ST%06d",++count);
    }
    private List<Criteria> list=new ArrayList<>();


    public List<Criteria> getList() {
        return list;
    }

    public void setList(List<Criteria> list) {
        this.list = list;
    }
}
