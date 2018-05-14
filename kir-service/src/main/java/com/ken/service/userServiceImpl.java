package com.ken.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ken.dao.UserDao;
import com.ken.dto.UserReq;
import com.ken.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 用户业务 Dubbo 服务层实现层
 *
 * Created by bysocket on 13/05/2018.
 */
// 注册为 Dubbo 服务
@Service(version = "1.0.0")
public class userServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int insertInfo(UserReq model) {
        return userDao.insertSelective(model);
    }

}
