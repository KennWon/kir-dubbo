package com.ken.mongodb;

import com.ken.model.City;
import org.springframework.stereotype.Repository;

@Repository
public class MongoCityDao extends MongoBaseDao<City> {

    @Override
    protected Class<City> getEntityClass() {
        return City.class;
    }
}
