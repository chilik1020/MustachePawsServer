package com.chilik1020.mustachepaws.models

import org.springframework.format.annotation.DateTimeFormat
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "newposts", schema = "public")
class PostNew(
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

        @Column(name = "assist_type")
        var assistanceType: String,

        @Column(name = "animal_type")
        var animalType: String,

        @OneToOne(cascade = [CascadeType.ALL])
        @JoinColumn(name = "location_id", referencedColumnName = "id")
        var location: PostLocation,

        @ManyToOne(optional = false)
        @JoinColumn(name = "creator_id", referencedColumnName = "id")
        var creator: User? = null,

        @DateTimeFormat
        @Column(name = "created_at")
        var createdAt: Long = Instant.now().epochSecond
)


@Entity
@Table(name = "locations", schema = "public")
data class PostLocation(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        var id: Long = 0,

        @Column(name = "lat")
        var lat: Double,

        @Column(name = "lon")
        var lon: Double,

        @Column(name = "description")
        var description: String
)

enum class AssistanceType(val value: String) {
    TYPE1("AssistType 1"),
    TYPE2("AssistType 2"),
    TYPE3("AssistType 3"),
    TYPE4("AssistType 4")
}

enum class AnimalType(val value: String) {
    TYPE1("AnimalType 1"),
    TYPE2("AnimalType 2"),
    TYPE3("AnimalType 3"),
    TYPE4("AnimalType 4")
}

object AssistanceTypeConverter {
    @JvmStatic
    fun toAssistType(value: String) =
            when (value) {
                "AssistType 1" -> AssistanceType.TYPE1
                "AssistType 2" -> AssistanceType.TYPE2
                "AssistType 3" -> AssistanceType.TYPE3
                "AssistType 4" -> AssistanceType.TYPE4
                else -> AssistanceType.TYPE1
            }
}

object AnimalTypeConverter {
    @JvmStatic
    fun toAnimalType(value: String) =
            when (value) {
                "AnimalType 1" -> AnimalType.TYPE1
                "AnimalType 2" -> AnimalType.TYPE2
                "AnimalType 3" -> AnimalType.TYPE3
                "AnimalType 4" -> AnimalType.TYPE4
                else -> AnimalType.TYPE1
            }
}