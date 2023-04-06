package seil.springroadmap2.order;

import seil.springroadmap2.discount.DiscountPolicy;
import seil.springroadmap2.discount.FixDiscountPolicy;
import seil.springroadmap2.member.Member;
import seil.springroadmap2.member.MemberRepository;
import seil.springroadmap2.member.MemoryMemberRepository;

public class DefaultOrderService implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(final Long memberId, final String itemName, final int itemPrice) {
        final Member member = memberRepository.findById(memberId);
        final int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
