package com.wookey.dev.graphql

import com.wookey.dev.graphql.member.Member
import com.wookey.dev.graphql.member.MemberController
import com.wookey.dev.graphql.member.MemberRepository
import com.wookey.dev.graphql.member.MemberService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester
import org.springframework.context.annotation.Import
import org.springframework.graphql.test.tester.GraphQlTester

@Import(MemberService::class, MemberRepository::class)
@AutoConfigureGraphQlTester
@GraphQlTest(MemberController::class)
class MemberTest @Autowired constructor(
    val graphQlTester: GraphQlTester
) {
    @Test
    fun membersTest() {
        val document = """
            query {
                members {
                    id
                    name
                    nickName
                }
            }
        """.trimIndent()

        graphQlTester.document(document)
            .execute()
            .path("members")
            .entityList(Member::class.java)
//            .hasSize(3)
//            .hasSizeGreaterThan(2)
//            .hasSizeLessThan(4)
//            .containsExactly(Member())
//            .doesNotContain(Member())
    }

    @Test
    fun memberTest() {
        val document = """
            query {
              member(id: 1) {
                name,
                nickName,
                position {
                  type,
                  details
                }
              }
            }
        """.trimIndent()

        val member = graphQlTester.document(document)
            .execute()
            .path("member")
            .entity(Member::class.java)
            .get()

        assertEquals(member.nickName, "oslo")
    }
}