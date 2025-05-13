package com.data.session_06.service;

import com.data.session_06.dao.BookDao;
import com.data.session_06.dao.BookDaoImp;
import com.data.session_06.model.Book;

import java.util.List;

public class BookServiceImp implements BookService {
    private final BookDao bookDao;

    public BookServiceImp() {
        bookDao = new BookDaoImp();
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public boolean save(Book book) {
        return bookDao.save(book);
    }

    @Override
    public Book findById(String bookCode) {
        return bookDao.findById(bookCode);
    }

    @Override
    public boolean update(Book book) {
        return bookDao.update(book);
    }

    @Override
    public boolean delete(String bookCode) {
        return bookDao.delete(bookCode);
    }
}
