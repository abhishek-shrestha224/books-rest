package world.hello.books_rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import world.hello.books_rest.domain.BookEntity;

@Repository
public interface BookRespository extends JpaRepository<BookEntity, String> {

}
