package world.hello.books_rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import world.hello.books_rest.domain.Book;
import world.hello.books_rest.services.BookService;

import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(final BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody final Book book) {
        final Book savedBook = bookService.createBook(book);
        final var res = new ResponseEntity<Book>(savedBook, HttpStatus.CREATED);
        return res;
    }

}
