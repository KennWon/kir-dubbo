package com.ken.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ken.model.City;
import com.ken.mongodb.MongoCityDao;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0.0")
public class MongoCityServiceImpl implements  MongoCityService {

    @Autowired
    private MongoCityDao mongoCityDao;

    @Override
    public void insertInfo(City city) {
         mongoCityDao.insert(city);
    }
}
