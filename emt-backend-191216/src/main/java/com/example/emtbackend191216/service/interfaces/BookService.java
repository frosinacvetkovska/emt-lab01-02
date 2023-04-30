package com.example.emtbackend191216.service.interfaces;

import com.example.emtbackend191216.model.dto.BookDTO;
import com.example.emtbackend191216.model.entities.Book;
import com.example.emtbackend191216.model.enumerations.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book save(String name, Category category, Long authorId, Integer availableCopies);
    Optional<Book> save(BookDTO bookDTO);
    Book edit(Long id, String name, Category category, Long authorId, Integer availableCopies);
    Optional<Book> edit(Long id, BookDTO bookDTO);
    List<Book> findAll();
    Optional<Book> findById(Long bookId);
    Book deleteById(Long bookId);
    Optional<Book> markAsTaken(Long Id);
}