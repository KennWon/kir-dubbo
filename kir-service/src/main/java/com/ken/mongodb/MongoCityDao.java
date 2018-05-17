package com.ken.mongodb;

import com.ken.model.Goods;
import org.springframework.stereotype.Repository;

@Repository
public class MongoCityDao extends MongoBaseDao<Goods> {

    @Override
    protected Class<Goods> getEntityClass() {
        return Goods.class;
    }
}
