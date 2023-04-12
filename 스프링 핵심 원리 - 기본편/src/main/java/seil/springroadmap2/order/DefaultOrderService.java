package seil.springroadmap2.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import seil.springroadmap2.discount.DiscountPolicy;
import seil.springroadmap2.member.Member;
import seil.springroadmap2.member.MemberRepository;

@Component
@RequiredArgsConstructor
public class DefaultOrderService implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(final Long memberId, final String itemName, final int itemPrice) {
        final Member member = memberRepository.findById(memberId);
        final int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
