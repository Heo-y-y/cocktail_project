package com.BE.cocktail.controller.regularRecipe;

import com.BE.cocktail.dto.apiResponse.ApiResponse;
import com.BE.cocktail.dto.regularRecipe.RegularRecipeGetResponseDto;

import com.BE.cocktail.dto.regularRecipe.RegularRecipeResponse;
import com.BE.cocktail.dto.regularRecipe.RegularSearchResponseDto;
import com.BE.cocktail.dto.utils.MultiResponseDto;
import com.BE.cocktail.service.regularRecipe.RegularRecipeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Api(tags = "regularRecipe", description = "정규 레시피 API")
@RequestMapping("/regular")
public class RegularRecipeController {
    private final RegularRecipeService regularRecipeService;

    @ApiOperation(value = "정규 레시피 상세 조회", notes = "정규 레시피 상세 조회 API")
    @ApiImplicitParam(name = "recipe_id", value = "정규 레시피 아이디")
    @GetMapping("/find/{recipe_id}")
    public ApiResponse<RegularRecipeGetResponseDto> findDetailInfo(@PathVariable("recipe_id") Long id) {
        return ApiResponse.ok(regularRecipeService.find(id));
    }

    @ApiOperation(value = "정규 레시피 검색", notes = "정규 레시피 검색 API")
    @ApiImplicitParam(name = "keyword", value = "검색 키워드")
    @GetMapping("/search/{keyword}")
    public ApiResponse<MultiResponseDto<RegularSearchResponseDto>> searchRegular(@PathVariable("keyword") String keyword, @RequestParam int page, @RequestParam int size) {
        return ApiResponse.ok(regularRecipeService.searchRecipes(keyword, page - 1, size));
    }

    @ApiOperation(value = "정규 레시피 전체 조회", notes = "정규 레시피 전체 조회 API")
    @ApiImplicitParam(name = "alc_vol", value = "알코올 도수")
    @GetMapping("/findAll/{alc_vol}")
    public ApiResponse<MultiResponseDto<RegularRecipeResponse>> findRecipes(@PathVariable("alc_vol") Integer alcVolRange, @RequestParam int page, @RequestParam int size) {
        return ApiResponse.ok(regularRecipeService.findAlcVolRange(alcVolRange, page - 1, size));
    }
}
