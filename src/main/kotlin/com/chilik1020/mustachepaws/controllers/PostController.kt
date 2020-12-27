package com.chilik1020.mustachepaws.controllers

import com.chilik1020.mustachepaws.components.PostAssembler
import com.chilik1020.mustachepaws.helpers.objects.PostVO
import com.chilik1020.mustachepaws.models.PostRequestObject
import com.chilik1020.mustachepaws.services.PostServiceImpl
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/posts")
class PostController(val postService: PostServiceImpl, val postAssembler: PostAssembler) {

    @GetMapping("/all")
    fun getPosts(request: HttpServletRequest): ResponseEntity<List<PostVO>> {
        val posts = postService.getAll().map { postAssembler.toPostVO(it) }
        return ResponseEntity.ok(posts)
    }

    @GetMapping
    @RequestMapping("/{id}")
    fun getPostById(@PathVariable("id") id: Long): ResponseEntity<PostVO> {
        val post = postService.getOne(id)
        return ResponseEntity.ok(postAssembler.toPostVO(post))
    }

    @PostMapping("/add")
    fun save(@RequestBody post: PostRequestObject): ResponseEntity<PostVO> {
        val postSaved = postService.save(post)
        return ResponseEntity.ok(postAssembler.toPostVO(postSaved))
    }

    @PostMapping("/create")
    fun create(@RequestParam closed: Boolean,
               @RequestParam description: String,
               @RequestParam creatorUsername: String,
               @RequestParam("image") image: MultipartFile): ResponseEntity<PostVO> {
        println(closed)
        println(description)
        println(creatorUsername)
        val imagePath = postService.saveUploadedImage(image)
        println(image)
        val post = PostRequestObject(closed,
                description,
                creatorUsername,
                imagePath!!)
        val postSaved = postService.save(post)
        return ResponseEntity.ok(postAssembler.toPostVO(postSaved))
    }

    @DeleteMapping("/delete/{id}")
    fun deleteById(@PathVariable("id") id: Long) {
        postService.delete(id)
    }
}