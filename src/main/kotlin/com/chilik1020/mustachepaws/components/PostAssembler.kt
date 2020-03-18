package com.chilik1020.mustachepaws.components

import com.chilik1020.mustachepaws.helpers.objects.PostListVO
import com.chilik1020.mustachepaws.helpers.objects.PostVO
import com.chilik1020.mustachepaws.models.Post
import org.springframework.stereotype.Component

@Component
class PostAssembler {

    fun toPostVO(post: Post) : PostVO {
        var username: String = if (post.creator != null) post.creator!!.username else ""
         return PostVO(
                 post.id,
                 post.closed,
                 post.description,
                 post.imageLink,
                 username,
                 post.createdAt.toString()
         )
    }

    fun toPostListVO(posts: List<Post>) : PostListVO {
        val postListVO = posts.map { toPostVO(it) }
        return PostListVO(postListVO)
    }
}