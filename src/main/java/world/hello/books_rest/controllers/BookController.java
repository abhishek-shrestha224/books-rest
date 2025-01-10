package world.hello.books_rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import world.hello.books_rest.domain.APIResponse;
import world.hello.books_rest.domain.Book;
import world.hello.books_rest.services.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(final BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping()
    public ResponseEntity<APIResponse<Book>> postMethodName(@RequestBody Book bookData) {
        if (!bookService.validateBook(bookData)) {
            final var res = APIResponse.<Book>builder()
                    .message("Bad Request! Fields Missing :(")
                    .data(null)
                    .build();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
        }

        final boolean created = bookService.createBook(bookData);
        if (!created) {
            final var res = APIResponse.<Book>builder()
                    .message("Something Went Wrong :(")
                    .data(null)
                    .build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

        }

        final var res = APIResponse.<Book>builder()
                .message("Book Created Successfully :)")
                .data(bookData)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

}
