package com.chilik1020.mustachepaws.repositories

import com.chilik1020.mustachepaws.models.Post
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository: JpaRepository<Post, Long>