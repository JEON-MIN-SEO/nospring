package nospring.core.beanfind;

import nospring.core.AutoAppConfig;
import nospring.core.discount.DiscountPolicy;
import nospring.core.member.Grade;
import nospring.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class AllBeanTest {

    @Test
    void findAllBean() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "UserA", Grade.VIP);
        int discountPrice = discountService.discount(member,10000,"fixDiscountPolicy");
    }

    static class DiscountService {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> discountPolicies;

        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> discountPolicies) {
            this.policyMap = policyMap;
            this.discountPolicies = discountPolicies;
            System.out.println(policyMap);
        }

        public int discount(Member member, int i, String fixDiscountPolicy) {
            return 0;
        }
    }
}
