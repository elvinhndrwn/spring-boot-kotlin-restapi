package com.kotlin.book_api.service.impl

import com.kotlin.book_api.BookRepository
import com.kotlin.book_api.dto.BookResponse
import com.kotlin.book_api.service.BookService
import org.springframework.stereotype.Service

@Service
class BookServiceImpl(
    private val bookRepository: BookRepository) : BookService {
    override fun getBooks(): BookResponse {
        val books = bookRepository.findAll();
        return BookResponse(status = "success", books = books);
    }

    override fun getBook(id: Long): BookResponse {
        val book = bookRepository.findById(id).orElse(null)
        return BookResponse(
            status = if (book != null) "success" else "failed",
            book = book
        )
    }

}