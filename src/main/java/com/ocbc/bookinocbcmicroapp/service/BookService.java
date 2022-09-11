package com.ocbc.bookinocbcmicroapp.service;

import com.ocbc.bookinocbcmicroapp.dto.CreateOrUpdateBookDTO;
import com.ocbc.bookinocbcmicroapp.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    void createBook(CreateOrUpdateBookDTO validator);

    List<Book> getAllBooks();

    Page<Book> getAllBooks(Pageable pageable);

    void updateBook(Book book, CreateOrUpdateBookDTO validator);

    Book getById(Long id);

    void deleteById(Long id);
}
