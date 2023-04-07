package seil.springroadmap2;

import seil.springroadmap2.member.DefaultMemberService;
import seil.springroadmap2.member.Grade;
import seil.springroadmap2.member.Member;
import seil.springroadmap2.member.MemberService;
import seil.springroadmap2.order.DefaultOrderService;
import seil.springroadmap2.order.Order;
import seil.springroadmap2.order.OrderService;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
