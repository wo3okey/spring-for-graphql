package com.wookey.dev.graphql.member

import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class MemberService(
    val repository: MemberRepository
) {
    val logger = KotlinLogging.logger {  }

    fun all(): List<Member> {
        return repository.findAll()
    }

    fun find(id: Int): Member {
        return repository.findById(id)
    }

    fun createMember(request: MemberRequest): Member {
        return repository.save(request.toEntity())
    }
}