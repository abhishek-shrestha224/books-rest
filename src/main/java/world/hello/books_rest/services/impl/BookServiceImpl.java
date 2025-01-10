package world.hello.books_rest.services.impl;

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
    public boolean createBook(Book book) {
        return BookRepository.save(
                BookMapper.bookToBookEntity(book));
    }

}
