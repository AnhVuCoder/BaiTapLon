package com.midlearn.repository;

import com.midlearn.entity.CommonEntity;

import java.util.ArrayList;
import java.util.List;

public class Repository <T extends CommonEntity<ID>, ID>  {
    private List<T> list=new ArrayList<T>();
    public <S extends T> T findById(ID id){
        return list.stream().filter(e->e.getId().equals(id)).findFirst().orElse(null);
    }
    public <S extends T> List<T> findAll(){
        return list;
    }
    public <S extends T> void save(T t){
        T existingT=this.findById(t.getId());
        if(existingT!=null){
            list.remove(existingT);
        }
        list.add(t);
    }
    public void deleteById(ID id) throws Exception {
        T existingT=this.findById(id);
        if(existingT==null) throw new Exception("Not exist id");
        list.remove(existingT);
    }
}
