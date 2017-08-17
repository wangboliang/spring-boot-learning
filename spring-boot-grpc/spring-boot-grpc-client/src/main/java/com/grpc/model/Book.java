package com.grpc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Book {
    public enum BookType {COMIC_BOOK, NEWS_PAPER, BOOK};

    private String ISBN;
    private String author;
    private String title;
    private int page;
    private List<String> keyword;
    private BookType bookType;

}
