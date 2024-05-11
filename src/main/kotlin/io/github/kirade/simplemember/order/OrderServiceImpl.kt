package io.github.kirade.simplemember.order

import io.github.kirade.simplemember.discount.DiscountPolicy
import io.github.kirade.simplemember.discount.FixDiscountPolicy
import io.github.kirade.simplemember.member.MemberRepository
import io.github.kirade.simplemember.member.MemoryMemberRepository
import java.lang.IllegalStateException

class OrderServiceImpl: OrderService {
    private val memberRepository: MemberRepository = MemoryMemberRepository()
    private val discountPolicy: DiscountPolicy = FixDiscountPolicy()

    override fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order {
        val member = memberRepository.findById(memberId) ?: throw IllegalStateException("Member with id=$memberId does not exist")
        val discountPrice = discountPolicy.discount(member, itemPrice)

        return Order(memberId, itemName, itemPrice, discountPrice)
    }
}