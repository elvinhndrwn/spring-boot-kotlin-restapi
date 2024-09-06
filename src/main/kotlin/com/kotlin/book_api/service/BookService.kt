package com.kotlin.book_api.service

import com.kotlin.book_api.dto.BookResponse

interface BookService {
    fun getBooks(): BookResponse
    fun getBook(id: Long): BookResponse
}