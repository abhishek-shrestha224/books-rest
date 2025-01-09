package world.hello.books_rest.services.impl;

import org.springframework.stereotype.Service;
import world.hello.books_rest.domain.Book;
import world.hello.books_rest.repositories.BookRespository;
import world.hello.books_rest.services.BookService;
import world.hello.books_rest.services.mappers.BookMapper;

@Service
public class BookServiceImpl implements BookService {
    private final BookRespository bookRespository;

    public BookServiceImpl(final BookRespository bookRespository) {
        this.bookRespository = bookRespository;
    }

    @Override
    public Book createBook(Book book) {
        return BookMapper.bookEntityToBook(
                bookRespository.save(
                        BookMapper.bookToBookEntity(book)));
    }

}
