package io.github.kirade.simplemember.member

interface MemberRepository {
    fun save(member: Member): Unit
    fun findById(id: Long): Member?
}