package seil.springroadmap2;

import seil.springroadmap2.discount.FixDiscountPolicy;
import seil.springroadmap2.member.DefaultMemberService;
import seil.springroadmap2.member.MemberService;
import seil.springroadmap2.member.MemoryMemberRepository;
import seil.springroadmap2.order.DefaultOrderService;
import seil.springroadmap2.order.OrderService;

public class AppConfig {

    public MemberService memberService() {
        return new DefaultMemberService(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new DefaultOrderService(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
