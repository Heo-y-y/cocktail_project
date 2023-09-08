package com.BE.cocktail.dto.customRecipe;

import com.BE.cocktail.persistence.domain.customRecipe.CustomRecipe;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomRecipeResponseDto {
    @ApiModelProperty(example = "커스텀 레시피 아이디")
    private Long id;
    @ApiModelProperty(example = "칵테일 이름")
    private String name;
    @ApiModelProperty(example = "칵테일 이미지 URL")
    private String imageUrl;
    @ApiModelProperty(example = "칵테일 설명")
    private String description;
    @ApiModelProperty(example = "칵테일 레시피 범주")
    private String category = "CUSTOM_RECIPE";

    public static CustomRecipeResponseDto of(CustomRecipe customRecipe) {
        CustomRecipeResponseDto customRecipeResponseDto = new CustomRecipeResponseDto();
        customRecipeResponseDto.setId(customRecipe.getId());
        customRecipeResponseDto.setName(customRecipe.getName());
        customRecipeResponseDto.setImageUrl(customRecipe.getImageUrl());
        customRecipeResponseDto.setDescription(customRecipe.getDescription());
        return customRecipeResponseDto;
    }
}
