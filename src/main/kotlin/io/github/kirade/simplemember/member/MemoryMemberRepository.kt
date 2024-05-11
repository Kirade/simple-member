package io.github.kirade.simplemember.member

class MemoryMemberRepository: MemberRepository {

    companion object {
        private val store = mutableMapOf<Long, Member>()
    }

    override fun save(member: Member) {
        store[member.id] = member
    }

    override fun findById(id: Long): Member? {
        return store[id]
    }
}