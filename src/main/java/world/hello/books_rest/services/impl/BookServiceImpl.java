package world.hello.books_rest.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import world.hello.books_rest.domain.Book;
import world.hello.books_rest.domain.BookEntity;
import world.hello.books_rest.repositories.BookRepository;
import world.hello.books_rest.services.BookService;
import world.hello.books_rest.services.mappers.BookMapper;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public boolean validate(Book book) {
        return !(book.getAuthor() == null || book.getAuthor().isEmpty()
                || book.getTitle() == null || book.getTitle().isEmpty()
                || book.getIsbn() == null || book.getIsbn().isEmpty());
    }

    @Override
    public boolean create(Book book) {
        return bookRepository.save(
                BookMapper.bookToBookEntity(book));
    }

    @Override
    public List<Book> getAll() {
        List<BookEntity> bookEntities = bookRepository.findAll();
        return bookEntities.stream()
                .map(BookMapper::bookEntityToBook)
                .collect(Collectors.toList());
    }

    @Override
    public Book getById(String isbn) {
        final BookEntity foundBook = bookRepository.findById(isbn);

        return (foundBook == null) ? null : BookMapper.bookEntityToBook(foundBook);
    };

    @Override
    public Book updateById(String isbn, Book book) {
        final BookEntity bookEntity = bookRepository.updateById(isbn, BookMapper.bookToBookEntity(book));
        return (bookEntity == null) ? null : BookMapper.bookEntityToBook(bookEntity);
    }

    @Override
    public boolean deleteById(String isbn) {
        return bookRepository.deleteById(isbn);
    }
}
