package seil.springroadmap2.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import seil.springroadmap2.AppConfig;
import seil.springroadmap2.member.DefaultMemberService;
import seil.springroadmap2.member.Member;
import seil.springroadmap2.member.MemberRepository;
import seil.springroadmap2.order.DefaultOrderService;
import seil.springroadmap2.order.OrderService;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSIngletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        DefaultMemberService memberService = ac.getBean("memberService", DefaultMemberService.class);
        DefaultOrderService orderService = ac.getBean("orderService", DefaultOrderService.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberService -> memberRepository = " + memberRepository1);
        System.out.println("orderService -> memberRepository = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);

        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig appConfig = ac.getBean(AppConfig.class);

        System.out.println("bean = " + appConfig.getClass());
    }
}
