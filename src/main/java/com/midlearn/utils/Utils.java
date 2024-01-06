package com.midlearn.utils;

import com.midlearn.entity.Department;
import com.midlearn.entity.Evidence;
import com.midlearn.entity.EvidenceDepartment;
import com.midlearn.repository.DepartmentRepositoryImpl;
import com.midlearn.repository.EvidenceRepositoryImpl;
import com.midlearn.repository.UserRepositoryImpl;

import java.io.*;
import java.nio.CharBuffer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {
    public static final Scanner SC=new Scanner(System.in);
    public static final DateTimeFormatter DATE_TIME_FORMATTER=DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static void readFile() {
        try {
            File file=new File("data.txt");
            Scanner scanner=new Scanner(file);
            while(scanner.hasNextLine()){
                Evidence evidence=new Evidence();
                String name=scanner.nextLine(); evidence.setName(name);
                String promulgatePlace=scanner.nextLine(); evidence.setPromulgatePlace(promulgatePlace);
                LocalDate promulgateDate=LocalDate.parse(scanner.nextLine(),DATE_TIME_FORMATTER);
                evidence.setPromulgateDate(promulgateDate);
                LocalDate createDate=LocalDate.parse(scanner.nextLine(),DATE_TIME_FORMATTER); evidence.setCreateDate(createDate);
                int count=Integer.parseInt(scanner.nextLine());
                for(int i=0;i<count;i++){
                    EvidenceDepartment evidenceDepartment=new EvidenceDepartment();
                    int departmentId=Integer.parseInt(scanner.nextLine());
                    evidenceDepartment.setDepartment(DepartmentRepositoryImpl.getInstance().findById(departmentId));
                    String s=scanner.nextLine();
                    evidenceDepartment.setSupplyDate(LocalDate.parse(s,Utils.DATE_TIME_FORMATTER));
                    evidence.getEvidenceDepartments().add(evidenceDepartment);
                }
                Integer department=Integer.parseInt(scanner.nextLine()); evidence.setDepartment(DepartmentRepositoryImpl.getInstance().findById(department));
                EvidenceRepositoryImpl.getInstance().save(evidence);
            }
            System.out.println("Import Evidence successfully");
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void showError(){
        System.out.println("Not permission");
    }
    public static void showErrorEvidences(){
        System.out.println("No evidences");
    }
    public static LocalDate setDateCorrectFormat(){
        String input;
        LocalDate date;
        while (true) {
            try {
                input=Utils.SC.nextLine();
                date = LocalDate.parse(input, Utils.DATE_TIME_FORMATTER);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Incorrect format");
            }
        }
        return date;
    }
}
