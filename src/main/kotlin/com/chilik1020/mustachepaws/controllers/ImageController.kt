package com.chilik1020.mustachepaws.controllers

import com.chilik1020.mustachepaws.services.ImageServiceImpl
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/images")
class ImageController(val imageService: ImageServiceImpl) {

    @GetMapping
    @RequestMapping("/{fileName}")
    fun getImageByUrl(@PathVariable("fileName") fileName: String): ResponseEntity<ByteArray> {
        println(fileName)
        val media = imageService.getImageFromUrl(fileName)
        val headers = HttpHeaders().apply {
            contentType = MediaType.IMAGE_JPEG
        }
        return ResponseEntity(media, headers, HttpStatus.OK)
    }

    @PostMapping("/uploadImage")
    fun uploadImage(
            @RequestParam("image") image: MultipartFile
    ) {
        val imagePath = imageService.saveUploadedImage(image)
        println(imagePath)
    }
}