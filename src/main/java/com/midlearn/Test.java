package com.midlearn;

import com.midlearn.entity.Department;
import com.midlearn.entity.Role;
import com.midlearn.entity.User;
import com.midlearn.repository.*;

public class Test<D extends Test, S> {
    public static void main(String[] args) throws Exception {
        DepartmentRepositoryImpl.getInstance().restore();
        RoleRepositoryImpl.getInstance().restore();
        UserRepositoryImpl.getInstance().restore();
        UserRepositoryImpl.getInstance().findAll().forEach(User::show);
        System.out.println();
        DepartmentRepositoryImpl.getInstance().findAll().forEach(Department::show);
        System.out.println();
        RoleRepositoryImpl.getInstance().findAll().forEach(Role::show);
    }
}
