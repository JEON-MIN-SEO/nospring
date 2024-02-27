package nospring.core.member;

import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
//    MemberRepository memberRepository = new MemoryMemberRepository(); //cmd + shift + enter
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //Test
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
