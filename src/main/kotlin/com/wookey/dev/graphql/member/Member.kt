package com.wookey.dev.graphql.member

class Member(
    val id: Int,
    val name: String,
    val nickName: String,
    val team: Team? = null,
    val position: Position? = null
)

class Team(
    val id: Int,
    val name: TeamName,
    val group: Group
)

enum class TeamName {
    VERTICAL_LAB, CONTENTS_LAB, TRADE_LAB
}

enum class Group {
    CEO, CFO, CPO, CRO, CTO
}

class Position(
    val id: Int,
    val type: PositionType,
    val details: PositionDetails?
)

enum class PositionType {
    DEVELOPER, PRODUCT, PEOPLE
}

enum class PositionDetails {
    BACK_END, FRONT_END, MOBILE, RECRUITING
}