package io.github.kirade.simplemember.autowired

import io.github.kirade.simplemember.member.Member
import io.github.kirade.simplemember.member.MemberRepository
import io.github.kirade.simplemember.member.MemberService
import jakarta.annotation.Nullable
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Configuration

class AutoWiredTest {

    @Configuration
    class TestBean {

        @Autowired(required = false)
        fun setNoBean1(noBean1: Member) {
            println("$noBean1")
        }

        //@Autowired
        //fun setNoBean2(@Nullable noBean2: Member) {
        //    println("$noBean2")
        //}
        //
        //@Autowired
        //fun setNoBean3(noBean3: Member?) {}
    }

    @Test
    fun autoWiredOption() {
        AnnotationConfigApplicationContext(TestBean::class.java)
    }
}