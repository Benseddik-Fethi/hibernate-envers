package com.example.envers.controller;

import com.example.envers.domain.Book;
import com.example.envers.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;

    @PostMapping("/create")
    public void createBook(@RequestBody Book book) {
        bookRepository.save(book);
    }

    @PostMapping("/update")
    public void updateBook(@RequestBody Book book) {
        bookRepository.save(book);
    }
}
