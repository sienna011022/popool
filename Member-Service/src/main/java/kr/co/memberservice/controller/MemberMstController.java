package kr.co.memberservice.controller;

import io.swagger.annotations.ApiOperation;
import kr.co.memberservice.domain.dto.MemberMstDto;
import kr.co.memberservice.service.MemberMstServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/kr/co/memberMst")//복수화 (RestAPI 설계) 구글링
@RequiredArgsConstructor
public class MemberMstController {

    private final MemberMstServiceImpl memberMstService;

    @ApiOperation("회원가입")
    @PostMapping("/signUp")
    public void signUp(@RequestBody @Valid MemberMstDto.CREATE create){
        //To do...
        memberMstService.signUp(create);
    }

    @ApiOperation("아이디 중복 체크")
    @PostMapping("/signUp/check")
    public void checkIdentity(@RequestParam("identity") String identity){
        //To do...
    }
}
