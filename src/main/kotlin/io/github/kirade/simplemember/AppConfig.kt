package io.github.kirade.simplemember

import io.github.kirade.simplemember.discount.DiscountPolicy
import io.github.kirade.simplemember.discount.RateDiscountPolicy
import io.github.kirade.simplemember.member.MemberRepository
import io.github.kirade.simplemember.member.MemberService
import io.github.kirade.simplemember.member.MemberServiceImpl
import io.github.kirade.simplemember.member.MemoryMemberRepository
import io.github.kirade.simplemember.order.OrderService
import io.github.kirade.simplemember.order.OrderServiceImpl

class AppConfig {
    private fun memberRepository(): MemberRepository = MemoryMemberRepository()
    private fun discountPolicy(): DiscountPolicy {
        return RateDiscountPolicy()
    }

    fun memberService(): MemberService {
        return MemberServiceImpl(memberRepository())
    }

    fun orderService(): OrderService {
        return OrderServiceImpl(memberRepository(), discountPolicy())
    }

}