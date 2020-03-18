package com.chilik1020.mustachepaws.helpers.objects

data class UserVO(
        val id: Long,
        val username: String,
        val firstname: String,
        val lastname: String,
        val email: String,
        val phoneNumber: String,
        val createdAt: String
)

data class PostVO(
        val id: Long,
        val closed: Boolean,
        val description: String,
        val imageLink: String,
        val creatorUsername: String,
        val createdAt: String
)

data class PostListVO(
        val posts: List<PostVO>
)

