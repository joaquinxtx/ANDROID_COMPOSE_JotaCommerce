package com.joaquindev.jotacommerce.domain.model

data class AuthResponse(
    val user: User,
    val token:String
)
