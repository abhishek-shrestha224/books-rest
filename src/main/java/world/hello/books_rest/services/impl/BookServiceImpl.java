package world.hello.books_rest.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import world.hello.books_rest.domain.Book;
import world.hello.books_rest.repositories.BookRepository;
import world.hello.books_rest.services.BookService;
import world.hello.books_rest.services.mappers.BookMapper;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository BookRepository;

    public BookServiceImpl(final BookRepository BookRepository) {
        this.BookRepository = BookRepository;
    }

    @Override
    public boolean create(Book book) {
        return BookRepository.save(
                BookMapper.bookToBookEntity(book));
    }

    @Override
    public boolean validate(Book book) {
        return !(book.getAuthor() == null || book.getAuthor().isEmpty()
                || book.getTitle() == null || book.getTitle().isEmpty()
                || book.getIsbn() == null || book.getIsbn().isEmpty());
    }

    @Override
    public List<Book> getAll() {
        return null;
    }

}
