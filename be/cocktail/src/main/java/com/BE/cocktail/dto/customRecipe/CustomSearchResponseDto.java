package com.BE.cocktail.dto.customRecipe;

import com.BE.cocktail.persistence.domain.customRecipe.CustomRecipe;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomSearchResponseDto {
    @ApiModelProperty(example = "커스텀 레시피 아이디")
    private Long id;
    @ApiModelProperty(example = "칵테일 이름")
    private String name;
    @ApiModelProperty(example = "칵테일 이미지 URL")
    private String imageUrl;
    @ApiModelProperty(example = "칵테일 재료")
    private String ingredient;

    public static CustomSearchResponseDto of(CustomRecipe recipe) {
        return new CustomSearchResponseDto(recipe.getId(), recipe.getName(), recipe.getImageUrl(), recipe.getIngredient());
    }

    public static List<CustomSearchResponseDto> listOf(List<CustomRecipe> customRecipes) {
        return customRecipes.stream().map(CustomSearchResponseDto::of).collect(Collectors.toList());
    }
}
