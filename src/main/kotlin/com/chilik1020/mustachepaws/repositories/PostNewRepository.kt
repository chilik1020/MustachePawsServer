package com.chilik1020.mustachepaws.repositories

import com.chilik1020.mustachepaws.models.PostNew
import com.chilik1020.mustachepaws.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostNewRepository : JpaRepository<PostNew, Long> {
    fun findByCreator(creator: User): List<PostNew>
}