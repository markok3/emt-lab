package com.example.demo.services.implementation;


import com.example.demo.models.Category;
import com.example.demo.services.CategoriesService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriesServiceImplementation implements CategoriesService {


    @Override
    public List<String> getAllCategories() {
        return Arrays.stream(Category.values()).map(Category::toString).collect(Collectors.toList());
    }
}
