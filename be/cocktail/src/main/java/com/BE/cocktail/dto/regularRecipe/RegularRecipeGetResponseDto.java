package com.BE.cocktail.dto.regularRecipe;

import com.BE.cocktail.persistence.domain.regularRecipe.RegularRecipe;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RegularRecipeGetResponseDto {
    @ApiModelProperty(example = "정규 레시피 아이디")
    private Long id;
    @ApiModelProperty(example = "칵테일 이름")
    private String name;
    @ApiModelProperty(example = "칵테일 재료")
    private String ingredient;
    @ApiModelProperty(example = "칵테일 설명")
    private String description;
    @ApiModelProperty(example = "칵테일 레시피")
    private String recipe;
    @ApiModelProperty(example = "칵테일 이미지 URL")
    private String imageUrl;
    @ApiModelProperty(example = "칵테일 찜 여부")
    private boolean wishList;

    public static RegularRecipeGetResponseDto of(RegularRecipe regularRecipe) {
        return new RegularRecipeGetResponseDto(
                regularRecipe.getId(),
                regularRecipe.getName(),
                regularRecipe.getIngredient(),
                regularRecipe.getDescription(),
                regularRecipe.getRecipe(),
                regularRecipe.getImageUrl(),
                false);
    }

    public static RegularRecipeGetResponseDto bookmarkof(RegularRecipe regularRecipe, boolean check) {
        return new RegularRecipeGetResponseDto(
                regularRecipe.getId(),
                regularRecipe.getName(),
                regularRecipe.getIngredient(),
                regularRecipe.getDescription(),
                regularRecipe.getRecipe(),
                regularRecipe.getImageUrl(),
                check);
    }
}
