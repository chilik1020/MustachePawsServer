package com.chilik1020.mustachepaws.components

import com.chilik1020.mustachepaws.exceptions.UserDeactivatedException
import com.chilik1020.mustachepaws.models.User
import com.chilik1020.mustachepaws.repositories.UserRepository
import org.springframework.stereotype.Component
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import java.security.Principal
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class AccountValidityInterceptor(val userRepository: UserRepository) : HandlerInterceptorAdapter() {

    @Throws(UserDeactivatedException::class)
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val principal: Principal? = request.userPrincipal

        if (principal != null) {
            val user = userRepository.findByUsername(principal.name) as User

            if (user.accountStatus == "deactivated") {
                throw UserDeactivatedException("The account of this user has benn deactivated.")
            }
        }
        return super.preHandle(request, response, handler)
    }
}