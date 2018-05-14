package com.ken.model;


import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserModel implements Serializable {

    private Integer id;

    //    @NotNull(message = "手机号不能为空")
//    @Pattern(regexp = Constants.REGEXP_MOBILE, message = "手机号码格式不对")
    @ApiModelProperty(value = "手机号码", required = true)
    private String account;

    //    @NotNull(message = "密码不能为空")
//    @Size(min = 6, max = 16, message = "密码长度为6-20位字符")
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