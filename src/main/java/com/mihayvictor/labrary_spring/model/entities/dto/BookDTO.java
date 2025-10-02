package com.mihayvictor.labrary_spring.model.entities.dto;

import com.mihayvictor.labrary_spring.model.entities.Author;
import com.mihayvictor.labrary_spring.model.entities.Book;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serial;
import java.io.Serializable;

public class BookDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String title;
    private int pages;
    private Author author;

    public BookDTO() {
    }

    public BookDTO(Book book){
        this.title = book.getTitle();
        this.pages = book.getPages();
        this.author = book.getAuthor() != null ? book.getAuthor() : null;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

}
