package seil.springroadmap2.discount;

import seil.springroadmap2.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
