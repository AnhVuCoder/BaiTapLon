package com.midlearn.entity;

import com.midlearn.repository.CriteriaRepositoryImpl;
import com.midlearn.repository.DepartmentRepositoryImpl;
import com.midlearn.repository.EvidenceRepositoryImpl;
import com.midlearn.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Standard extends CommonCriteriaAndStandard {
    private static int count;
    {
        this.id=String.format("ST%06d",++count);
    }
    public Standard(){
        this.list=new ArrayList<>();
    }
    private List<Criteria> list=new ArrayList<>();
    public Standard(String name){
        this.name=name;
    }
    public List<Criteria> getList() {
        return list;
    }
    public void setList(List<Criteria> list) {
        this.list = list;
    }

    public void fill(){
        while(Utils.SC.hasNext()){
            String s=Utils.SC.nextLine();
            if(s.equals("Cancel")) {
                System.out.println("Exists");
                break;
            }
            Criteria criteria=CriteriaRepositoryImpl.getInstance().findById(s);
            if(criteria==null) System.out.println("Not exist criteria with this id");
            else if(criteria.isUsed()) System.out.println("This criteria is already included in standard");
            else if(!isExistCriteria(criteria.getId())) System.out.println("This criteria is already exist in the list");
            else{
                criteria.setUsed(true);
                this.list.add(CriteriaRepositoryImpl.getInstance().findById(s));
                System.out.println("Add criteria success");
            }
        }
    }
    public boolean isExistCriteria(String id){
        Criteria criteria=list.stream().filter(p->p.getId().equals(id)).findFirst().orElse(null);
        return criteria == null;
    }
}
