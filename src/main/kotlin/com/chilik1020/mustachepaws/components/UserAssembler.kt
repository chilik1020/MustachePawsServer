package com.chilik1020.mustachepaws.components

import com.chilik1020.mustachepaws.helpers.objects.UserVO
import com.chilik1020.mustachepaws.models.User
import org.springframework.stereotype.Component

@Component
class UserAssembler {

    fun toUserVO(user: User): UserVO {
        return UserVO(user.id,
                user.username,
                user.firstname,
                user.lastname,
                user.email,
                user.phonenumber,
                user.createdAt.toString())
    }

    fun toUserListVO(users: List<User>): List<UserVO> {
        return users.map { toUserVO(it) }
    }
}