package com.chilik1020.mustachepaws.post

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PostService(@Autowired private val postRepository: PostRepository) {

    fun findAll(): MutableList<Post> {
        return postRepository.findAll()
    }

    fun getOne(id: Long): Post {
        return postRepository.getOne(id)
    }

    fun save(post: Post): Post {
        return postRepository.save(post)
    }

    fun deleteById(id: Long) {
        postRepository.deleteById(id)
    }

    fun deleteAll(){
        postRepository.deleteAll()
    }
}