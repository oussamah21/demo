package com.example.domain;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "book")
@NamedQuery(name = "getBookById",
        query = " from Book where id= :bookId")
@NamedQuery(name = "getAllBooks",
        query = " from Book ")
public class Book {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;


    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Column(name = "genre", nullable = false)
    private String genre;

    public Book() {}

    public Book( String isbn,
                 String name,
                String genre) {
        this.isbn = isbn;
        this.name = name;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isbn='" + isbn + '\'' +
                ", genre=" + genre +
                '}';
    }
}