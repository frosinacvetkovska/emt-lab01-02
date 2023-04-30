package com.example.emtbackend191216.web.controllers;

import com.example.emtbackend191216.model.enumerations.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin("http://localhost:3000")
public class CategoryController {


    @GetMapping()
    List<Category> findAll(){
        return Arrays.stream(Category.values()).collect(Collectors.toList());
    }
}