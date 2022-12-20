package com.example.controller;

import com.example.domain.Book;
import com.example.model.Person;
import com.example.services.BookService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import io.micronaut.validation.Validated;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.List;

@Controller("/books/reactive")
@Validated
public class BookReactiveController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookReactiveController.class);

    @Inject
    BookService bookService;

    @Post
    public void add(@Body Book book) {
     bookService.addBook(book);
    }

    @Get("/{id}")
    public Maybe<Book> findById(@PathVariable Long id) {
        return Maybe.just(bookService.findBookById(id));
    }

    @Get(value = "/stream", produces = MediaType.APPLICATION_JSON_STREAM)
    public Flowable<Book> findAllStream() {
        return Flowable.fromIterable(bookService.findAllBooks()).doOnNext(book -> LOGGER.info("Server: {}", book));
    }

}
