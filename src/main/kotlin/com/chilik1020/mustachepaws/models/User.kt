package com.chilik1020.mustachepaws.models

import com.chilik1020.mustachepaws.listeners.UserListener
import org.springframework.format.annotation.DateTimeFormat

import java.time.Instant
import java.util.*
import javax.persistence.*
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@Entity
@Table(name = "users", schema = "public")
@EntityListeners(UserListener::class)
class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,

        @Column(unique = true)
        var username: String = "",

        @Column
        var firstname: String = "",

        @Column
        var lastname: String = "",

        @Column(unique = true)
        var email: String = "",

        @Size(min = 6, max = 15)
        @Column(unique = true)
        var phonenumber: String = "",

        @Column(name = "profile_image")
        var profileImage: String = "",

        @Size(min = 60, max = 60)
        var password: String = "",

        @Pattern(regexp = "\\A(activated|deactivated)\\z")
        @Column(name = "account_status")
        var accountStatus: String = "activated",

        @DateTimeFormat
        @Column(name = "created_at")
        var createdAt: Date = Date.from(Instant.now())
) {
    @OneToMany(mappedBy = "creator", targetEntity = Post::class)
    private var createdPosts: Collection<Post>? = null
}
