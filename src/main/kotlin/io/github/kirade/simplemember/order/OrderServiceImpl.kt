package io.github.kirade.simplemember.order

import io.github.kirade.simplemember.discount.DiscountPolicy
import io.github.kirade.simplemember.member.MemberRepository
import org.springframework.stereotype.Component
import java.lang.IllegalStateException


@Component
class OrderServiceImpl(
    private val memberRepository: MemberRepository,
    private val discountPolicy: DiscountPolicy
): OrderService {

    override fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order {
        val member = memberRepository.findById(memberId) ?: throw IllegalStateException("Member with id=$memberId does not exist")
        val discountPrice = discountPolicy.discount(member, itemPrice)

        return Order(memberId, itemName, itemPrice, discountPrice)
    }

    fun getMemberRepository(): MemberRepository {
        return memberRepository
    }
}