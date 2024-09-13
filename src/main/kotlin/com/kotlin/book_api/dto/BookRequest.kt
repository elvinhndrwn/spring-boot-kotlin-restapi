package com.kotlin.book_api.dto

data class BookRequest(
    val title: String,
    val author: String,
    val year: Int? = null
)
