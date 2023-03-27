package com.example.demo.services.implementation;


import com.example.demo.models.Author;
import com.example.demo.repo.AuthorRepository;
import com.example.demo.services.AuthorsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorsServiceImplementation implements AuthorsService {

    private final AuthorRepository authorRepository;

    public AuthorsServiceImplementation(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}
