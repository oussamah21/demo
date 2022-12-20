package com.example.services;


import com.example.clients.TestClient;
import com.example.domain.Book;
import com.example.model.Person;
import com.example.repositories.BookRepository;
import io.reactivex.rxjava3.core.Maybe;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;


@Singleton
public class BookService {

    @Inject
    private BookRepository bookRepository;

    @Inject
    TestClient testCLient;

    public void addBook (Book book){
        bookRepository.save(book);
    }

    public Book findBookById(Long id){
        return bookRepository.findById(id);
    }

    public List<Book> findAllBooks(){
        return bookRepository.findAllBooks();
    }

    public String getString(){
        return testCLient.getProfile().blockingGet();
    }

}
