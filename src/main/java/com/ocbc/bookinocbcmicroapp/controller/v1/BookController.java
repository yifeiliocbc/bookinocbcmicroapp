package com.ocbc.bookinocbcmicroapp.controller.v1;

import com.ocbc.bookinocbcmicroapp.core.exception.NotFoundException;
import com.ocbc.bookinocbcmicroapp.dto.CreateOrUpdateBookDTO;
import com.ocbc.bookinocbcmicroapp.entity.Book;
import com.ocbc.bookinocbcmicroapp.service.BookService;
import com.ocbc.bookinocbcmicroapp.vo.CreatedVO;
import com.ocbc.bookinocbcmicroapp.vo.DeletedVO;
import com.ocbc.bookinocbcmicroapp.vo.UpdatedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

/**
 * @author pedro@TaleLin
 */
@RestController
@RequestMapping("/v1/book")
@Validated
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public Book getBook(@PathVariable(value = "id") @Positive(message = "{id.positive}") Long id) {
        Book book = bookService.getById(id);
        if (book == null) {
            throw new NotFoundException("book not found", 10022);
        }
        return book;
    }

    @GetMapping("")
    public List<Book> getBooks() {
        List<Book> books = bookService.getAllBooks();
        return books;
    }


    @GetMapping("/search")
    public List<Book> searchBook() {
        List<Book> books = bookService.getAllBooks();
        return books;
    }


    @PostMapping("")
    public CreatedVO createBook(@RequestBody @Validated CreateOrUpdateBookDTO validator) {
        bookService.createBook(validator);
        return new CreatedVO(12);
    }


    @PutMapping("/{id}")
    public UpdatedVO updateBook(@PathVariable("id") @Positive(message = "{id.positive}") Long id, @RequestBody @Validated CreateOrUpdateBookDTO validator) {
        Book book = bookService.getById(id);
        if (book == null) {
            throw new NotFoundException("book not found", 10022);
        }
        bookService.updateBook(book, validator);
        return new UpdatedVO(13);
    }


    @DeleteMapping("/{id}")
    public DeletedVO deleteBook(@PathVariable("id") @Positive(message = "{id.positive}") Long id) {
        Book book = bookService.getById(id);
        if (book == null) {
            throw new NotFoundException("book not found", 10022);
        }
        bookService.deleteById(book.getId());
        return new DeletedVO(14);
    }

}
