package com.ocbc.bookinocbcmicroapp.repository;

import com.ocbc.bookinocbcmicroapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findOneById(Long id);
}
