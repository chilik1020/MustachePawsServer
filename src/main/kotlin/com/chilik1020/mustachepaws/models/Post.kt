package com.chilik1020.mustachepaws.models

import org.springframework.format.annotation.DateTimeFormat
import java.time.Instant
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "post", schema = "public")
class Post(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        var id: Long = 0,

        @Column(name = "closed")
        var closed: Boolean = false,

        @Column(name = "description")
        var description: String = "",

        @Column(name = "image_link")
        var imageLink: String = "",

        @ManyToOne(optional = false)
        @JoinColumn(name = "creator_id", referencedColumnName = "id")
        var creator: User? = null,

        @DateTimeFormat
        @Column(name = "created_at")
        var createdAt: Date = Date.from(Instant.now())
)