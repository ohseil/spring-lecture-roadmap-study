package seil.springroadmap2.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import seil.springroadmap2.member.DefaultMemberService;
import seil.springroadmap2.member.Grade;
import seil.springroadmap2.member.Member;
import seil.springroadmap2.member.MemberService;

public class OrderServiceTest {

    private final MemberService memberService = new DefaultMemberService();
    private final OrderService orderService = new DefaultOrderService();

    @Test
    void createOrder() {
        final Long memberId = 1L;
        final Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
