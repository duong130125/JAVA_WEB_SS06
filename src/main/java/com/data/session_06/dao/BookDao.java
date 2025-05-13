package com.data.session_06.dao;

import com.data.session_06.model.Book;

import java.util.List;

public interface BookDao {
    List<Book> findAll();

    boolean save(Book book);

    Book findById(String bookCode);

    boolean update(Book book);

    boolean delete(String bookCode);
}
