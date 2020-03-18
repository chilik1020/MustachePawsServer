package com.chilik1020.mustachepaws.constants

enum class ResponseConstants(val value: String) {
    SUCCESS("success"),
    ERROR("error"),
    USERNAME_UNAVAILABLE("USR_0001"),
    EMAIL_UNAVAILABLE("USR_0002"),
    PHONENUMBER_UNAVAILABLE("USR_0003"),
    EMPTY_STATUS("USR_0004"),
    INVALID_USER_ID("USR_0004"),
    ACCOUNT_DEACTIVATED("GLO_001")
}