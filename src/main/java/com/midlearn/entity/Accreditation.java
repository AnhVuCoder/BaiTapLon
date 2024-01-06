package com.midlearn.entity;

import com.midlearn.repository.CriteriaRepositoryImpl;
import com.midlearn.repository.DepartmentRepositoryImpl;
import com.midlearn.repository.EvidenceRepositoryImpl;
import com.midlearn.repository.StandardRepositoryImpl;
import com.midlearn.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Accreditation extends CommonEntity<String> {
    private static int count;
    {
        this.id=String.format("AC%06d",++count);
    }
    private List<Standard> standardList;
    public Accreditation(){
        this.standardList=new ArrayList<>();
    }
    private Department department;
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    public List<Standard> getStandardList() {
        return standardList;
    }
    public void add(){
        System.out.println("Name: "); setName(Utils.SC.nextLine());
        System.out.println("Department: ");
        setDepartment(DepartmentRepositoryImpl.getInstance().findById(Integer.parseInt(Utils.SC.nextLine())));
        this.addStandardForAccreditation();
    }
    public void addStandardForAccreditation(){
        System.out.println("List standard");
        StandardRepositoryImpl.getInstance().findAll().forEach(p->{
            System.out.printf("ID: %s-Name: %s\n",p.id,p.getName());
        });
        System.out.println("Fill id of standard need to add for "+this.name);
        System.out.println("Fill 'cancel' to exist");
        this.fill();
        System.out.println("List criteria");
        CriteriaRepositoryImpl.getInstance().findAll().forEach(p->{
            System.out.printf("ID: %s-Name: %s\n",p.id,p.getName());
        });
        System.out.println("Fill id of criteria need to add ");
        System.out.println("Fill 'Cancel' to exist");
        this.standardList.forEach(p->{
            System.out.println("For "+p.id);
            p.fill();
        });
    }
    public void fill(){
        while(Utils.SC.hasNext()) {
            String s = Utils.SC.nextLine();
            if (s.equals("Cancel")) {
                System.out.println("Exists");
                break;
            }
            Standard standard=StandardRepositoryImpl.getInstance().findById(s);
            if(standard==null) System.out.println("Not exist standard with this id. Please fill again");
            else if(!isExistStandard(s)) System.out.println("Already standard with this id");
            else {
                this.standardList.add(StandardRepositoryImpl.getInstance().findById(s));
                System.out.println("Add standard success");
            }
        }
    }
    public void show(){
        System.out.printf("ID: %s\nName: %s\n",this.id,this.name);
        this.standardList.forEach(p->{
            System.out.println("Standard with id: "+p.getId()+" has list criteria: ");
            p.getList().forEach(s->{
                System.out.println(s.getId());
            });
        });
    }
    private boolean isExistStandard(String s){
        Standard standard=standardList.stream().filter(p->p.getId().equals(s)).findFirst().orElse(null);
        return standard==null;
    }
}
