package com.midlearn.entity;

import com.midlearn.repository.CriteriaRepositoryImpl;
import com.midlearn.utils.Utils;

public class CommonCriteriaAndStandard extends CommonEntity<String> {
    protected String content;
    public void setContent() {
        System.out.println("Content: ");
        this.content = Utils.SC.nextLine();
    }

}
