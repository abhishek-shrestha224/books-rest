package world.hello.books_rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

import world.hello.books_rest.domain.Book;
import world.hello.books_rest.services.BookService;

// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
// @RequestMapping
public class BookController {
    private final BookService bookService;

    public BookController(final BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books")
    public ResponseEntity<Book> createBook(
            // @PathVariable final String isbn,
            @RequestBody final Book book) {
        final Book savedBook = bookService.createBook(book);
        final var res = new ResponseEntity<Book>(savedBook, HttpStatus.CREATED);
        return res;
    }

}
