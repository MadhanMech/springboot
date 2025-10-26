package com.bookapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookapplication.model.Book;
import com.bookapplication.repository.BookRepository;
@Service

public class OfflineBookService implements BookService {
	  private final BookRepository bookRepository;
      
      
	     @Autowired//when one constructor present autowired not needed
		   public OfflineBookService(BookRepository bookRepository){
			   	this.bookRepository=bookRepository;
		   }
			
	     
	    
	     public Book addBook(Book book) {
				Book save=bookRepository.save(book);
				return save;
				
			}
			public Book getBookByTitle(String title) {
				Book book=bookRepository.findByTitle(title);
				return book;
			}
			public Optional<Book> findById(int bookId) {
			     Optional<Book>book=bookRepository.findById(bookId);
			     return book;
			}
			public List<Book>getAllBook(){
				    List<Book> books=bookRepository.findAll();
				    return books;
			}
			public Book updateBook(Book book) {
				Book save=bookRepository.save(book);
				return save;
				
			}
			public String deleteBook(int id) {
			    try {
			        if (bookRepository.existsById(id)) {
			            bookRepository.deleteById(id);
			            return "Book with ID " + id + " deleted successfully.";
			        } else {
			            return "Book with ID " + id + " not found.";
			        }
			    } catch (Exception e) {
			        return "Failed to delete book with ID " + id + ". Error: " + e.getMessage();
			    }
			}

			
}
