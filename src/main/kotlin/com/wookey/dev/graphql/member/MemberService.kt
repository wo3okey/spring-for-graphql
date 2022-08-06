package com.wookey.dev.graphql.member

import com.wookey.dev.graphql.member.infra.Member
import com.wookey.dev.graphql.member.infra.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberService(
    val repository: MemberRepository
) {
    fun all(): List<Member> {
        return repository.findAll()
    }

    fun find(id: Int): Member {
        return repository.findById(id)
    }
}