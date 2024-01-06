package com.midlearn.repository;

import com.midlearn.entity.Department;
import com.midlearn.entity.Evidence;
import com.midlearn.entity.EvidenceDepartment;
import com.midlearn.utils.Utils;

import java.time.LocalDate;
import java.util.List;

public class EvidenceRepositoryImpl extends Repository<Evidence,String> implements AbstractInterface {
    private static EvidenceRepositoryImpl instance;
    private EvidenceRepositoryImpl(){}
    public static EvidenceRepositoryImpl getInstance(){
        if(instance==null){
            instance=new EvidenceRepositoryImpl();
        }
        return instance;
    }

    @Override
    public void restore() {
        Evidence e1=new Evidence("E1","D1",LocalDate.parse("11/03/2021", Utils.DATE_TIME_FORMATTER),
                LocalDate.parse("08/03/2021",Utils.DATE_TIME_FORMATTER),
                List.of(new EvidenceDepartment(DepartmentRepositoryImpl.getInstance().findById(1),LocalDate.parse("04/03/2021",Utils.DATE_TIME_FORMATTER)),
                        new EvidenceDepartment(DepartmentRepositoryImpl.getInstance().findById(2),LocalDate.parse("05/03/2021",Utils.DATE_TIME_FORMATTER))),
                DepartmentRepositoryImpl.getInstance().findById(4));
        Evidence e2=new Evidence("E2","D2",LocalDate.parse("11/03/2022", Utils.DATE_TIME_FORMATTER),
                LocalDate.parse("08/03/2022",Utils.DATE_TIME_FORMATTER),
                List.of(new EvidenceDepartment(DepartmentRepositoryImpl.getInstance().findById(3),LocalDate.parse("04/03/2022",Utils.DATE_TIME_FORMATTER)),
                        new EvidenceDepartment(DepartmentRepositoryImpl.getInstance().findById(4),LocalDate.parse("05/03/2022",Utils.DATE_TIME_FORMATTER))),
                DepartmentRepositoryImpl.getInstance().findById(1));
        Evidence e3=new Evidence("E3","D3",LocalDate.parse("11/03/2023", Utils.DATE_TIME_FORMATTER),
                LocalDate.parse("08/03/2023",Utils.DATE_TIME_FORMATTER),
                List.of(new EvidenceDepartment(DepartmentRepositoryImpl.getInstance().findById(1),LocalDate.parse("04/03/2023",Utils.DATE_TIME_FORMATTER)),
                        new EvidenceDepartment(DepartmentRepositoryImpl.getInstance().findById(3),LocalDate.parse("05/03/2023",Utils.DATE_TIME_FORMATTER))),
                DepartmentRepositoryImpl.getInstance().findById(2));
        List<Evidence> evidences=List.of(e1,e2,e3);
        EvidenceRepositoryImpl.getInstance().findAll().addAll(evidences);
    }
}
