package com.chilik1020.mustachepaws.services

import com.chilik1020.mustachepaws.models.*
import com.chilik1020.mustachepaws.repositories.PostNewRepository
import com.chilik1020.mustachepaws.repositories.PostRepository
import com.chilik1020.mustachepaws.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.time.Instant
import java.util.*

@Service
class PostServiceImpl(
        @Autowired private val postRepository: PostRepository,
        @Autowired private val postNewRepository: PostNewRepository,
        @Autowired private val userRepository: UserRepository
) : PostService {

    override fun getAll(): MutableList<PostNew> {
        return postNewRepository.findAll()
    }

    override fun getOne(id: Long): Post {
        return postRepository.getOne(id)
    }

    override fun save(postRO: PostRequestObject): Post {
        val user = userRepository.findByUsername(postRO.creatorUsername)
        val post = Post(
                0,
                postRO.closed,
                postRO.description,
                postRO.imageLink,
                user,
                Date()
        )
        return postRepository.save(post)
    }

    override fun saveNP(postRO: PostNewRequestObject): PostNew {
        print("POSTSERVICEIMPL $postRO")
        val user = userRepository.findByUsername(postRO.creatorUsername)
        val post = PostNew(
                0,
                closed = false,
                description = postRO.description,
                imageLink = postRO.imageLink,
                assistanceType = AssistanceTypeConverter.toAssistType(postRO.assistType),
                animalType = AnimalTypeConverter.toAnimalType(postRO.animalType),
                location = postRO.location,
                creator = user,
                createdAt = Instant.now().epochSecond
        )
        return postNewRepository.save(post)
    }

    override fun saveUploadedImage(file: MultipartFile): String? {
        val path: Path = Paths.get("/home/chilik1020/uploads/" + file.originalFilename)
        if (!file.isEmpty) {
            val bytes = file.bytes
            Files.write(path, bytes)
            return path.toString()
        }
        return null
    }

    override fun delete(id: Long) {
        postRepository.deleteById(id)
    }
}