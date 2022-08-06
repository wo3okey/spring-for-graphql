package com.wookey.dev.graphql.member

import com.wookey.dev.graphql.member.infra.Member
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller

@Controller
class MemberController(
    val memberService: MemberService
) {
    @SchemaMapping(typeName = "Query", value = "members")
    fun members(): List<Member> {
        return memberService.all()
    }

    @QueryMapping
    fun member(@Argument id: Int): Member {
        return memberService.find(id)
    }
}