package com.kotlin.book_api.service.impl

import com.kotlin.book_api.BookRepository
import com.kotlin.book_api.dto.BookRequest
import com.kotlin.book_api.dto.BookResponse
import com.kotlin.book_api.model.Book
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

    override fun createBook(book: BookRequest): BookResponse {
        val newBook = Book(
            title = book.title,
            author = book.author,
            year = book.year ?: 0
        )
        bookRepository.save(newBook)
        return BookResponse(status = "success", book = newBook)
    }

    override fun deleteBook(id: Long) {
        bookRepository.deleteById(id)
    }

    override fun updateBook(id: Long, book: BookRequest): BookResponse {
        val book = Book(
            id = id,
            title = book.title,
            author = book.author,
            year = book.year
        )
        bookRepository.save(book)
        return BookResponse(status = "success", book = book)
    }

}