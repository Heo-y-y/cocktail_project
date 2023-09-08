package com.BE.cocktail.dto.bookmark;

import com.BE.cocktail.persistence.domain.bookmark.Bookmark;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
public class BookmarkRequestDto {
    @ApiModelProperty(example = "레시피 범주")
    private Bookmark.RecipeType recipeType;
}
