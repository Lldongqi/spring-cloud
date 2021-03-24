package com.example.securityService.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@ApiModel("register参数")
public class RegisterForm implements Serializable {
    @ApiModelProperty(value = "name",required = true)
    @NotBlank
    private String name;

    @ApiModelProperty(value = "name",required = true)
    @NotBlank
    private Integer password;
}
