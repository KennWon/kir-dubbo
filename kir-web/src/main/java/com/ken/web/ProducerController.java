package com.ken.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ken.common.BaseResult;
import com.ken.common.Constants;
import com.ken.common.ReturnData;
import com.ken.service.queue.ProducerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"Producer"}, basePath = "/v1/Producer", description = "消息生产")
@RestController
@RequestMapping("/v1/Producer")
public class ProducerController {

    @Reference(version = "1.0.0")
    private ProducerService producerService;


    @ApiOperation(value = "生产消息", response = ReturnData.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "context", value = "消息", required = true, paramType = "path", dataType = "string")
    })
    @RequestMapping(value = "/Producer/{context}", method = RequestMethod.GET)
    public BaseResult createUser(@PathVariable("context") String  context) {

        producerService.producerMessage(context);

        return new ReturnData(Constants.RESPONSE_SUCCESS, 1);
    }

}
