package com.example.demo.services.implementation;

import com.example.demo.models.Author;
import com.example.demo.models.Book;
import com.example.demo.models.BookDto;
import com.example.demo.models.Category;
import com.example.demo.repo.AuthorRepository;
import com.example.demo.repo.BookRepository;
import com.example.demo.services.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }



    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Book book = new Book();
        book.setName(bookDto.getName());

        Author author = authorRepository.findById(bookDto.getAuthor()).orElseThrow();
        book.setAuthor(author);

        //set the category to the book to the enum value of the string
        book.setCategory(Category.valueOf(bookDto.getCategory()));
        book.setQuantity(bookDto.getQuantity());

        return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = bookRepository.findById(id).orElseThrow();
        book.setName(bookDto.getName());

        Author author = authorRepository.findById(bookDto.getAuthor()).orElseThrow();
        book.setAuthor(author);

        book.setCategory(Category.valueOf(bookDto.getCategory()));
        book.setQuantity(bookDto.getQuantity());

        return Optional.of(bookRepository.save(book));

    }

    @Override
    public Integer reserve(Long id) {
        Book book = bookRepository.findById(id).orElseThrow();
        Integer quantity = book.getQuantity();
        if (quantity > 0) {
            book.setQuantity(quantity - 1);
            bookRepository.save(book);
            return quantity - 1;
        }
        return quantity;

    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findByCategory(String category) {
        return bookRepository.findAllByCategory(Category.valueOf(category));
    }
}
