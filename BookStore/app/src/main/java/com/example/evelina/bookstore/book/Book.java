package com.example.evelina.bookstore.book;

/**
 * Created by Evelina on 8/30/2016.
 */
public class Book {
    String author;
    String title;
    int pages;
    public Book(String author,String title,int pages){
        this.author=author;
        this.title=title;
        this.pages=pages;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    public String getAuthor() {
        return author;
    }
}
