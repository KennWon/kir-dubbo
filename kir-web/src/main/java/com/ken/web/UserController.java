package com.ken.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ken.common.BaseResult;
import com.ken.common.Constants;
import com.ken.common.ReturnData;
import com.ken.dto.UserReq;
import com.ken.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = {"User"}, basePath = "/v1/user", description = "用户")
@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Reference(version = "1.0.0")
    private UserService userService;

    /**
     * 添加用户
     *
     */
    @ApiOperation(value = "创建用户", response = ReturnData.class)
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public BaseResult createUser(@RequestBody UserReq req) {

        int result=userService.insertInfo(req);

        System.out.print("hello word");

        return new ReturnData(Constants.RESPONSE_SUCCESS, result);
    }
}
