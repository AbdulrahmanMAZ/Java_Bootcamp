package com.abdulrahman.final_Project.Appointments.service;

import com.abdulrahman.final_Project.Appointments.model.Book;
import com.abdulrahman.final_Project.Appointments.repository.BookRepo;
import com.abdulrahman.final_Project.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    final private BookRepo bookRepo;

    public List<Book> getBooks(){
        return bookRepo.findAll();
    }
    public void addBook(Book book){
        bookRepo.save(book);

    }
    public void editBook(Integer id,Book book){
        Book temp = bookRepo.findBookById(id);
        if (temp == null) {
            throw new ApiException("Not found");
        }
        temp.setBookCount(book.getBookCount());
        temp.setName(book.getName());
        temp.setGenre(book.getGenre());
        temp.setStore(book.getStore());
        bookRepo.save(temp);

    }
    public void deleteBook(Integer id){
        Book temp = bookRepo.findBookById(id);
        if (temp == null) {
            throw new ApiException("Not found");
        }
        bookRepo.delete(temp);

    }

    public Integer returnCount(Integer id){
        Book temp = bookRepo.findBookById(id);
        if (temp == null) {
            throw new ApiException("Not found");
        }
        return temp.getBookCount();

    }
    public Book returnBookInfoByName(String name){
        Book temp = bookRepo.findBookByName(name);
        if (temp == null) {
            throw new ApiException("Not found");
        }
        return temp;

    }
    public List<Book> findByGenre(String genre){
        List<Book> books = bookRepo.findAllByGenre(genre);
        if (books.isEmpty()) {
            throw new ApiException("Not found");
        }
        return books;

    }
}
