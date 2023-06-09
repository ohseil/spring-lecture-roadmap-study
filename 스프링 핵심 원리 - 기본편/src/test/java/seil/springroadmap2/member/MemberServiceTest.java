package seil.springroadmap2.member;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seil.springroadmap2.AppConfig;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberServiceTest {

    private MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then
        assertThat(member).isEqualTo(findMember);
    }
}
