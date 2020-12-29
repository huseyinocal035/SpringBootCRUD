package crud.Service;

import crud.Entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAllBooks(String name);

    Optional<Book> findBook(long id);

    Book createBook(Book book);

    void updateBook(long id, Book book);

    void deleteBook(long id);

    void deleteAllBooks();
}
