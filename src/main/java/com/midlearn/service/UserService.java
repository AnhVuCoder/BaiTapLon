package com.midlearn.service;

import com.midlearn.entity.Permission;
import com.midlearn.entity.User;
import com.midlearn.repository.DepartmentRepositoryImpl;
import com.midlearn.repository.PermissionRepositoryImpl;
import com.midlearn.utils.Utils;

import java.util.List;

public class UserService {
    public void authorizePermission(User manager, User user) throws Exception {
        if(!DepartmentRepositoryImpl.getInstance().findById(user.getDepartment().getId()).getManagerId().equals(manager.getId())) throw new Exception("This user is not manager of user");
        List<Permission> permissionList=user.getPermissionList();
        int count= PermissionRepositoryImpl.getInstance().findAll().size();
        while(Utils.SC.hasNext()){
            int flag=Integer.parseInt(Utils.SC.nextLine());
            if(flag<=0 || flag>count) break;
            permissionList.add(PermissionRepositoryImpl.getInstance().findById(flag));
        }
    }
}
