package com.chilik1020.mustachepaws.services

import org.springframework.web.multipart.MultipartFile

interface ImageService {
    fun saveUploadedImage(file: MultipartFile): String?
    fun getImageFromUrl(filename: String): ByteArray
}