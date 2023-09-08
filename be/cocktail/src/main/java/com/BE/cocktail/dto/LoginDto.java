package com.BE.cocktail.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import javax.validation.constraints.NotBlank;


@Getter
public class LoginDto {
    @ApiModelProperty(example = "이메일")
    @NotBlank
    private String email;
    @ApiModelProperty(example = "비밀번호")
    @NotBlank
    private String password;
}
