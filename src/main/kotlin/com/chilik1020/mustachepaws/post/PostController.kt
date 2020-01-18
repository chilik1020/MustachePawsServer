package com.chilik1020.mustachepaws.post

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/post")
class PostController(@Autowired private val postService: PostService) {

    @GetMapping("/all")
    fun getPosts(): MutableList<Post> {
        return postService.findAll()
    }

    @GetMapping("/{id}")
    fun getPostById(@PathVariable("id") id: Long): Post {
        return postService.getOne(id)
    }

    @PostMapping("/add")
    fun save(@RequestBody post: Post): Post {
        return postService.save(post)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteById(@PathVariable("id") id: Long) {
        postService.deleteById(id)
    }

    @DeleteMapping("/delete/all")
    fun deleteAll(){
        postService.deleteAll()
    }
}