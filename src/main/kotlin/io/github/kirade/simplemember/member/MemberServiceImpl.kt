package io.github.kirade.simplemember.member

class MemberServiceImpl: MemberService {

    // DIP 위반 -> 구현에 의존
    private val memberRepository: MemberRepository = MemoryMemberRepository()

    override fun join(member: Member) {
        memberRepository.save(member)
    }

    override fun findMember(memberId: Long): Member? {
        return memberRepository.findById(memberId)
    }
}