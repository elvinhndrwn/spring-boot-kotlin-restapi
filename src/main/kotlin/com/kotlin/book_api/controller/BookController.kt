package com.kotlin.book_api.controller

import com.kotlin.book_api.dto.BookResponse
import com.kotlin.book_api.service.BookService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/books")
class BookController(private val bookService: BookService) {

    @GetMapping("/")
    fun getBooks() : ResponseEntity<BookResponse> {
        val response = bookService.getBooks();
        return ResponseEntity.ok(response)
    }

    @GetMapping("/{id}")
    fun geBook(@PathVariable id: Long) : ResponseEntity<BookResponse> {
        val response = bookService.getBook(id)
        return if(response.status == "success") {
            ResponseEntity.ok(response)
        } else {
            ResponseEntity.notFound().build()
        }
    }
}