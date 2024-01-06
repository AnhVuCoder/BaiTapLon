package com.midlearn.entity;

import com.midlearn.controller.EvidenceSystem;
import com.midlearn.repository.CriteriaRepositoryImpl;
import com.midlearn.repository.EvidenceRepositoryImpl;
import com.midlearn.repository.StandardRepositoryImpl;
import com.midlearn.repository.UserRepositoryImpl;
import com.midlearn.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Criteria extends CommonCriteriaAndStandard {
    private static int count;
    {
        this.id=String.format("CR%06d",++count);
    }
    private List<Evidence> evidenceList=new ArrayList<>();
    public Criteria(String name) {
        this.name=name;
    }
    public Criteria(){
        this.evidenceList=new ArrayList<>();
    }
    public List<Evidence> getEvidenceList() {
        return evidenceList;
    }
    private boolean isUsed;
    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }
    public void addEvidence(){
        List<Evidence> evidences=this.fill();
        evidences.forEach(p->{
            if(!isExistEvidence(p.getId())) {
                System.out.println("Already exist evidence in the list");
            } else{
                evidenceList.add(p);
                System.out.printf("Add evidence %s success\n",p.getId());
            }
        });
    }
    public void deleteEvidence(){
        List<Evidence> evidences=this.fill();
        evidences.forEach(p->{
            if(isExistEvidence(p.getId())) {
                System.out.println(p.getId()+" not exist in the list");
            } else {
                evidenceList.remove(p);
                System.out.printf("Delete evidence %s success\n",p.getId());
            }
        });
    }
    public List<Evidence> fill(){
        List<Evidence> evidences=new ArrayList<>();
        while(Utils.SC.hasNext()){
            String s=Utils.SC.nextLine();
            if(s.equals("Cancel")){
                System.out.println("Exists");
                break;
            }
            Evidence evidence=EvidenceRepositoryImpl.getInstance().findById(s);
            if(evidence==null) Utils.showErrorEvidences();
            else evidences.add(evidence);
        }
        return evidences;
    }
    public boolean isExistEvidence(String id){
        Evidence evidence=evidenceList.stream().filter(p->p.getId().equals(id)).findFirst().orElse(null);
        return evidence == null;
    }

}
