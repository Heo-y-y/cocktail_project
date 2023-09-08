package com.BE.cocktail.controller.customeRecipe;

import com.BE.cocktail.dto.apiResponse.ApiResponse;
import com.BE.cocktail.dto.customRecipe.*;
import com.BE.cocktail.dto.utils.MultiResponseDto;
import com.BE.cocktail.service.customRecipe.CustomRecipeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Api(tags = "customRecipe",description = "커스텀 레시피 API")
@RequestMapping(value = "/custom")
public class CustomRecipeController {
    private final CustomRecipeService customRecipeService;

    @ApiOperation(value = "커스텀 레시피 내용 등록", notes = "커스텀 레시피 내용 등록 API")
    @PostMapping("/submit/content")
    public ApiResponse<CustomRecipeIdResponseDto> createContent(@RequestBody @Valid CustomRecipeCreateDto customRecipeCreateDto) {
        return ApiResponse.ok(customRecipeService.saveContentCustomRecipe(customRecipeCreateDto));
    }
    @ApiOperation(value = "커스텀 레시피 사진 등록", notes = "커스텀 레시피 사진 등록 API")
    @ApiImplicitParam(name = "recipe_id", value = "커스텀 레시피 아이디")
    @PostMapping(value="/submit/image/{recipe_id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ApiResponse<Void> createCustomRecipe(@RequestPart(value="image") MultipartFile image, @PathVariable("recipe_id") Long recipeId) throws IOException {
        if(image.getSize() == 0) return ApiResponse.ok();
        customRecipeService.saveImageCustomRecipe(image, recipeId);
        return ApiResponse.created();
    }

    @ApiOperation(value = "커스텀 레시피 검색", notes = "커스텀 레시피 검색 API")
    @ApiImplicitParam(name = "keyword", value = "검색 키워드")
    @GetMapping("/search/{keyword}")
    public ApiResponse<MultiResponseDto<CustomSearchResponseDto>> searchCustom(@PathVariable("keyword") String keyword, @RequestParam int page, @RequestParam int size) {
        return ApiResponse.ok(customRecipeService.searchRecipes(keyword, page - 1, size));
    }

    @ApiOperation(value = "커스텀 레시피 전체 조회", notes = "커스텀 레시피 전체 조회 API")
    @GetMapping("/findAll")
    public ApiResponse<MultiResponseDto<CustomRecipeResponseDto>> findCustoms(@RequestParam int page, @RequestParam int size) {
        return ApiResponse.ok(customRecipeService.findCustoms(page - 1, size));
    }

    @ApiOperation(value = "커스텀 레시피 내용 수정", notes = "커스텀 레시피 내용 수정 API")
    @ApiImplicitParam(name = "recipe_id", value = "커스텀 레시피 아이디")
    @PatchMapping("/update/content/{recipe_id}")
    public ApiResponse<Void> updateContent(@RequestBody @Valid CustomUpdateDto customUpdateDto, @PathVariable("recipe_id") Long recipeId) {
        customRecipeService.updateCustomRecipe(recipeId, customUpdateDto);
        return ApiResponse.ok();
    }

    @ApiOperation(value = "커스텀 레시피 삭제", notes = "커스텀 레시피 삭제 API")
    @ApiImplicitParam(name = "recipe_id", value = "커스텀 레시피 아이디")
    @DeleteMapping("/delete/{recipe_id}")
    public ApiResponse<Void> deleteCustomRecipe(@PathVariable("recipe_id") Long id) {
        customRecipeService.deleteCustomRecipe(id);
        return ApiResponse.deleted();
    }

    @ApiOperation(value = "커스텀 레시피 상세 조회", notes = "커스텀 레시피 상세 조회 API")
    @ApiImplicitParam(name = "recipe_id", value = "커스텀 레시피 아이디")
    @GetMapping("/find/{recipe_id}")
    public ApiResponse<CustomRecipeGetResponseDto> findDetailInfo(@PathVariable("recipe_id") Long id) {
        return ApiResponse.ok(customRecipeService.find(id));
    }

    @ApiOperation(value = "나의 커스텀 레시피 목록 조회", notes = "나의 커스텀 레시피 목록 조회 API")
    @GetMapping("/find/myRecipe")
    public ApiResponse<MultiResponseDto<CustomRecipeResponseDto>> findMyRecipe(@RequestParam int page, @RequestParam int size) {
        return ApiResponse.ok(customRecipeService.findMyRecipe(page - 1, size));
    }
}