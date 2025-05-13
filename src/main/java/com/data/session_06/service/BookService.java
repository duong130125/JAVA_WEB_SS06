package com.data.session_06.service;

import com.data.session_06.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    boolean save(Book book);

    Book findById(String bookCode);

    boolean update(Book book);

    boolean delete(String bookCode);
}
