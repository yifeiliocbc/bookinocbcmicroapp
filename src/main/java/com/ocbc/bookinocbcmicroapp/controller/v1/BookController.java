package com.ocbc.bookinocbcmicroapp.controller.v1;

import com.ocbc.bookinocbcmicroapp.core.exception.NotFoundException;
import com.ocbc.bookinocbcmicroapp.dto.CreateOrUpdateBookDTO;
import com.ocbc.bookinocbcmicroapp.dto.validators.ScopeLevel;
import com.ocbc.bookinocbcmicroapp.entity.Book;
import com.ocbc.bookinocbcmicroapp.service.BookService;
import com.ocbc.bookinocbcmicroapp.vo.BookVO;
import com.ocbc.bookinocbcmicroapp.vo.CreatedVO;
import com.ocbc.bookinocbcmicroapp.vo.DeletedVO;
import com.ocbc.bookinocbcmicroapp.vo.PagingDozer;
import com.ocbc.bookinocbcmicroapp.vo.UpdatedVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/v1/book")
@Validated
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable(value = "id") @Positive(message = "{id.positive}") Long id) {
        Book book = bookService.getById(id);
        if (book == null) {
            throw new NotFoundException(22);
        }
        return book;
    }

    @GetMapping("/all")
    public List<Book> getBooks() {
        List<Book> books = bookService.getAllBooks();
        return books;
    }

    @GetMapping("")
    public PagingDozer getBooks(@RequestParam(defaultValue = "0") Integer page,
                                @RequestParam(defaultValue = "10") Integer count) {
        Pageable pageable = PageRequest.of(page, count, Sort.by("updateTime").descending());
        Page<Book> books = bookService.getAllBooks(pageable);
        return new PagingDozer<>(books, BookVO.class);
    }

    @ScopeLevel
    @PostMapping("")
    public CreatedVO createBook(@RequestBody @Validated CreateOrUpdateBookDTO validator) {
        bookService.createBook(validator);
        return new CreatedVO(12);
    }


    @ScopeLevel
    @PutMapping("/{id}")
    public UpdatedVO updateBook(@PathVariable("id") @Positive(message = "{id.positive}") Long id,
                                @RequestBody @Validated CreateOrUpdateBookDTO validator) {
        Book book = bookService.getById(id);
        if (book == null) {
            throw new NotFoundException(22);
        }
        bookService.updateBook(book, validator);
        return new UpdatedVO(13);
    }


    @DeleteMapping("/{id}")
    public DeletedVO deleteBook(@PathVariable("id") @Positive(message = "{id.positive}") Long id) {
        Book book = bookService.getById(id);
        if (book == null) {
            throw new NotFoundException(22);
        }
        bookService.deleteById(book.getId());
        return new DeletedVO(14);
    }

}
