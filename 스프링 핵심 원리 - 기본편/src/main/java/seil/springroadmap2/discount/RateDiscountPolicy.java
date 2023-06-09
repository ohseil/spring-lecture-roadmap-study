package seil.springroadmap2.discount;

import org.springframework.stereotype.Component;
import seil.springroadmap2.annotation.MainDiscountPolicy;
import seil.springroadmap2.member.Grade;
import seil.springroadmap2.member.Member;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

    private final int discountPercent = 10;
    @Override
    public int discount(final Member member, final int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
