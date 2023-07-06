package com.example.study_springboots.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.study_springboots.dao.SharedDao;

@Service
@Transactional
public class CarCompanyService {
    @Autowired
    SharedDao sharedDao;

        // 검색
        public Object selectSearch(String search, String words) {
        // Object getOne(String sqlMapId, Object dataMap)
        String sqlMapId = "CarCompany.selectSearch";
        HashMap dataMap = new HashMap<>();
        dataMap.put("search", search);
        dataMap.put("words", words);

        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;
    }

        public Object selectAll(String COMPANY) {
        // Object getOne(String sqlMapId, Object dataMap)
        String sqlMapId = "CarCompany.selectAll";
        HashMap dataMap = new HashMap<>();
        dataMap.put("COMPANY", COMPANY);

        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;
    }

    public Object selectDetail(String COMPANY) {
        // Object getOne(String sqlMapId, Object dataMap)
        String sqlMapId = "CarCompany.selectByUID";
        HashMap dataMap = new HashMap<>();
        dataMap.put("COMPANY", COMPANY);

        Object result = sharedDao.getOne(sqlMapId, dataMap);
        return result;
    }

    //입력
    public Object insert(Map dataMap){
        String sqlMapId = "CarCompany.insert";
        Object result = sharedDao.insert(sqlMapId,dataMap);
        return result;
    }

    public Object update(Map dataMap){
        String sqlMapId = "CarCompany.update";
        Object result = sharedDao.update(sqlMapId,dataMap);
        return null;
    }

     public Object delete(String COMPANY){
        String sqlMapId = "CarCompany.delete";
        HashMap dataMap = new HashMap<>();
        dataMap.put("COMPANY", COMPANY);

        Object result = sharedDao.delete(sqlMapId,dataMap);
        return result;
    }

        public Object insertDouble(Map dataMap){
        String sqlMapId = "CarCompany.insert";
        Object result = sharedDao.insert(sqlMapId,dataMap);
        result = sharedDao.insert(sqlMapId,dataMap);

        return result;
    }
}
