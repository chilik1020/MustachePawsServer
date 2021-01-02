package com.chilik1020.mustachepaws.services

import com.chilik1020.mustachepaws.models.Post
import com.chilik1020.mustachepaws.models.PostNew
import com.chilik1020.mustachepaws.models.PostNewRequestObject
import com.chilik1020.mustachepaws.models.PostRequestObject
import org.springframework.web.multipart.MultipartFile


interface PostService {

    fun getAll(): MutableList<PostNew>
    fun getOne(id: Long): PostNew
    fun getByCreator(id: Long): List<PostNew>

    fun save(postRO: PostRequestObject): Post
    fun saveNP(postRO: PostNewRequestObject): PostNew

    fun saveUploadedImage(file: MultipartFile): String?

    fun delete(id: Long)
}