package com.example.emtbackend191216.service.interfaces;

import com.example.emtbackend191216.model.entities.Author;

import java.util.List;

public interface AuthorService {
    Author save(String name, String surname, Long countryId);

    Author edit(Long id, String name, String surname, Long countryId);

    List<Author> findAll();
    Author findById(Long authorId);
    Author deleteById(Long authorId);
}