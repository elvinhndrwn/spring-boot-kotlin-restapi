package com.kotlin.book_api.controller

import com.kotlin.book_api.dto.BookRequest
import com.kotlin.book_api.dto.BookResponse
import com.kotlin.book_api.service.BookService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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

    @PostMapping("/")
    fun createBook(@RequestBody book: BookRequest) : ResponseEntity<BookResponse> {
        val data = bookService.createBook(book)
        return ResponseEntity(data, HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun deleteBook(@PathVariable id: Long) : ResponseEntity<String> {
        var book = bookService.getBook(id)
        if(book.status == "success") {
            bookService.deleteBook(id)
            return ResponseEntity.ok("success")
        }else{
            return ResponseEntity.notFound().build()
        }
    }

    @PutMapping("/{id}")
    fun updateBook(@PathVariable id: Long, @RequestBody book: BookRequest) : ResponseEntity<BookResponse> {
        val bookExist = bookService.getBook(id)
        if(bookExist.status == "failed"){
            return ResponseEntity.notFound().build()
        }else{
            val updatedBook = bookService.updateBook(id, book)
            return ResponseEntity.ok(updatedBook)
        }
    }
}