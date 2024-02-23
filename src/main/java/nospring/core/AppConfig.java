package nospring.core;

import nospring.core.discount.DiscountPolicy;
import nospring.core.discount.FixDiscountPolicy;
import nospring.core.member.MemberRepository;
import nospring.core.member.MemberService;
import nospring.core.member.MemberServiceImpl;
import nospring.core.member.MemoryMemberRepository;
import nospring.core.order.OrderService;
import nospring.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public MemberService memberService() { //join findMember
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService() { //주문 하는 클래스(객체 이름, 가격 등)
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
