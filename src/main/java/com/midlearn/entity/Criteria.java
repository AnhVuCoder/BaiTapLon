package com.midlearn.entity;

import java.util.ArrayList;
import java.util.List;

public class Criteria extends CommonCriteriaAndStandard {
    private static int count;
    {
        this.id=String.format("CR%06d",++count);
    }
    private List<Evidence> evidenceList=new ArrayList<>();

    public List<Evidence> getEvidenceList() {
        return evidenceList;
    }

    public void setEvidenceList(List<Evidence> evidenceList) {
        this.evidenceList = evidenceList;
    }
}
