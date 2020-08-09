package com.cybernerd.finalproject.model

data class LoginResponse(
    val permissions: List<Permission>,
    val token: String,
    val user: User
)