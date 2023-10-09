package com.example.envers.repository.revision;

import com.example.envers.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;


public interface BookRevisionRepository extends JpaRepository<Book, Long>, RevisionRepository<Book, Long, Integer> {

}