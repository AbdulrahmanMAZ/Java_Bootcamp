package com.abdulrahman.project_5.Book.controller;

import com.abdulrahman.project_5.Book.model.Book;
import com.abdulrahman.project_5.Book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/")
@RequiredArgsConstructor
public class BookController {

    // ServiceInjection
    private final BookService bookService;

    // getter
    @GetMapping("/getbook")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }
    @PostMapping("/addbook")

    public ResponseEntity addBooks( @RequestBody Book book){
                bookService.addBook(book);
                return ResponseEntity.status(200).body("Success");

    }
    @PutMapping("/editbook")
    public ResponseEntity updateBooks(@PathVariable Integer id, @RequestBody Book book){
        bookService.editBook(id,book);
        return ResponseEntity.status(200).body("Updated");

    }
    @DeleteMapping("/deletebook")
    public ResponseEntity updateBooks(@PathVariable Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body("Updated");

    }

    // Create endpoint that takes a book name and return all book information
    @GetMapping("/get_book_info/{name}")
    public ResponseEntity updateBooks(@PathVariable String name){
       Book book = bookService.returnBookInfoByName(name);
        return ResponseEntity.status(200).body(book);

    }
    // Create endpoint that takes bookId and return number of books available
    @GetMapping("/get_book_count/{id}")
    public ResponseEntity getBooksCount(@PathVariable Integer id){
        Integer book_count = bookService.returnCount(id);
        return ResponseEntity.status(200).body(book_count);

    }
    // Create endpoint that return all books under a specific genre
    @GetMapping("/get_book_by_genre/{genre}")
    public ResponseEntity getBooksByGenre(@PathVariable String genre){
        List<Book> books = bookService.findByGenre(genre);
        return ResponseEntity.status(200).body(books);

    }
}
