package com.data.session_06.controller;

import com.data.session_06.model.Book;
import com.data.session_06.service.BookService;
import com.data.session_06.service.BookServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookController ", value = "/books ")
public class BookController extends HttpServlet {
    private final BookService bookService;

    public BookController() {
        bookService = new BookServiceImp();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "add":
                request.getRequestDispatcher("formAdd.jsp").forward(request, response);
                break;
            case "edit":
                String code = request.getParameter("bookCode");
                Book b = bookService.findById(code);
                request.setAttribute("book", b);
                request.getRequestDispatcher("formEdit.jsp").forward(request, response);
                break;
            default:
                List<Book> list = bookService.findAll();
                request.setAttribute("books", list);
                request.getRequestDispatcher("listBook.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "create":
                Book newBook = new Book();
                newBook.setBookCode(request.getParameter("bookCode"));
                newBook.setTitle(request.getParameter("title"));
                newBook.setAuthor(request.getParameter("author"));
                newBook.setGenre(request.getParameter("genre"));
                newBook.setQuantity(Integer.parseInt(request.getParameter("quantity")));
                bookService.save(newBook);
                response.sendRedirect("books");
                break;
            case "update":
                Book editBook = new Book();
                editBook.setBookCode(request.getParameter("bookCode"));
                editBook.setTitle(request.getParameter("title"));
                editBook.setAuthor(request.getParameter("author"));
                editBook.setGenre(request.getParameter("genre"));
                editBook.setQuantity(Integer.parseInt(request.getParameter("quantity")));
                bookService.update(editBook);
                response.sendRedirect("books");
                break;
            case "delete":
                String code = request.getParameter("bookCode");
                bookService.delete(code);
                response.sendRedirect("books");
                break;
        }
    }
}