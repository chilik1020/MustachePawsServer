package com.chilik1020.mustachepaws.post

import javax.persistence.*

@Entity
@Table(name = "posts")
class Post(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val id: Long,

        @Column(name = "closed")
        val closed: Boolean,

        @Column(name = "description")
        val description: String,

        @Column(name = "image_link")
        val imageLink: String
)