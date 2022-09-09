package com.ocbc.bookinocbcmicroapp.service;

import com.ocbc.bookinocbcmicroapp.dto.CreateOrUpdateBookDTO;
import com.ocbc.bookinocbcmicroapp.entity.Book;

import java.util.List;

public interface BookService {

    void createBook(CreateOrUpdateBookDTO validator);

    List<Book> getAllBooks();

    void updateBook(Book book, CreateOrUpdateBookDTO validator);

    Book getById(Long id);

    void deleteById(Long id);
}
