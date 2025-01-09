package world.hello.books_rest.services.mappers;

import world.hello.books_rest.domain.Book;
import world.hello.books_rest.domain.BookEntity;

public interface BookMapper {

    public static BookEntity bookToBookEntity(Book book) {
        return BookEntity.builder()
                .isbn(book.getIsbn())
                .author(book.getAuthor())
                .title(book.getTitle())
                .build();
    }

    public static Book bookEntityToBook(BookEntity entity) {
        return Book.builder()
                .isbn(entity.getIsbn())
                .author(entity.getAuthor())
                .title(entity.getTitle())
                .build();
    }
}
