package com.example.repositories;


import com.example.domain.Book;
import io.micronaut.transaction.annotation.TransactionalAdvice;
import jakarta.inject.Singleton;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Singleton

public class BookRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public BookRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @TransactionalAdvice
    public void save(Book book) {
         entityManager.persist(book);
    }

    @TransactionalAdvice
    public Book findById(Long bookId){
        TypedQuery<Book> bookQuery = entityManager
                .createNamedQuery("getBookById", Book.class)
                .setParameter("bookId", bookId);
        return bookQuery.getSingleResult();
    }

    @TransactionalAdvice
    public List<Book> findAllBooks(){
        TypedQuery<Book> bookQuery = entityManager
                .createNamedQuery("getAllBooks", Book.class);
        return bookQuery.getResultList();
    }

}
