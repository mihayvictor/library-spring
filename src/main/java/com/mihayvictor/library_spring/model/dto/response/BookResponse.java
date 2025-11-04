package com.mihayvictor.library_spring.model.dto.response;

import com.mihayvictor.library_spring.model.entities.Author;
import com.mihayvictor.library_spring.model.entities.Book;

public class BookResponse {


    private String title;
    private int pages;
    private Author author;

    public BookResponse() {
    }

    public BookResponse(Book book){
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
