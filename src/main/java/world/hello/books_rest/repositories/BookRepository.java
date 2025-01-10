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

    public BookEntity findById(String isbn) {
        return books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    public BookEntity updateById(String id, BookEntity bookData) {
        for (int i = 0; i < books.size(); i++) {
            BookEntity book = books.get(i);
            if (book.getIsbn().equals(id)) {
                books.set(i, bookData);
                return bookData;
            }
        }
        return null;
    }

    public boolean deleteById(String isbn) {
        return books.removeIf(book -> book.getIsbn().equals(isbn));
    }

}
