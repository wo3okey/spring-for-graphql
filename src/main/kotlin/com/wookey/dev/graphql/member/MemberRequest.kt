package com.wookey.dev.graphql.member

class MemberRequest(
    val id: Int,
    val name: String,
    val nickName: String
) {
    fun toEntity() = Member(
        id = this.id,
        name = this.name,
        nickName = this.nickName
    )
}