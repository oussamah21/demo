package com.example.controller;


import com.example.domain.Book;
import com.example.services.BookService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.reactivex.rxjava3.core.Maybe;
import jakarta.inject.Inject;

@Controller("/test")
public class CircuitBreakerController {

    @Inject
    BookService bookService;
    @Get()
    public String test() {
        return bookService.getString();
    }

}
