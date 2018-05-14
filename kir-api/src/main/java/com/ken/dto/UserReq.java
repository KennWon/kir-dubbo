package com.ken.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserReq {


    @ApiModelProperty(value = "手机号码", required = true)
    private String account;


    @ApiModelProperty(value = "密码", required = true)
    private String password;

    @ApiModelProperty(value = "密码加盐")
    private String salt;
    @ApiModelProperty(value = "名字")
    private String name;
    @ApiModelProperty(value = "身份证号")
    private String idcard;
    @ApiModelProperty(value = "数据状态 -1删除0禁用1启用")
    private Byte status;
    @ApiModelProperty(value = "创建时间")
    private Date createtime;
    @ApiModelProperty(value = "更新时间")
    private Date updatetime;
}
