package com.example.demo;

import com.example.demo.models.Author;
import com.example.demo.models.Book;
import com.example.demo.models.Country;
import com.example.demo.repo.AuthorRepository;
import com.example.demo.repo.BookRepository;
import com.example.demo.repo.CountryRepository;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Getter
public class DataGenerator {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CountryRepository countryRepository;

    @PostConstruct
    public void init() {
        TestDataGenerator testDataGenerator = new TestDataGenerator(authorRepository, bookRepository, countryRepository);
        testDataGenerator.generateTestData();
    }
}

