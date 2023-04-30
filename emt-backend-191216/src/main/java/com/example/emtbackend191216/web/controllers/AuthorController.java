package com.example.emtbackend191216.web.controllers;

import com.example.emtbackend191216.model.entities.Author;
import com.example.emtbackend191216.service.interfaces.AuthorService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@CrossOrigin("http://localhost:3000")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping()
    List<Author> findAll(){
        return this.authorService.findAll();
    }
}
