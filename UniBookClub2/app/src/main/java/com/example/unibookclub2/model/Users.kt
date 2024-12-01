package com.example.unibookclub2.model

data class Users(
    val name: String,
    val location: String,
    val email: String,
    val password: String,
    val passwordConfirm: String
)