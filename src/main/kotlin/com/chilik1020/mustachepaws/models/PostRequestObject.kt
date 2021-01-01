package com.chilik1020.mustachepaws.models

class PostRequestObject(
        val closed: Boolean,
        val description: String,
        val imageLink: String,
        val creatorUsername: String
)

data class PostNewRequestObject(
        val assistType: String,
        val animalType: String,
        val location: PostLocation,
        val description: String,
        var imageLink: String,
        val creatorUsername: String
)