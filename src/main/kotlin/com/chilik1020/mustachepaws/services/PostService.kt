package com.chilik1020.mustachepaws.services

import com.chilik1020.mustachepaws.models.Post
import com.chilik1020.mustachepaws.models.PostRequestObject
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths


interface PostService {

    fun getAll(): MutableList<Post>

    fun getOne(id: Long): Post

    fun save(postRO: PostRequestObject): Post

    fun saveUploadedImage(file: MultipartFile): String?

    fun delete(id: Long)
}