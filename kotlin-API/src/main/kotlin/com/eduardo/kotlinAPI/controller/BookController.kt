package com.eduardo.kotlinAPI.controller

import com.eduardo.kotlinAPI.controller.request.BookRequest
import com.eduardo.kotlinAPI.mapper.BookMapper
import com.eduardo.kotlinAPI.repository.BookRepository
import com.eduardo.kotlinAPI.service.BookService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/books")
class BookController(
    private val bookService: BookService
) {

    @GetMapping
    fun retrieveAllBooks() = ResponseEntity.ok(bookService.retrieveAllBooks())

    @PatchMapping("/activate/{id}")
    fun activateBook(@PathVariable id: Int) = bookService.activateBook(id)

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    fun insertBook(@RequestBody request: BookRequest) {
        bookService.insertBook(request)
    }
}