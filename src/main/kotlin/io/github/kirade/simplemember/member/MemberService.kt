package io.github.kirade.simplemember.member

interface MemberService {
    fun join(member: Member)
    fun findMember(memberId: Long): Member?
}