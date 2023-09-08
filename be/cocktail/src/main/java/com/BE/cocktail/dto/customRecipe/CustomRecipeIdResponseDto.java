package com.BE.cocktail.dto.customRecipe;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomRecipeIdResponseDto {
    @ApiModelProperty(example = "커스텀 레시피 아이디")
    private Long recipeId;

    public static CustomRecipeIdResponseDto of(Long recipeId) {
        return new CustomRecipeIdResponseDto(recipeId);
    }
}