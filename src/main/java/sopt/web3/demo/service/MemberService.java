package sopt.web3.demo.service;

import org.springframework.stereotype.Component;
import sopt.web3.demo.repository.MemberRepository;

@Component
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public long getLevel(long memberId) {
        return memberRepository.findById(memberId).get().getLevel();
    }
}
