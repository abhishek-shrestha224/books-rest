package world.hello.books_rest.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import world.hello.books_rest.domain.BookEntity;

@Repository
public interface BookRepository {

    List<BookEntity> books = new ArrayList<>();

    default boolean save(BookEntity book) {
        return books.add(book);
    }

    default List<BookEntity> findAll() {
        return new ArrayList<>(books); // Return a copy to prevent external modification
    }

}
