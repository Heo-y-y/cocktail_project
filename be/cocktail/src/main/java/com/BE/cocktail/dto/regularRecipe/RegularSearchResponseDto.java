package com.BE.cocktail.dto.regularRecipe;

import com.BE.cocktail.persistence.domain.regularRecipe.RegularRecipe;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RegularSearchResponseDto {
    private Long id;
    private String name;
    private String imageUrl;
    private String ingredient;
    private String category = "REGULAR_RECIPE";

    public RegularSearchResponseDto(Long id, String name, String imageUrl, String ingredient) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.ingredient = ingredient;
    }

    public static RegularSearchResponseDto of(RegularRecipe recipe) {
        return new RegularSearchResponseDto(recipe.getId(), recipe.getName(), recipe.getImageUrl(), recipe.getIngredient());
    }

    public static List<RegularSearchResponseDto> listOf(List<RegularRecipe> recipes) {
        return recipes.stream().map(RegularSearchResponseDto::of).collect(Collectors.toList());
    }
}
