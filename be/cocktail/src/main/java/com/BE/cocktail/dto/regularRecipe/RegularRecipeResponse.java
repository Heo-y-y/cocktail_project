package com.BE.cocktail.dto.regularRecipe;

import com.BE.cocktail.persistence.domain.regularRecipe.RegularRecipe;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class RegularRecipeResponse {
    @ApiModelProperty(example = "정규 레시피 아이디")
    private Long id;
    @ApiModelProperty(example = "칵테일 이름")
    private String name;
    @ApiModelProperty(example = "칵테일 이미지 URL")
    private String imageUrl;
    @ApiModelProperty(example = "칵테일 설명")
    private String description;

    public static RegularRecipeResponse of(RegularRecipe regularRecipe) {
        RegularRecipeResponse response = new RegularRecipeResponse();
        response.setId(regularRecipe.getId());
        response.setName(regularRecipe.getName());
        response.setImageUrl(regularRecipe.getImageUrl());
        response.setDescription(regularRecipe.getDescription());
        return response;
    }

    public static List<RegularRecipeResponse> listOf(List<RegularRecipe> regularRecipes) {
        return regularRecipes.stream()
                .map(RegularRecipeResponse::of)
                .collect(Collectors.toList());
    }
}
