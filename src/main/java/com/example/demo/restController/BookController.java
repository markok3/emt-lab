package com.example.demo.restController;

import com.example.demo.models.Book;
import com.example.demo.models.BookDto;
import com.example.demo.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping(value = {"/", "/books",})

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    private List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return this.bookService.findById(id)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
    @GetMapping("books/category/{category}")
    public List<Book> findByCategory(@PathVariable String category) {
        return this.bookService.findByCategory(category);
    }


    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestBody BookDto bookDto) {
        return bookService.save(bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> save(@PathVariable Long id, @RequestBody BookDto bookDto) {
        return bookService.edit(id, bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
        if(bookService.findById(id).isEmpty())
            return ResponseEntity.ok().build();

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/reserve/{id}")
    public ResponseEntity reserve(@PathVariable Long id) {
        Integer result = bookService.reserve(id);
        if(result >= 0)
            return ResponseEntity.ok().build();

        return ResponseEntity.badRequest().build();
    }


}
