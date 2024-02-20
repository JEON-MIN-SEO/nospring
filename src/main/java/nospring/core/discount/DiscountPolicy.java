package nospring.core.discount;

import nospring.core.member.Member;

public interface DiscountPolicy {
    //値段を返す
    int discount(Member member, int price);
}
