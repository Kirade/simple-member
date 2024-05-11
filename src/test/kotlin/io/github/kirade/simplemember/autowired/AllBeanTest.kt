package io.github.kirade.simplemember.autowired

import io.github.kirade.simplemember.AutoAppConfig
import io.github.kirade.simplemember.discount.DiscountPolicy
import io.github.kirade.simplemember.member.Grade
import io.github.kirade.simplemember.member.Member
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class AllBeanTest {

    class DiscountService(
        private val policyMap: MutableMap<String, DiscountPolicy> = mutableMapOf(),
        private val policyList: MutableList<DiscountPolicy> = mutableListOf()
    ) {
        fun discount(member: Member, price: Int, discountCode: String): Int? {
            val discountPolicy = policyMap[discountCode]
            return discountPolicy?.discount(member, price)
        }

        init {
            println(policyMap)
            println(policyList)
        }
    }

    @Test
    fun findAllBean() {
        val ac = AnnotationConfigApplicationContext(AutoAppConfig::class.java, DiscountService::class.java)

        val discountService = ac.getBean(DiscountService::class.java)
        val member = Member(1L, "userA", Grade.VIP)
        val discountPrice = discountService.discount(member, 10000, "fixDiscountPolicy")

        assertThat(discountPrice).isEqualTo(1000)

        val rateDiscountPrice = discountService.discount(member, 20000, "rateDiscountPolicy")
        assertThat(rateDiscountPrice).isEqualTo(2000)
    }
}