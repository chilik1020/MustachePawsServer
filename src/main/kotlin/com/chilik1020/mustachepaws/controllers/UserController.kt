package com.chilik1020.mustachepaws.controllers

import com.chilik1020.mustachepaws.components.UserAssembler
import com.chilik1020.mustachepaws.helpers.objects.UserVO
import com.chilik1020.mustachepaws.models.User
import com.chilik1020.mustachepaws.repositories.UserRepository
import com.chilik1020.mustachepaws.services.UserServiceImpl
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController (val userService: UserServiceImpl, val userAssembler: UserAssembler, val userRepository: UserRepository) {

    @PostMapping
    @RequestMapping("/registration")
    fun create(@Validated @RequestBody userDetails: User): ResponseEntity<UserVO> {
        val user = userService.attemptRegistration(userDetails)
        return ResponseEntity.ok(userAssembler.toUserVO(user))
    }

    @GetMapping
    @RequestMapping("/{user_id}")
    fun show(@PathVariable("user_id") userId: Long) : ResponseEntity<UserVO> {
        val user = userService.retrieveUserData(userId)
        return ResponseEntity.ok(userAssembler.toUserVO(user))
    }

}