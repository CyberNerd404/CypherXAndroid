package com.cybernerd.finalproject.model

data class DetailX(
    val conversation_slug: String,
    val id: Int,
    val is_active: Boolean,
    val message: String,
    val `receiver`: Receiver,
    val sender: Sender
)