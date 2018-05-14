package com.ken.service;

import com.ken.model.City;

/**
 * 城市业务 Dubbo Mongodb服务层
 *
 * Created by bysocket on 28/02/2017.
 */
public interface MongoCityService {

    void insertInfo(City city);
}
