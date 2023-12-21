package Test.project.service;

import Test.project.model.Author;
import Test.project.model.User;

import java.util.List;

public interface AuthorService {
    List<Author> getAuthor();

    Author saveAuthor (Author author);

    Author getSingleAuthor (Long id);

    Author updateAuthor (Author  author , Long authorId);

    void deleteAuthor (Long id);
}

