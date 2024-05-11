package io.github.kirade.simplemember.discount

import io.github.kirade.simplemember.member.Member

interface DiscountPolicy {
    fun discount(member: Member, price: Int): Int
}