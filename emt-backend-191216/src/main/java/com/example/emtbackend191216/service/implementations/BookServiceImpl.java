package com.example.emtbackend191216.service.implementations;

import com.example.emtbackend191216.model.dto.BookDTO;
import com.example.emtbackend191216.model.entities.Author;
import com.example.emtbackend191216.model.entities.Book;
import com.example.emtbackend191216.model.enumerations.Category;
import com.example.emtbackend191216.model.exceptions.AuthorNotFoundException;
import com.example.emtbackend191216.model.exceptions.BookNotFoundException;
import com.example.emtbackend191216.repository.AuthorRepository;
import com.example.emtbackend191216.repository.BookRepository;
import com.example.emtbackend191216.service.interfaces.BookService;
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
    public Book save(String name, Category category, Long authorId, Integer availableCopies) {
        Author author = this.authorRepository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException(authorId));
        return this.bookRepository.save(new Book(name, category, author, availableCopies));
    }

    @Override
    public Optional<Book> save(BookDTO bookDTO) {
        Author author = this.authorRepository.findById(bookDTO.getAuthorId()).orElseThrow(() -> new AuthorNotFoundException(bookDTO.getAuthorId()));
        Book book = new Book(bookDTO.getName(), bookDTO.getCategory(), author, bookDTO.getAvailableCopies());
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Book edit(Long id, String name, Category category, Long authorId, Integer availableCopies) {
        Book book = this.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        book.setName(name);
        book.setCategory(category);
        Author author = this.authorRepository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException(authorId));
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);
        return this.bookRepository.save(book);
    }

    @Override
    public Optional<Book> edit(Long id, BookDTO bookDTO) {
        Book book = this.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        book.setName(bookDTO.getName());
        book.setCategory(bookDTO.getCategory());
        Author author = this.authorRepository.findById(bookDTO.getAuthorId()).orElseThrow(() -> new AuthorNotFoundException(bookDTO.getAuthorId()));
        book.setAuthor(author);
        book.setAvailableCopies(book.getAvailableCopies());
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long bookId) {
        return this.bookRepository.findById(bookId);
    }

    @Override
    public Book deleteById(Long bookId) {
        Book book = this.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));
        this.bookRepository.delete(book);
        return book;
    }

    @Override
    public Optional<Book> markAsTaken(Long Id) {
        Book book = this.findById(Id).orElseThrow(() -> new BookNotFoundException(Id));
        if (book.getAvailableCopies() == 0) {
            book.setAvailableCopies(0);
        } else {
            book.setAvailableCopies(book.getAvailableCopies() - 1);
        }

        return Optional.of(this.bookRepository.save(book));
    }
}
