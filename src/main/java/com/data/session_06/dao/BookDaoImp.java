package com.data.session_06.dao;

import com.data.session_06.model.Book;
import com.data.session_06.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImp implements BookDao {

    @Override
    public List<Book> findAll() {
        List<Book> list = new ArrayList<>();
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all_books()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Book b = new Book();
                b.setBookCode(rs.getString("book_code"));
                b.setTitle(rs.getString("title"));
                b.setAuthor(rs.getString("author"));
                b.setGenre(rs.getString("genre"));
                b.setQuantity(rs.getInt("quantity"));
                list.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return list;
    }

    @Override
    public boolean save(Book book) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call insert_book(?,?,?,?,?)}");
            callSt.setString(1, book.getBookCode());
            callSt.setString(2, book.getTitle());
            callSt.setString(3, book.getAuthor());
            callSt.setString(4, book.getGenre());
            callSt.setInt(5, book.getQuantity());
            callSt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return true;
    }

    @Override
    public Book findById(String bookCode) {
        Book book = null;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_book_by_code(?)}");
            callSt.setString(1, bookCode);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                book = new Book();
                book.setBookCode(rs.getString("book_code"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setGenre(rs.getString("genre"));
                book.setQuantity(rs.getInt("quantity"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return book;
    }

    @Override
    public boolean update(Book book) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_book(?,?,?,?,?)}");
            callSt.setString(1, book.getBookCode());
            callSt.setString(2, book.getTitle());
            callSt.setString(3, book.getAuthor());
            callSt.setString(4, book.getGenre());
            callSt.setInt(5, book.getQuantity());
            callSt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return true;
    }

    @Override
    public boolean delete(String bookCode) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_book(?)}");
            callSt.setString(1, bookCode);
            callSt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return true;
    }
}
