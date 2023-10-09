package com.example.envers.controller;

import com.example.envers.config.CustomRevisionEntity;
import com.example.envers.domain.Book;
import com.example.envers.repository.revision.BookRevisionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.history.Revision;
import org.springframework.data.history.RevisionMetadata;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books/history")
@Slf4j
public class BookHistoryController {

    private final BookRevisionRepository bookRevisionRepository;

    @GetMapping("/books-history/{id}")
    public List<Book> getBookRevisions(@PathVariable Long id) {
        return bookRevisionRepository.findRevisions(id)
                .stream()
                .map(Revision::getEntity)
                .toList();
    }

    @GetMapping("/creator/{id}")
    public String getCreator(@PathVariable Long id) {
        Revision<Integer, Book> revision = bookRevisionRepository.findRevision(id, 1).orElseThrow();
        RevisionMetadata<Integer> metadata = revision.getMetadata();
        CustomRevisionEntity auditeEnversInfo = metadata.getDelegate();
        log.info("auditeEnversInfo: {}", auditeEnversInfo);
        return auditeEnversInfo.getUsername();
    }
}
