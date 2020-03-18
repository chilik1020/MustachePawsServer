package com.chilik1020.mustachepaws.services

import com.chilik1020.mustachepaws.exceptions.*
import com.chilik1020.mustachepaws.models.User
import com.chilik1020.mustachepaws.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl (val repository: UserRepository): UserService {

    @Throws(UsernameUnavailableException::class, EmailUnavailableException::class, PhoneNumberUnavailableException::class)
    override fun attemptRegistration(userDetails: User): User {
        if (usernameExists(userDetails.username))
            throw UsernameUnavailableException("The username ${userDetails.username} is unavailable.")

        if (emailExists(userDetails.email))
            throw EmailUnavailableException("Email ${userDetails.email} is already exists.")

        if (phoneNumberExists(userDetails.phonenumber))
            throw PhoneNumberUnavailableException("Phone number ${userDetails.phonenumber} is already exists.")

            val user = User()
            user.username = userDetails.username
            user.password = userDetails.password
            user.firstname = userDetails.firstname
            user.lastname = userDetails.lastname
            user.email = userDetails.email
            user.phonenumber = userDetails.phonenumber
            repository.save(user)
            obscurePassword(user)
            return user
    }

    @Throws(UserStatusEmptyException::class)
    fun updateUserStatus(currentUser: User, updateDetails: User): User {
        if (updateDetails.accountStatus.isNotEmpty()) {
            currentUser.accountStatus = updateDetails.accountStatus
            repository.save(currentUser)
            return currentUser
        }
        throw UserStatusEmptyException("A user's status is empty")
    }

    override fun retrieveUserData(username: String): User? {
        val user = repository.findByUsername(username)
        obscurePassword(user)
        return user
    }

    @Throws(InvalidUserIdException::class)
    override fun retrieveUserData(id: Long): User {
        val userOptional = repository.findById(id)
        if (userOptional.isPresent) {
            val user = userOptional.get()
            obscurePassword(user)
            return user
        }
        throw InvalidUserIdException("A user with an id of '$id' does not exist. ")
    }

    override fun usernameExists(username: String): Boolean {
        return repository.findByUsername(username) != null
    }

    override fun emailExists(email: String): Boolean {
        return repository.findByEmail(email) != null
    }

    override fun phoneNumberExists(phoneNumber: String): Boolean {
        return repository.findByPhonenumber(phoneNumber) != null
    }

    private fun obscurePassword(user: User?) {
        user?.password = "xxx xxx xxx"
    }

}