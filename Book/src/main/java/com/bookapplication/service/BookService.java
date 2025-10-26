package com.bookapplication.service;



import java.util.List;
import java.util.Optional;
import com.bookapplication.model.Book;

public interface BookService {
    Book addBook(Book book);
    Book getBookByTitle(String title);
    Optional<Book> findById(int bookId);
    List<Book> getAllBook();
    Book updateBook(Book book);
    String deleteBook(int id);
}
