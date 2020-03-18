package com.chilik1020.mustachepaws.exceptions

import java.lang.RuntimeException

class UsernameUnavailableException(override val message: String) : RuntimeException()
class EmailUnavailableException(override val message: String) : RuntimeException()
class PhoneNumberUnavailableException(override val message: String) : RuntimeException()
class InvalidUserIdException(override val message: String) : RuntimeException()

class UserDeactivatedException(override val message: String) : RuntimeException()
class UserStatusEmptyException(override val message: String): RuntimeException()