package com.BE.cocktail.dto.customRecipe;

import com.BE.cocktail.persistence.domain.customRecipe.CustomRecipe;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomRecipeGetResponseDto {
    @ApiModelProperty(example = "커스텀 레시피 아이디")
    private Long id;
    @ApiModelProperty(example = "칵테일 이름")
    private String name;
    @ApiModelProperty(example = "칵테일 재료")
    private String ingredient;
    @ApiModelProperty(example = "칵테일 레시피")
    private String recipe;
    @ApiModelProperty(example = "칵테일 설명")
    private String description;
    @ApiModelProperty(example = "칵테일 이미지 URL")
    private String imageUrl;
    @ApiModelProperty(example = "칵테일 북마크 여부")
    private boolean wishList;

    public static CustomRecipeGetResponseDto of(CustomRecipe customRecipe) {
        return new CustomRecipeGetResponseDto(
                customRecipe.getId(),
                customRecipe.getName(),
                customRecipe.getIngredient(),
                customRecipe.getRecipe(),
                customRecipe.getDescription(),
                customRecipe.getImageUrl(),
                false);
    }

    public static CustomRecipeGetResponseDto bookmarkOf(CustomRecipe customRecipe, boolean check) {
        return new CustomRecipeGetResponseDto(
                customRecipe.getId(),
                customRecipe.getName(),
                customRecipe.getIngredient(),
                customRecipe.getRecipe(),
                customRecipe.getDescription(),
                customRecipe.getImageUrl(),
                check);
    }
}
