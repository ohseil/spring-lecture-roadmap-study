package seil.springroadmap2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import seil.springroadmap2.discount.DiscountPolicy;
import seil.springroadmap2.discount.RateDiscountPolicy;
import seil.springroadmap2.member.DefaultMemberService;
import seil.springroadmap2.member.MemberRepository;
import seil.springroadmap2.member.MemberService;
import seil.springroadmap2.member.MemoryMemberRepository;
import seil.springroadmap2.order.DefaultOrderService;
import seil.springroadmap2.order.OrderService;

@Configuration
public class AppConfig {

    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository()

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new DefaultMemberService(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new DefaultOrderService(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
