package sopt.web3.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sopt.web3.demo.service.MemberService;

import static sopt.web3.demo.common.dto.SuccessResponse.success;

@RestController
@RequestMapping("/api")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/v1/likes")
    public ResponseEntity<SuccessResponse<InterestsGetResponse>> getInterests(
            @RequestHeader long memberId
    ) {
        return ResponseEntity.ok(success(GET_INTERESTS.getMessage(), likes));
    }
}
