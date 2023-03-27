package com.example.demo.services;

import com.example.demo.models.Book;
import com.example.demo.models.BookDto;
import com.example.demo.models.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {

//    List<Product> findAll();
//
//    Optional<Product> findById(Long id);
//
//    Optional<Product> findByName(String name);
//
//    Optional<Product> save(String name, Double price, Integer quantity, Long category, Long manufacturer);
//
//    Optional<Product> save(ProductDto productDto);
//
//    Optional<Product> edit(Long id, String name, Double price, Integer quantity, Long category, Long manufacturer);
//
//    Optional<Product> edit(Long id, ProductDto productDto);
//
//    void deleteById(Long id);
//
//    void refreshMaterializedView();

    List<Book> findAll();
    Optional<Book> findById(Long id);
    Optional<Book> findByName(String name);
    Optional<Book> save(BookDto bookDto);
    Optional<Book> edit(Long id, BookDto bookDto);
    void deleteById(Long id);
    Integer reserve(Long id);
    List<Book> findByCategory(String category);


}
