package world.hello.books_rest.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import world.hello.books_rest.domain.BookEntity;

@Repository
public class BookRepository {

    private final List<BookEntity> books = new ArrayList<>();

    public boolean save(BookEntity book) {
        return books.add(book);
    }

    public List<BookEntity> findAll() {
        return new ArrayList<>(books);
    }
}
