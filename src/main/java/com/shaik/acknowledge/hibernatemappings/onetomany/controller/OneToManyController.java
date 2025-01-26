package com.shaik.acknowledge.hibernatemappings.onetomany.controller;

import com.shaik.acknowledge.hibernatemappings.onetomany.domain.Author;
import com.shaik.acknowledge.hibernatemappings.onetomany.domain.Book;
import com.shaik.acknowledge.hibernatemappings.onetomany.service.AuthorService;
import com.shaik.acknowledge.hibernatemappings.onetomany.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hibernate-mapping/one-to-many")
public class OneToManyController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @GetMapping("all-authors-uni")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @PostMapping("save-author-uni")
    public String saveAuthor(@RequestBody Author author) {
        authorService.saveAuthor(author);
        return "Author saved successfully";
    }

    @PutMapping("update-author-uni")
    public String updateAuthor(@RequestBody Author author) {
        authorService.saveAuthor(author);
        return "Author updated successfully";
    }

    @GetMapping("get-author-uni/{authorId}")
    public Author getAuthor(@PathVariable Integer authorId) {
        return authorService.getAuthor(authorId);
    }

    @DeleteMapping("delete-author-uni/{authorId}")
    public String deleteAuthor(@PathVariable Integer authorId) {
        authorService.deleteAuthor(authorId);
        return "Author deleted successfully";
    }

    @GetMapping("all-books-bi")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("get-book-bi/{bookId}")
    public Book getBook(@PathVariable Integer bookId) {
        return bookService.getBook(bookId);
    }
}
