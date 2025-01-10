package world.hello.books_rest.services;

import world.hello.books_rest.domain.Book;

public interface BookService {

    boolean createBook(Book book);

    boolean validateBook(Book book);
}
