package nospring.core;

import nospring.core.member.Grade;
import nospring.core.member.Member;
import nospring.core.member.MemberService;
import nospring.core.member.MemberServiceImpl;
import nospring.core.order.Order;
import nospring.core.order.OrderService;
import nospring.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    //MemberService는 회원 생성 및 조회 join(Member member); findMember(Long memberId);
    //OrderService는 주문을 위한 클래스로 Order createOrder(Long memberId, String itemName, int itemPrice);
    //MemberRepository는 회원 저장 및 회원 찾기 void save(Member member);  Member findById(Long memberId)
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class );
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();
        //MemberService memberService = new MemberServiceImpl();
        //OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("Order ="+ order.toString());
        System.out.println(order.calculatePrice());
    }
}
