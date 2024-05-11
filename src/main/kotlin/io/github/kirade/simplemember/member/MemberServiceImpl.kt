package io.github.kirade.simplemember.member

import org.springframework.stereotype.Component

@Component
class MemberServiceImpl (private val memberRepository: MemberRepository): MemberService {

    override fun join(member: Member) {
        memberRepository.save(member)
    }

    override fun findMember(memberId: Long): Member? {
        return memberRepository.findById(memberId)
    }

    // 테스트 용도
    fun getMemberRepository(): MemberRepository {
        return memberRepository
    }
}