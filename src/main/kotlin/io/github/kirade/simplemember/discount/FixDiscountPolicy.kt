package io.github.kirade.simplemember.discount

import io.github.kirade.simplemember.member.Grade
import io.github.kirade.simplemember.member.Member

class FixDiscountPolicy: DiscountPolicy {
    private val discountFixAmount = 1000

    override fun discount(member: Member, price: Int): Int {
        if (member.grade == Grade.VIP) {
            return discountFixAmount
        }
        return 0;
    }
}