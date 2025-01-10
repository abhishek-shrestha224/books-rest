package world.hello.books_rest.services;

import java.util.List;

import world.hello.books_rest.domain.Book;

public interface BookService {

    boolean create(Book book);

    boolean validate(Book book);

    List<Book> getAll();

    Book getById(String isbn);

    Book updateById(String isbn, Book book);
}
