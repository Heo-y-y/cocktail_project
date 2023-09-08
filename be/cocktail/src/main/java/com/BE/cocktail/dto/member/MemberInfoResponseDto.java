package com.BE.cocktail.dto.member;

import com.BE.cocktail.persistence.domain.member.Member;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberInfoResponseDto {
    @ApiModelProperty(example = "프로필 이미지 URL")
    private String imageUrl;
    @ApiModelProperty(example = "닉네임")
    private String nickName;
    @ApiModelProperty(example = "프로필 설명")
    private String description;

    public static MemberInfoResponseDto of(Member member) {
        return new MemberInfoResponseDto(member.getImageUrl(), member.getNickname(), member.getStatusMessage());
    }
}
