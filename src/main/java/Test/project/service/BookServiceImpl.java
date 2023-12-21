package Test.project.service;

import Test.project.model.Author;
import Test.project.model.Book;
import Test.project.repository.AuthorRepository;
import Test.project.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private AuthorRepository aRepository;
    @Autowired
    private BookRepository bRepository;
    @Override
    public List<Book> getBook() {
        return bRepository.findAll();
    }

    @Override
    public Book saveBook(Book book, Long author_id) {
        Author author = this.aRepository.findById(author_id)
                .orElseThrow();
        book.setAuthor(author);
        this.aRepository.save(author);
        return bRepository.save(book);
    }

    @Override
    public Book getSingleBook(Long id) {
            Optional<Book> book = bRepository.findById(id);
            if (book.isPresent()) {
                return book.get();
            }
            throw new RuntimeException("Book is not found for the id" + id);
        }

    @Override
    public Book updateBook(Book book, Long bookId) {
        Book book1 = this.bRepository.findById(bookId)
                .orElseThrow();

        if (book.getTitle() != null) {
            book1.setTitle(book.getTitle());
        }
        if (book.getType() != null) {
            book1.setType(book .getType());
        }
        Book updatedBook = this.bRepository.save(book1);
        return updatedBook;
    }

    @Override
    public void deleteBook(Long id) {
        bRepository.deleteById(id);
    }
}
