package com.BE.cocktail.controller.member;

import com.BE.cocktail.dto.apiResponse.ApiResponse;
import com.BE.cocktail.dto.member.MemberInfoResponseDto;
import com.BE.cocktail.dto.member.MemberUpdateDto;
import com.BE.cocktail.dto.member.SignUpDto;
import com.BE.cocktail.service.member.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@Api(tags = "member",description = "유저 API")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @ApiOperation(value = "회원가입", notes = "회원가입 API")
    @PostMapping("/signup")
    public ApiResponse<Void> signUpMember(@Valid @RequestBody SignUpDto sign) {
        memberService.saveMember(sign);
        return ApiResponse.ok();
    }

    @ApiOperation(value = "회원 상세 정보", notes = "회원 상제 정보 API")
    @GetMapping("/member/myPage")
    public ApiResponse<MemberInfoResponseDto> findMypageInfo() {
        return ApiResponse.ok(memberService.findMyPageInfo());
    }

    @ApiOperation(value = "회원 정보 내용 수정", notes = "회원 정보 내용 수정 API")
    @PatchMapping("/member/update/content")
    public ApiResponse<Void> updateMyPageContent(@RequestBody MemberUpdateDto updateDto) {
        memberService.updateContent(updateDto);
        return ApiResponse.ok();
    }

    @ApiOperation(value = "회원 정보 image 수정", notes = "회원 정보 이미지 수정 API")
    @PatchMapping(value = "/member/update/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ApiResponse<Void> updateMyPageImage(@RequestPart(value="image") MultipartFile image) throws IOException {
        if(image.getSize() == 0) return ApiResponse.ok();
        memberService.updateImage(image);
        return ApiResponse.ok();
    }
}