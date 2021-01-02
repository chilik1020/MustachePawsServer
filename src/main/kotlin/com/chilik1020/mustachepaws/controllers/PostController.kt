package com.chilik1020.mustachepaws.controllers

import com.chilik1020.mustachepaws.components.PostAssembler
import com.chilik1020.mustachepaws.helpers.objects.PostNewVO
import com.chilik1020.mustachepaws.models.PostNewRequestObject
import com.chilik1020.mustachepaws.services.PostServiceImpl
import org.apache.commons.io.IOUtils
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.FileInputStream
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/posts")
class PostController(val postService: PostServiceImpl, val postAssembler: PostAssembler) {

    @GetMapping("/all")
    fun getPosts(request: HttpServletRequest): ResponseEntity<List<PostNewVO>> {
        val posts = postService.getAll().map { postAssembler.toPostNewVO(it) }
        return ResponseEntity.ok(posts)
    }

    @GetMapping
    @RequestMapping("/one/{id}")
    fun getPostById(@PathVariable("id") id: Long): ResponseEntity<PostNewVO> {
        val post = postService.getOne(id)
        return ResponseEntity.ok(postAssembler.toPostNewVO(post))
    }

    @GetMapping
    @RequestMapping("/creator/{id}")
    fun getPostByCreatorId(@PathVariable("id") id: Long): ResponseEntity<List<PostNewVO>> {
        val posts = postService.getByCreator(id).map { postAssembler.toPostNewVO(it) }
        return ResponseEntity.ok(posts)
    }

    @PostMapping("/create")
    fun save(@RequestBody post: PostNewRequestObject): ResponseEntity<PostNewVO> {
        val postSaved = postService.saveNP(post)
        return ResponseEntity.ok(postAssembler.toPostNewVO(postSaved))
    }

    @DeleteMapping("/delete/{id}")
    fun deleteById(@PathVariable("id") id: Long) {
        postService.delete(id)
    }

    @GetMapping
    @RequestMapping("/image/{fileName}")
    fun getImageByUrl(@PathVariable("fileName") fileName: String): ResponseEntity<ByteArray> {
        println(fileName)
        val inStream = FileInputStream("/home/chilik1020/uploads/$fileName")
        val media = IOUtils.toByteArray(inStream)
        val headers = HttpHeaders().apply {
            contentType = MediaType.IMAGE_JPEG
        }
        return ResponseEntity(media, headers, HttpStatus.OK)
    }

    @PostMapping("/uploadImage")
    fun uploadImage(
            @RequestParam("image") image: MultipartFile
    ) {
        val imagePath = postService.saveUploadedImage(image)
        println(imagePath)
    }
}