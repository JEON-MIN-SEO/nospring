package nospring.core;

import nospring.core.member.Grade;
import nospring.core.member.Member;
import nospring.core.member.MemberService;
import nospring.core.member.MemberServiceImpl;
import nospring.core.order.Order;
import nospring.core.order.OrderService;
import nospring.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("Order ="+ order.toString());
        System.out.println(order.calculatePrice());
    }
}
