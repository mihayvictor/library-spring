package com.mihayvictor.library_spring.model.dto.request;

public class BookRequest {
    private String title;
    private int pages;
    private Long authorId;

    public BookRequest(){
    }

    public BookRequest(String authorName, String title, int pages, Long authorId) {
        this.title = title;
        this.pages = pages;
        this.authorId = authorId;
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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

}
