package Test.project.service;

import Test.project.model.Author;

import Test.project.model.User;
import Test.project.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository aRepository;

    @Override
    public List<Author> getAuthor() {
        return aRepository.findAll();
    }

    @Override
    public Author saveAuthor(Author author) {
        return aRepository.save(author);
    }
    @Override
    public Author getSingleAuthor(Long id) {
        Optional<Author> author = aRepository.findById(id);
        if (author.isPresent()) {
            return author.get();
        }
        throw new RuntimeException("Author is not found for the id" + id);
    }
    @Override
    public Author updateAuthor(Author author, Long authorId) {
        Author author1 = this.aRepository.findById(authorId)
                .orElseThrow();

        if (author.getName() != null) {
            author1.setName(author.getName());

        }
        Author updatedAuthor = this.aRepository.save(author1);
        return updatedAuthor;
    }
    @Override
    public void deleteAuthor(Long id) {
        aRepository.deleteById(id);
    }
}

