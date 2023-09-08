package com.BE.cocktail.dto.member;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
public class MemberUpdateDto {
    @ApiModelProperty(example = "닉네임")
    @Pattern(regexp = "^[a-zA-Z가-힣0-9-_.]{2,12}$")
    private String nickname;
    @ApiModelProperty(example = "상태 메세지")
    @Size(min=1, max=255)
    private String statusMessage;
}