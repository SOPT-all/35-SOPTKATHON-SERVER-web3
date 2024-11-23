package sopt.web3.demo.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sopt.web3.demo.common.dto.SuccessResponse;
import sopt.web3.demo.dto.response.TodayInfoGetResponse;
import sopt.web3.demo.service.MemberService;

import java.time.LocalDate;

import static sopt.web3.demo.common.dto.SuccessResponse.success;
import static sopt.web3.demo.common.messages.SuccessMessages.GET_LEVEL;

@RestController
@RequestMapping("/api")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/member/level")
    public ResponseEntity<SuccessResponse<Long>> getInterests(
            @RequestHeader("Member-Id") long memberId
    ) {
        long level = memberService.getLevel(memberId);
        return ResponseEntity.ok(success(GET_LEVEL.getMessage(), level));
    }
}
