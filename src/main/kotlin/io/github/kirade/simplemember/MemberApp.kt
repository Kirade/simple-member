package io.github.kirade.simplemember

import io.github.kirade.simplemember.member.Grade
import io.github.kirade.simplemember.member.Member
import io.github.kirade.simplemember.member.MemberService


fun main(args: Array<String>) {
    val appConfig = AppConfig()
    val memberService: MemberService = appConfig.memberService()
    val member = Member(1L, "memberA", Grade.VIP)
    memberService.join(member)

    val findMember: Member? = memberService.findMember(1L)

    println(member.name)
    println(findMember?.name)
}

