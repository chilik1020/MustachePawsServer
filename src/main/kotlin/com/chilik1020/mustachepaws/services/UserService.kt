package com.chilik1020.mustachepaws.services

import com.chilik1020.mustachepaws.models.User

interface UserService {

    fun attemptRegistration(userDetails: User): User

    fun retrieveUserData(username: String): User?

    fun retrieveUserData(id: Long): User?

    fun usernameExists(username: String): Boolean

    fun emailExists(email: String): Boolean

    fun phoneNumberExists(phoneNumber: String): Boolean
}