package nospring.core;

import nospring.core.discount.FixDiscountPolicy;
import nospring.core.member.MemberService;
import nospring.core.member.MemberServiceImpl;
import nospring.core.member.MemoryMemberRepository;
import nospring.core.order.OrderService;
import nospring.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
