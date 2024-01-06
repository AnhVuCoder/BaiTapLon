package com.midlearn.entity;

import com.midlearn.repository.DepartmentRepositoryImpl;
import com.midlearn.repository.RoleRepositoryImpl;
import com.midlearn.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class User extends CommonEntity<String> {
    public static int count;
    private String username;
    private String password;
    private List<Permission> permissionList;
   private Department department;

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    private Role role;

    public User(String username, String password, Department department,
                Role role) {
        this.username = username;
        this.password = password;
        this.department = department;
        this.role = role;
    }

    public User(String username, String password, Department department,
                Role role,
                List<Permission> permissionList) {
        this.username = username;
        this.password = password;
        this.permissionList = permissionList;
        this.department = department;
        this.role = role;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public User(){}
    {
        this.id=String.format("NV%06d",++count);
        this.permissionList=new ArrayList<>();
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<Permission> getPermissionList() {
        return permissionList;
    }
    public void show(){
        System.out.printf("Id: %s\nName: %s\nDepartment: %s\nRole: %s\n",this.id,
                this.username,this.department.getName(),this.role.getName());;
    }

    public void add(DepartmentRepositoryImpl departmentRepository,
                    RoleRepositoryImpl roleRepository) throws Exception {
        System.out.println("Name: "); setUsername(Utils.SC.nextLine());
        System.out.println("Password: "); setPassword(Utils.SC.nextLine());
        System.out.println("Department: "); setDepartment(departmentRepository.findById(Integer.parseInt(Utils.SC.nextLine())));
        System.out.println("Role: "); setRole(roleRepository.findById(Integer.parseInt(Utils.SC.nextLine())));
    }
    public boolean isExistPermission(Integer id){
        Permission permission=permissionList.stream().filter(p->p.getId().equals(id)).findFirst().orElse(null);
        return permission == null;
    }
}
