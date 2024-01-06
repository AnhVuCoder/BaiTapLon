package com.midlearn.controller;

import com.midlearn.entity.*;
import com.midlearn.repository.*;
import com.midlearn.utils.Utils;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EvidenceSystem {
    private List<Accreditation> accreditationList=new ArrayList<>();
    private static EvidenceSystem instance;
    private EvidenceSystem(){}
    public static EvidenceSystem getInstance(){
        if(instance==null){
            instance=new EvidenceSystem();
        }
        return instance;
    }
    public List<Accreditation> getAccreditationList() {
        return accreditationList;
    }
    public void setAccreditationList(List<Accreditation> accreditationList) {
        this.accreditationList = accreditationList;
    }

    public void createEvidence(){
        Evidence evidence=new Evidence();
        evidence.add();
    }
    public Accreditation createAccreditation(){
        Accreditation accreditation=new Accreditation();
        accreditation.add();
        AccreditationRepositoryImpl.getInstance().save(accreditation);
        return accreditation;
    }
    public void createContentForCriteria(Criteria criteria){
        criteria.setContent();
        System.out.println("Create content for criteria successfully");
    }
    public void addEvidenceForCriteria(Criteria criteria){
        EvidenceRepositoryImpl.getInstance().findAll().forEach(p-> System.out.println(p.getId()));
        criteria.addEvidence();
    }
    public void updateEvidenceForCriteria(Evidence evidence){
        evidence.update();
    }
    public List<Evidence> listEvidenceByCriteria(Criteria criteria){
        this.sortByCreatedDate(criteria);
        return criteria.getEvidenceList();
    }
    public void sortByCreatedDate(Criteria criteria){
        criteria.getEvidenceList().sort((p1,p2)-> p1.getCreateDate().isBefore(p2.getCreateDate()) ? 1 : (p1.getCreateDate().isEqual(p2.getCreateDate())?0:-1));
    }
    public Evidence findByName(String name) throws Exception {
        return EvidenceRepositoryImpl.getInstance().findAll().stream().
                filter(s->s.getName().equals(name)).findFirst().orElse(null);
    }
    public List<Evidence> findByDepartment(String name) throws Exception {
        return EvidenceRepositoryImpl.getInstance().findAll().stream().
                filter(s->s.getDepartment().getName().equals(name)).collect(Collectors.toList());

    }
    public List<Evidence> findByPromulgateDate(String date) throws Exception {
        return  EvidenceRepositoryImpl.getInstance().findAll().stream().
                filter(s->s.getPromulgateDate().equals(LocalDate.parse(date,Utils.DATE_TIME_FORMATTER))).collect(Collectors.toList());
    }
    public List<Evidence> findByProvideDepartment(Integer id) throws Exception {
        List<Evidence> evidences=EvidenceRepositoryImpl.getInstance().findAll();
        List<Evidence> evidences1=new ArrayList<>();
        for(var p:evidences){
            if(p.findProvideDepartmentById(id)!=null){
                evidences1.add(p);
            }
        }
        return evidences1;
    }
    public List<Evidence> findByRelationName(String name) throws Exception {
        return EvidenceRepositoryImpl.getInstance().findAll().stream().
                filter(s->s.getName().contains(name)).toList();
    }
    public void sortByName(){
        EvidenceRepositoryImpl.getInstance().findAll().sort((p1,p2)-> Integer.compare(p1.getName().compareTo(p2.getName()), 0));
    }
    public void sortByCreatedDate(){
        EvidenceRepositoryImpl.getInstance().findAll().sort((p1,p2)-> p1.getCreateDate().isBefore(p2.getCreateDate())?1:(p1.getCreateDate().isEqual(p2.getCreateDate())?0:-1));
    }
    public void authorizePermission(User user) throws Exception {
            List<Permission> permissions=new ArrayList<>();
            System.out.println("List permission");
            PermissionRepositoryImpl.getInstance().findAll().forEach(p-> System.out.print(p.getId()+" "+p.getName()+"\n"));
            while(Utils.SC.hasNext()){
                int s=Integer.parseInt(Utils.SC.nextLine());
                if(s==0){
                    System.out.println("Exists");
                    break;
                }
                Permission permission=PermissionRepositoryImpl.getInstance().findById(s);
                if(permission==null) Utils.showErrorEvidences();
                else if(!user.isExistPermission(permission.getId())) System.out.println("Already permission");
                else {
                    permissions.add(permission);
                    System.out.println("Add permission success");
                }
            }

    }
    public void deleteEvidenceForCriteria(Criteria criteria){
        List<Evidence> evidences=EvidenceRepositoryImpl.getInstance().findAll();
        if(evidences.size()==0) Utils.showErrorEvidences();
        else{
            criteria.deleteEvidence();
        }
    }
    public User login(String name, String password){
        return UserRepositoryImpl.getInstance().findAll().stream().filter(p->
                p.getPassword().equals(password) && p.getUsername().equals(name))
                .findFirst().orElse(null);

    }
    public void start(){
        RoleRepositoryImpl.getInstance().restore();
        DepartmentRepositoryImpl.getInstance().restore();
        PermissionRepositoryImpl.getInstance().restore();
        EvidenceRepositoryImpl.getInstance().restore();
        CriteriaRepositoryImpl.getInstance().restore();
        StandardRepositoryImpl.getInstance().restore();
        UserRepositoryImpl.getInstance().restore();
    }
    public void importFile(){
        Utils.readFile();
    }
    public Criteria inputCriteria(String criteriaId){
        Criteria criteria;
        do{
            System.out.println("Criteria id: "); criteriaId=Utils.SC.nextLine();
            criteria=CriteriaRepositoryImpl.getInstance().findById(criteriaId);
            if(criteria==null) Utils.showErrorEvidences();
        } while (criteria==null);
        return criteria;
    }
    public Evidence inputEvidence(String evidenceId){
        Evidence evidence;
        do{
            System.out.println("Evidence id: "); evidenceId=Utils.SC.nextLine();
            evidence=EvidenceRepositoryImpl.getInstance().findById(evidenceId);
            if(evidence==null) System.out.println("No user");
        } while (evidence==null);
        return evidence;
    }
    public User inputUser(String userId){
        User user;
        do{
            System.out.println("User id: "); userId=Utils.SC.nextLine();
            user=UserRepositoryImpl.getInstance().findById(userId);
            if(user==null) Utils.showErrorEvidences();
        } while (user==null);
        return user;
    }

    public void promulgateDate(Evidence evidence) {
        evidence.setPromulgatePlace(Utils.SC.nextLine());
        evidence.setPromulgateDate(LocalDate.now());
    }
}
