package com.chilik1020.mustachepaws.services

import org.apache.commons.io.IOUtils
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.FileInputStream
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

@Service
class ImageServiceImpl : ImageService {

    override fun saveUploadedImage(file: MultipartFile): String? {
        val path: Path = Paths.get("/home/chilik1020/uploads/" + file.originalFilename)
        if (!file.isEmpty) {
            val bytes = file.bytes
            Files.write(path, bytes)
            return path.toString()
        }
        return null
    }

    override fun getImageFromUrl(filename: String): ByteArray {
        val inStream = FileInputStream("/home/chilik1020/uploads/$filename")
        return IOUtils.toByteArray(inStream)
    }

}