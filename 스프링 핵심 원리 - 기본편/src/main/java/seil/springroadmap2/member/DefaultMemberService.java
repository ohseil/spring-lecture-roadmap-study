package seil.springroadmap2.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultMemberService implements MemberService {

    private final MemberRepository memberRepository;

    public DefaultMemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(final Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(final Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
