package io.github.kirade.simplemember

import io.github.kirade.simplemember.member.Grade
import io.github.kirade.simplemember.member.Member
import io.github.kirade.simplemember.member.MemberService
import io.github.kirade.simplemember.member.MemberServiceImpl


fun main(args: Array<String>) {
    val memberService: MemberService = MemberServiceImpl()
    val member: Member = Member(1L, "memberA", Grade.VIP)
    memberService.join(member)

    val findMember: Member? = memberService.findMember(1L)

    println(member.name)
    println(findMember?.name)
}

