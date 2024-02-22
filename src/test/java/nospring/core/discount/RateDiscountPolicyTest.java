package nospring.core.discount;

import nospring.core.member.Grade;
import nospring.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("Vip 10%")
    void vip_0(){
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP); //option + command + V
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(1000); //option + Enter => Static import
    }

}