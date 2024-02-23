package nospring.core.order;

import nospring.core.discount.DiscountPolicy;
import nospring.core.discount.FixDiscountPolicy;
import nospring.core.member.Grade;
import nospring.core.member.Member;
import nospring.core.member.MemberRepository;
import nospring.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository; //save, findById
    private final DiscountPolicy discountPolicy; //discount

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        //Grade a = member.getGrade();
        int discountPrice = discountPolicy.discount(member, itemPrice);
        //member.getGrade()를 넣고 싶으면 반환값이 Grade여야 한다. 그거 때문에 못 하는거다
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
