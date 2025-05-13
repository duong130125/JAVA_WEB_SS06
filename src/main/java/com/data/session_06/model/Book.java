package com.data.session_06.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
    private String bookCode;
    private String title;
    private String author;
    private String genre;
    private int quantity;
}
