package com.shaik.acknowledge.hibernatemappings.onetomany.service;

import com.shaik.acknowledge.hibernatemappings.onetomany.domain.Author;
import com.shaik.acknowledge.hibernatemappings.onetomany.respository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;


    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public void saveAuthor(Author author) {

        authorRepository.save(author);
    }

    public Author getAuthor(Integer authorId) {

        return authorRepository.findById(authorId).get();
    }

    public void deleteAuthor(Integer authorId) {
        authorRepository.deleteById(authorId);
    }
}
