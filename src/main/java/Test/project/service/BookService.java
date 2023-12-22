package Test.project.service;


import Test.project.model.Author;
import Test.project.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getBook();

    Book saveBook (Book book, Long author_id);

    Book getSingleBook (Long id);

   List <Book> getBookByAuthorId (Long author_id);

    Book updateBook (Book book , Long bookId);

    void deleteBook (Long id);
}

