package com.chilik1020.mustachepaws.repositories

import com.chilik1020.mustachepaws.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long> {
    fun findByUsername(username: String): User?
    fun findByEmail(email: String): User?
    fun findByPhonenumber(phonenumber: String): User?
}