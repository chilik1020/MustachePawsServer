package com.chilik1020.mustachepaws.helpers.objects

import com.chilik1020.mustachepaws.models.AnimalType
import com.chilik1020.mustachepaws.models.AssistanceType
import com.chilik1020.mustachepaws.models.PostLocation

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

data class PostNewVO(
        val id: Long,
        val closed: Boolean,
        val description: String,
        val imageLink: String,
        val assistType: AssistanceType,
        val animalType: AnimalType,
        val location: PostLocation,
        val creatorUsername: String,
        val createdAt: Long
)

data class PostListVO(
        val posts: List<PostVO>
)

