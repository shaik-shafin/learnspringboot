package com.shaik.acknowledge.hibernatemappings.onetomany.service;

import com.shaik.acknowledge.hibernatemappings.onetomany.domain.Book;
import com.shaik.acknowledge.hibernatemappings.onetomany.respository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public Book getBook(Integer bookId) {
        return bookRepository.findById(bookId).get();
    }
}
