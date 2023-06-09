package com.example.demo.restController;


import com.example.demo.services.CategoriesService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = {"https://front-end-emt.herokuapp.com/", "https://front-end-emt.herokuapp.com/"})
public class CategoriesController {
    private final CategoriesService categoriesService;

    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping
    public List<String> getCategories() {
        return categoriesService.getAllCategories();
    }

}
