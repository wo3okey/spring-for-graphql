package com.wookey.dev.graphql.member

import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller

@Controller
class MemberController(
    val memberService: MemberService
) {
    @SchemaMapping(typeName = "Query", value = "members")
    fun members(): List<Member> = memberService.all()

    @QueryMapping
    fun member(@Argument id: Int) = memberService.find(id)

    @MutationMapping
    fun createMember(@Argument member: MemberRequest) = memberService.createMember(member)
}