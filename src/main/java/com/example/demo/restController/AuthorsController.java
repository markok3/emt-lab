package com.example.demo.restController;

import com.example.demo.models.Author;
import com.example.demo.services.AuthorsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
public class AuthorsController {
    private final AuthorsService authorsService;

    public AuthorsController(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }

    @GetMapping
    public List<Author> getAuthors() {
        return authorsService.getAllAuthors();
    }
}
