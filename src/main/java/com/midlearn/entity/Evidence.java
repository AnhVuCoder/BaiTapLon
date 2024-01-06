package com.midlearn.entity;

import com.midlearn.repository.DepartmentRepositoryImpl;
import com.midlearn.repository.EvidenceRepositoryImpl;
import com.midlearn.utils.Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Evidence extends  CommonEntity<String> {
    private static int count;
    {
        this.id=String.format("EV%06d",++count);
    }

    private String promulgatePlace;
    private LocalDate promulgateDate;
    private LocalDate createDate;
    private List<EvidenceDepartment> evidenceDepartments;

    public List<EvidenceDepartment> getEvidenceDepartments() {
        return evidenceDepartments;
    }

    public void setEvidenceDepartments(List<EvidenceDepartment> evidenceDepartments) {
        this.evidenceDepartments = evidenceDepartments;
    }

    private Department department;

    public Evidence(String e1, String d1, LocalDate of, LocalDate of1, List<EvidenceDepartment> list, Department byId1) {
        this.name=e1;
        this.promulgatePlace=d1;
        this.promulgateDate=of;
        this.createDate=of1;
        this.department=byId1;
        this.evidenceDepartments=list;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Evidence(){
        this.evidenceDepartments=new ArrayList<>();
    }
    public String getPromulgatePlace() {
        return promulgatePlace;
    }

    public void setPromulgatePlace(String promulgatePlace) {
        this.promulgatePlace = promulgatePlace;
    }

    public LocalDate getPromulgateDate() {
        return promulgateDate;
    }

    public void setPromulgateDate(LocalDate promulgateDate) {
        this.promulgateDate = promulgateDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
    public void show(){
        System.out.printf("Id: %s\nName: %s\nCreatedDate: %s\n",
                this.id,this.name,
                this.createDate.format(Utils.DATE_TIME_FORMATTER));
        if(promulgatePlace!=null) System.out.println("PromulgatePlace: "+promulgatePlace);
        if(promulgateDate!=null) System.out.println("PromulgateDate: "+promulgateDate.format(Utils.DATE_TIME_FORMATTER));
        System.out.println("Department promulgate for this evidence: "+department.getName());
        System.out.println("---------------------------------------");
    }
    public void add(){
        System.out.println("Name: "); setName(Utils.SC.nextLine());
        System.out.println("PromulgatePlace: "); setPromulgatePlace(Utils.SC.nextLine());
        System.out.println("Department responsible for this evidence: ");
        this.updateDepartmentSupplyEvidence();
        this.updateDepartmentPromulgateEvidence();
        EvidenceRepositoryImpl.getInstance().save(this);
        setCreateDate(LocalDate.now());
        System.out.println("Add evidence success");
    }
    public void updateDepartmentSupplyEvidence(){
        while(Utils.SC.hasNext()){
            EvidenceDepartment evidenceDepartment=new EvidenceDepartment();
            int s=Integer.parseInt(Utils.SC.nextLine());
            if(s==0){
                System.out.println("Exists");
                break;
            }
            Department department=DepartmentRepositoryImpl.getInstance().findById(s);
            if(department==null) System.out.println("Not department with this id");
            else {
                System.out.println("Fill supply date: "); evidenceDepartment.setSupplyDate(Utils.setDateCorrectFormat());
                evidenceDepartment.setDepartment(department);
                evidenceDepartments.add(evidenceDepartment);
            }
        }
    }
    public void updateDepartmentPromulgateEvidence(){
        Department department1;
        do{
            System.out.println("Department promulgate for this evidence: ");
            department1=DepartmentRepositoryImpl.getInstance().findById(Integer.parseInt(Utils.SC.nextLine()));
            if(department1==null) System.out.println("Not exist department with this id");
        } while (department1==null);
        setDepartment(department1);
    }
    public void update(){
        String s;
        System.out.println("Do you want update Name (y/n)"); s=Utils.SC.nextLine();
        if(s.equals("y")){
            System.out.println("Fill new name: "+name+"->");
            this.name=Utils.SC.nextLine();
        }
        System.out.println("Do you want update Promulgate place (y/n)"); s=Utils.SC.nextLine();
        if(s.equals("y")){
            System.out.println("Fill new promulgate place: "+promulgatePlace+"->");
            this.name=Utils.SC.nextLine();
        }
        System.out.println("Do you want update Promulgate Date (y/n)"); s=Utils.SC.nextLine();
        if(s.equals("y")){
            System.out.println("Fill new promulgate date: "+promulgateDate.format(Utils.DATE_TIME_FORMATTER)+"->");
            setPromulgateDate(Utils.setDateCorrectFormat());
        }
        System.out.println("Do you want update Created Date (y/n)"); s=Utils.SC.nextLine();
        if(s.equals("y")){
            System.out.println("Fill new created date: "+createDate.format(Utils.DATE_TIME_FORMATTER)+"->");
            setCreateDate(Utils.setDateCorrectFormat());
        }
        System.out.println("Update success");
    }
    public Department findProvideDepartmentById(Integer id){
        EvidenceDepartment evidenceDepartment=this.evidenceDepartments.stream().
                filter(p-> Objects.equals(p.getDepartment().id, id)).findFirst().orElse(null);
        if(evidenceDepartment==null) return null;
        return evidenceDepartment.getDepartment();
    }
}