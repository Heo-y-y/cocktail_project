package com.BE.cocktail.dto.member;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
public class SignUpDto {
    @ApiModelProperty(example = "이미지 URL")
    private String imageUrl;
    @ApiModelProperty(example = "닉네임")
    @NotBlank
    private String nickName;
    @ApiModelProperty(example = "이메일")
    @Email
    @NotBlank
    private String email;
    @ApiModelProperty(example = "비밀번호")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[#?!@$%^&*-]).{6,24}$") // 영어, 특수문자 조합의 6~24 자리
    @NotBlank
    private String password;
}
