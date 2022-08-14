package com.wookey.dev.graphql.member

import org.springframework.stereotype.Repository

@Repository
class MemberRepository {
    var members = mutableListOf(
        Member(
            id = 0,
            name = "안형욱",
            nickName = "wookey",
            team = Team(0, TeamName.VERTICAL_LAB, Group.CTO),
            position = Position(0, PositionType.DEVELOPER, PositionDetails.BACK_END)
        ),
        Member(
            id = 1,
            name = "노국현",
            nickName = "oslo",
            team = Team(0, TeamName.VERTICAL_LAB, Group.CTO),
            position = Position(0, PositionType.DEVELOPER, PositionDetails.FRONT_END)
        ),
        Member(
            id = 2,
            name = "박상민",
            nickName = "dylan",
            team = Team(0, TeamName.VERTICAL_LAB, Group.CTO),
            position = Position(0, PositionType.DEVELOPER, PositionDetails.FRONT_END)
        ),
        Member(
            id = 2,
            name = "박성호",
            nickName = "steve",
            team = Team(0, TeamName.VERTICAL_LAB, Group.CTO),
            position = Position(0, PositionType.DEVELOPER, PositionDetails.MOBILE)
        ),
        Member(
            id = 4,
            name = "윤소리",
            nickName = "mia",
            team = Team(0, TeamName.VERTICAL_LAB, Group.CTO),
            position = Position(0, PositionType.PRODUCT, null)
        ),
        Member(
            id = 5,
            name = "박소원",
            nickName = "summer",
            team = Team(0, TeamName.VERTICAL_LAB, Group.CTO),
            position = Position(0, PositionType.PEOPLE, PositionDetails.RECRUITING)
        ),
    )

    fun findAll() = members

    fun findById(id: Int) = members.first { it.id == id }

    // @Transactional
    fun save(member: Member): Member {
        members.add(member)

        return member
    }
}