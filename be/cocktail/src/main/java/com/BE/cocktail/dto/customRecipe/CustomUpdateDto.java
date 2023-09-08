package com.BE.cocktail.dto.customRecipe;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
public class CustomUpdateDto {
    @ApiModelProperty(example = "레시피 이름")
    @Pattern(regexp = "^([가-힣\\(\\)\\{\\}\\[\\]]+\\s*)*$")
    @Size(min=1, max=255)
    private String name;
    @ApiModelProperty(example = "레시피 설명")
    @Pattern(regexp = "^([가-힣a-zA-Z0-9.!\\(\\)\\{\\}\\[\\]]+\\s*)*$")
    @Size(min=1, max=255)
    private String description;
    @ApiModelProperty(example = "레시피")
    @Size(max=900)
    private String recipe;
    @ApiModelProperty(example = "레시피 재료")
    @Pattern(regexp = "^([가-힣a-zA-Z0-9]+\\s*)*$")
    private String ingredient;
}
