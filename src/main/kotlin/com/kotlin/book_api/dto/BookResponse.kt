package com.kotlin.book_api.dto

import com.kotlin.book_api.model.Book

data class BookResponse(
    val status: String,
    val books: List<Book>? = null,
    val book: Book? = null
)
