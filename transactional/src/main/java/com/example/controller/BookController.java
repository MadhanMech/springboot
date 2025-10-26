package com.bookapplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookapplication.model.Book;
import com.bookapplication.service.BookService;


@RestController
@RequestMapping("/api/v1/book")
public class BookController {
//
//	@Autowired
//	@Qualifier("onlineBookService")
	BookService bookService ;
	
	public BookController( @Qualifier("onlineBookService")BookService bookService) {
		this.bookService=bookService;
	}

	@PostMapping("/add")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		System.out.println("ebterd");

		Book addBook = bookService.addBook(book);
		return ResponseEntity.status(HttpStatus.CREATED).body(addBook);

	}

	@GetMapping("/all")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> books = bookService.getAllBook();
		return ResponseEntity.status(HttpStatus.OK).body(books);
	}

	@GetMapping("/get/id/{id}")
	public ResponseEntity<?> getBookById(@PathVariable("id") int bookId) {
		Optional<Book> book = bookService.findById(bookId);

		return ResponseEntity.status(HttpStatus.OK).body(book);
	}

	@GetMapping("/get/{title}")
	public ResponseEntity<?> getBookById(@PathVariable("title") String title) {
		Book book = bookService.getBookByTitle(title);

		return ResponseEntity.status(HttpStatus.OK).body(book);
	}
	@PutMapping("/update")
	public ResponseEntity<Book> updateBook(@RequestBody Book book) {
		System.out.println("ebterd");

		Book addBook = bookService.updateBook(book);
		return ResponseEntity.status(HttpStatus.OK).body(addBook);

	}
	@DeleteMapping("/delete/{id}")

	public ResponseEntity<?> deleteBookById(@PathVariable("id") int bookId) {
			String book = bookService.deleteBook(bookId);

		return ResponseEntity.status(HttpStatus.OK).body(book);
	}
	

}
