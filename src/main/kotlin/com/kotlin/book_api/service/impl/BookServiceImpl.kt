package com.kotlin.book_api.service.impl

import com.kotlin.book_api.BookRepository
import com.kotlin.book_api.dto.BookResponse
import com.kotlin.book_api.model.Book
import com.kotlin.book_api.service.BookService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class BookServiceImpl(
    private val bookRepository: BookRepository) : BookService {
    override fun getBooks(): BookResponse {
        val books = bookRepository.findAll();
        return BookResponse("success", books);
    }

}