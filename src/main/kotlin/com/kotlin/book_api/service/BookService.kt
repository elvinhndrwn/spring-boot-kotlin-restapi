package com.kotlin.book_api.service

import com.kotlin.book_api.dto.BookRequest
import com.kotlin.book_api.dto.BookResponse

interface BookService {
    fun getBooks(): BookResponse
    fun getBook(id: Long): BookResponse
    fun createBook(book: BookRequest): BookResponse
    fun deleteBook(id: Long)
    fun updateBook(id: Long, book: BookRequest): BookResponse
}