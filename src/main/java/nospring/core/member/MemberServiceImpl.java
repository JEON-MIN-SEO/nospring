package nospring.core.member;

public class MemberServiceImpl implements MemberService {

    MemberRepository memberRepository = new MemoryMemberRepository(); //cmd + shift + enter
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
