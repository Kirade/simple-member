package io.github.kirade.simplemember

import io.github.kirade.simplemember.discount.DiscountPolicy
import io.github.kirade.simplemember.discount.RateDiscountPolicy
import io.github.kirade.simplemember.member.MemberRepository
import io.github.kirade.simplemember.member.MemberService
import io.github.kirade.simplemember.member.MemberServiceImpl
import io.github.kirade.simplemember.member.MemoryMemberRepository
import io.github.kirade.simplemember.order.OrderService
import io.github.kirade.simplemember.order.OrderServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


// App 의 설정정보를 의미한다. --> 컨테이너 안에 정의된 빈들이 싱글턴이 될 수 있도록 해준다. ( CGLIB 기술 활용 )
@Configuration
class AppConfig {

    // 스프링 컨테이너에 등록된다
    @Bean
    fun memberRepository(): MemberRepository {
        return MemoryMemberRepository()
    }

    @Bean
    fun discountPolicy(): DiscountPolicy {
        return RateDiscountPolicy()
    }

    @Bean
    fun memberService(): MemberService {
        return MemberServiceImpl(memberRepository())
    }

    @Bean
    fun orderService(): OrderService {
        return OrderServiceImpl(memberRepository(), discountPolicy())
    }

}