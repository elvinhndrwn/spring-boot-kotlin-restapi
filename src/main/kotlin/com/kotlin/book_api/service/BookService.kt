package com.kotlin.book_api.service

import com.kotlin.book_api.dto.BookResponse
import com.kotlin.book_api.model.Book

interface BookService {
    fun getBooks(): BookResponse
}