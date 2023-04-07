package seil.springroadmap2;

import seil.springroadmap2.discount.DiscountPolicy;
import seil.springroadmap2.discount.FixDiscountPolicy;
import seil.springroadmap2.discount.RateDiscountPolicy;
import seil.springroadmap2.member.DefaultMemberService;
import seil.springroadmap2.member.MemberRepository;
import seil.springroadmap2.member.MemberService;
import seil.springroadmap2.member.MemoryMemberRepository;
import seil.springroadmap2.order.DefaultOrderService;
import seil.springroadmap2.order.OrderService;

public class AppConfig {

    public MemberService memberService() {
        return new DefaultMemberService(memberRepository());
    }

    public OrderService orderService() {
        return new DefaultOrderService(memberRepository(), discountPolicy());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    private DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
