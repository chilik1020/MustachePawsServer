package com.chilik1020.mustachepaws.repositories

import com.chilik1020.mustachepaws.models.PostLocation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LocationRepository : JpaRepository<PostLocation, Long>