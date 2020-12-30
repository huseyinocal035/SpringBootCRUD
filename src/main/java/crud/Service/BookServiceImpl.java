package crud.Service;

import crud.Entity.Book;
import crud.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> findAllBooks(String name) {
        List<Book> bookList = new ArrayList<>();

        if (name == null)
            bookList.addAll(bookRepository.findAll());
        else
            bookList.addAll(bookRepository.findByNameContaining(name));

        return bookList;
    }

    @Override
    public Optional<Book> findBook(int id) {
        return bookRepository.findById(id);
    }

    public Book createBook(Book book) {
        return bookRepository.save(new Book(book.getName(), book.getAuthorName()));
    }

    @Override
    public void updateBook(int id, Book book) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) {
            Book updatedBook = optionalBook.get();
            updatedBook.setName(book.getName());
            updatedBook.setAuthorName(book.getAuthorName());
            bookRepository.save(updatedBook);
        }
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void deleteAllBooks() {
        bookRepository.deleteAll();
    }


}
