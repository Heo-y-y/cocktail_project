package com.BE.cocktail.controller.bookmark;

import com.BE.cocktail.dto.apiResponse.ApiResponse;
import com.BE.cocktail.dto.bookmark.BookmarkFindAllResponseDto;
import com.BE.cocktail.dto.bookmark.BookmarkRequestDto;
import com.BE.cocktail.dto.utils.MultiResponseDto;
import com.BE.cocktail.service.bookmark.BookmarkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookmark")
@Api(tags = "Bookmark", description = "북마크 API")
@RequiredArgsConstructor
public class BookmarkController {
    private final BookmarkService bookmarkService;

    @ApiOperation(value = "북마크 등록", notes = "북마크 등록 API")
    @ApiImplicitParam(name = "recipe_id", value = "정규 레시피 또는 커스텀 레시피 아이디")
    @PostMapping("/submit/{recipe_id}")
    public ApiResponse<Void> submitBookmark(@PathVariable("recipe_id") Long id, @RequestBody BookmarkRequestDto requestDto) {
        bookmarkService.checkBookmark(id, requestDto);
        return ApiResponse.bookmark();
    }

    @ApiOperation(value = "북마크 취소", notes = "북마크 취소 API")
    @ApiImplicitParam(name = "recipe_id", value = "정규 레시피 또는 커스텀 레시피 아이디")
    @DeleteMapping("/cancel/{recipe_id}")
    public ApiResponse<Void> cancelBookmark(@PathVariable("recipe_id") Long id, @RequestBody BookmarkRequestDto requestDto) {
        bookmarkService.cancelBookmark(id, requestDto);
        return ApiResponse.cancelBookmark();
    }

    @ApiOperation(value = "나의 북마크목록 조회", notes = "나의 북마크 조회 API")
    @GetMapping("/findAll")
    public ApiResponse<MultiResponseDto<BookmarkFindAllResponseDto>> findBookmark(@RequestParam int page, @RequestParam int size) {
        return ApiResponse.ok(bookmarkService.findAll(page - 1, size));
    }
}
