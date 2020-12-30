package crud.Service;

import crud.Entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAllBooks(String name);

    Optional<Book> findBook(int id);

    Book createBook(Book book);

    void updateBook(int id, Book book);

    void deleteBook(int id);

    void deleteAllBooks();
}
