package io.github.kirade.simplemember.discount

import io.github.kirade.simplemember.annotation.MainDiscountPolicy
import io.github.kirade.simplemember.member.Grade
import io.github.kirade.simplemember.member.Member
import org.springframework.stereotype.Component

@Component
@MainDiscountPolicy
class RateDiscountPolicy: DiscountPolicy {
    private val discountPercent: Int = 10

    override fun discount(member: Member, price: Int): Int {
        if (member.grade == Grade.VIP) {
            return price * discountPercent / 100
        }
        return 0
    }
}