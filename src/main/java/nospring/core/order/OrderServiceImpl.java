package nospring.core.order;

import nospring.core.discount.DiscountPolicy;
import nospring.core.discount.FixDiscountPolicy;
import nospring.core.member.Member;
import nospring.core.member.MemberRepository;
import nospring.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository(); //save, findById
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); //discount Fix

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
