package com.BE.cocktail.dto.customRecipe;

import com.BE.cocktail.persistence.domain.customRecipe.CustomRecipe;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomRecipeGetResponseDto {
    private Long id;
    private String name;
    private String ingredient;
    private String recipe;
    private String description;
    private String imageUrl;
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
