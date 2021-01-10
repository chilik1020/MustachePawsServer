package com.chilik1020.mustachepaws.components

import com.chilik1020.mustachepaws.constants.ErrorResponse
import com.chilik1020.mustachepaws.constants.ResponseConstants
import com.chilik1020.mustachepaws.exceptions.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class UserControllerAdvice {

    @ExceptionHandler(UsernameUnavailableException::class)
    fun usernameUnavailable(usernameUnavailableException: UsernameUnavailableException): ResponseEntity<ErrorResponse> {
        val res = ErrorResponse(ResponseConstants.USERNAME_UNAVAILABLE.value, usernameUnavailableException.message)
        return ResponseEntity.unprocessableEntity().body(res)
    }

    @ExceptionHandler(EmailUnavailableException::class)
    fun emailUnavailable(emailUnavailableException: EmailUnavailableException): ResponseEntity<ErrorResponse> {
        val res = ErrorResponse(ResponseConstants.EMAIL_UNAVAILABLE.value, emailUnavailableException.message)
        return ResponseEntity.unprocessableEntity().body(res)
    }

    @ExceptionHandler(PhoneNumberUnavailableException::class)
    fun phoneNumberUnavailable(phoneNumberUnavailableException: PhoneNumberUnavailableException): ResponseEntity<ErrorResponse> {
        val res = ErrorResponse(ResponseConstants.PHONENUMBER_UNAVAILABLE.value, phoneNumberUnavailableException.message)
        return ResponseEntity.unprocessableEntity().body(res)
    }

    @ExceptionHandler(InvalidUserIdException::class)
    fun invalidUserId(invalidUserIdException: InvalidUserIdException): ResponseEntity<ErrorResponse> {
        val res = ErrorResponse(ResponseConstants.INVALID_USER_ID.value, invalidUserIdException.message)
        return ResponseEntity.badRequest().body(res)
    }

    @ExceptionHandler(UserStatusEmptyException::class)
    fun statusEmpty(userStatusEmptyException: UserStatusEmptyException): ResponseEntity<ErrorResponse> {
        val res = ErrorResponse(ResponseConstants.EMPTY_STATUS.value, userStatusEmptyException.message)
        return ResponseEntity.unprocessableEntity().body(res)
    }
}