package nospring.core.singleton;

import nospring.core.AppConfig;
import nospring.core.member.MemberRepository;
import nospring.core.member.MemberServiceImpl;
import nospring.core.order.OrderService;
import nospring.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigTest {
    @Test
    void configTest1(){

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService = ac.getBean("MemberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("OrderService", OrderServiceImpl.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();
    }
}
