package nospring.core.order;

import nospring.core.discount.DiscountPolicy;
import nospring.core.discount.FixDiscountPolicy;
import nospring.core.member.Grade;
import nospring.core.member.Member;
import nospring.core.member.MemberRepository;
import nospring.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private  MemberRepository memberRepository; //save, findById
    private  DiscountPolicy discountPolicy; //discount

    @Autowired(required = false)
    public void setMemberRepository(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }

      @Autowired(required = false)
      public void setDiscountPolicy(DiscountPolicy discountPolicy){
          this.discountPolicy=discountPolicy;
      }

    @Autowired
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

    //Test
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
