package com.ken.dao;

import com.ken.dto.UserReq;
import com.ken.model.UserModel;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {


    int deleteByPrimaryKey(Integer id);

    int insert(UserModel record);

    int insertSelective(UserReq record);

    UserModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserModel record);

    int updateByPrimaryKey(UserModel record);
}
