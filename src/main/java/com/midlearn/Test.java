package com.midlearn;

import com.midlearn.controller.EvidenceSystem;
import com.midlearn.entity.*;
import com.midlearn.repository.*;
import com.midlearn.utils.Utils;

import java.util.List;

public class Test<D extends Test, S> {
    public static void main(String[] args) throws Exception {
        EvidenceSystem evidenceSystem=EvidenceSystem.getInstance();
        evidenceSystem.start();
        System.out.println("You must login success to access the system!!!");
        User user;
        do{
            System.out.println("Name: "); name=Utils.SC.nextLine();
            System.out.println("Password: "); String password=Utils.SC.nextLine();
            user=evidenceSystem.login(name,password);
            if(user==null) System.out.println("Not exist user with username or password");
        } while(user==null);
        System.out.println("Login success");
        while(true){
            System.out.println("1.Create new accreditation");
            System.out.println("2.Create content for criteria");
            System.out.println("3.Import evidence from file");
            System.out.println("4.Add/Delete/Update evidence for criteria");
            System.out.println("5.Authorize permission");
            System.out.println("6.List evidence by criteria");
            System.out.println("7.Find by name");
            System.out.println("8.Find by department");
            System.out.println("9.Find by promulgate date");
            System.out.println("10.Find by relation name");
            System.out.println("11.Find by provide department");
            System.out.println("12.Sort by name");
            System.out.println("13.Sort by created date");
            System.out.println("14.Show evidence");
            System.out.println("15.Create new evidence");
            System.out.println("16.Promulgate evidence");
            System.out.println("Choose: "); int lc=Integer.parseInt(Utils.SC.nextLine());
            if(lc==1){
               if(user.getPermissionList().contains(PermissionRepositoryImpl.getInstance().findById(1))){
                   Accreditation accreditation= evidenceSystem.createAccreditation();
                   accreditation.show();
               } else Utils.showError();

            }
            if(lc==2){
                if(user.getPermissionList().contains(PermissionRepositoryImpl.getInstance().findById(2))){
                    Criteria criteria=evidenceSystem.inputCriteria(criteriaId);
                    evidenceSystem.createContentForCriteria(criteria);
                } else Utils.showError();
            }
            if(lc==3){
                if(user.getPermissionList().contains(PermissionRepositoryImpl.getInstance().findById(3))){
                    evidenceSystem.importFile();
                } else Utils.showError();
            }
            if(lc==4){
                System.out.print("1.Add\n2.Delete\n3.Update\n"); lc=Integer.parseInt(Utils.SC.nextLine());
                switch (lc){
                    case 1 -> {
                        if(user.getPermissionList().contains(PermissionRepositoryImpl.getInstance().findById(4))){
                            Criteria criteria=evidenceSystem.inputCriteria(criteriaId);
                            evidenceSystem.addEvidenceForCriteria(criteria);
                        } else Utils.showError();
                    }
                    case 2 -> {
                        if(user.getPermissionList().contains(PermissionRepositoryImpl.getInstance().findById(5))){
                            Criteria criteria=evidenceSystem.inputCriteria(criteriaId);
                            evidenceSystem.deleteEvidenceForCriteria(criteria);
                        } else Utils.showError();
                    }
                    case 3 -> {
                        if(user.getPermissionList().contains(PermissionRepositoryImpl.getInstance().findById(6))){
                            Evidence evidence=evidenceSystem.inputEvidence(evidenceId);
                            evidenceSystem.updateEvidenceForCriteria(evidence);
                        } else Utils.showError();
                    }
                }
            }
            if(lc==5){
                if(user.getPermissionList().contains(PermissionRepositoryImpl.getInstance().findById(7))){
                    User user1=evidenceSystem.inputUser(userId);
                    evidenceSystem.authorizePermission(user1);
                    System.out.println(user1.getPermissionList().get(0).getName());
                } else Utils.showError();
            }
            if(lc==6){
                System.out.println("Criteria id: "); criteriaId=Utils.SC.nextLine();
                Criteria criteria=CriteriaRepositoryImpl.getInstance().findById(criteriaId);
                if(criteria==null) System.out.println("Not exist criteria with this id");
                else {
                    List<Evidence> list=evidenceSystem.listEvidenceByCriteria(criteria);
                    if(list.size()==0) Utils.showErrorEvidences();
                    else list.forEach(p-> System.out.println(p.getId()));
                }
            }
            if(lc==7){
                System.out.println("Name: "); name=Utils.SC.nextLine();
                Evidence evidence=evidenceSystem.findByName(name);
                if(evidence!=null){
                    evidence.show();
                } else Utils.showErrorEvidences();
            }
            if(lc==8){
                System.out.println("Name of department: "); name=Utils.SC.nextLine();
                List<Evidence> evidences=evidenceSystem.findByDepartment(name);
                if(evidences.size()==0) Utils.showErrorEvidences();
                else {
                    evidences.forEach(p-> System.out.println(p.getId()));
                }
            }
            if(lc==9){
                System.out.println("Date: "); date= Utils.SC.nextLine();
                List<Evidence> evidences=evidenceSystem.findByPromulgateDate(date);
                if(evidences.size()==0) Utils.showErrorEvidences();
                else {
                    evidences.forEach(p-> System.out.println(p.getId()));
                }
            }
            if(lc==10){
                System.out.println("Relation name: "); name=Utils.SC.nextLine();
                List<Evidence> evidences=evidenceSystem.findByRelationName(name);
                if(evidences.size()==0) Utils.showErrorEvidences();
                else {
                    evidences.forEach(p-> System.out.println(p.getId()));
                }
            }
            if(lc==11){
                System.out.println("Id: "); departmentId=Integer.parseInt(Utils.SC.nextLine());
                List<Evidence> list=evidenceSystem.findByProvideDepartment(departmentId);
                if(list.size()==0) Utils.showErrorEvidences();
                else {
                    list.forEach(p-> System.out.println(p.getName()));
                }
            }
            if(lc==12){
                evidenceSystem.sortByName();
            }
            if(lc==13){
                evidenceSystem.sortByCreatedDate();
            }
            if(lc==14) {
                EvidenceRepositoryImpl.getInstance().findAll().forEach(Evidence::show);
            }
            if(lc==15){
                if(user.getPermissionList().contains(PermissionRepositoryImpl.getInstance().findById(8))){
                    evidenceSystem.createEvidence();
                } else Utils.showError();
            }
            if(lc==16){
                if(user.getPermissionList().contains(PermissionRepositoryImpl.getInstance().findById(9))){
                    Evidence evidence=evidenceSystem.inputEvidence(evidenceId);
                    evidenceSystem.promulgateDate(evidence);
                } else Utils.showError();
            }
            if(lc==0){
                break;
            }
        }
    }
    private static String p1Id,p2Id, criteriaId,evidenceId, name, date,userId;
    private static int departmentId;

}
