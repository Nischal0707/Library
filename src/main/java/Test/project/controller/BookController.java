package Test.project.controller;

import Test.project.model.Author;
import Test.project.model.Book;
import Test.project.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bService;

    @PostMapping("/book/{author_id}")
    public Book saveBook(@RequestBody Book book, @PathVariable Long author_id) {
        return bService.saveBook(book, author_id);
    }

    @GetMapping("/book")
    public List<Book> getBook() {
        return bService.getBook();
    }
    @GetMapping("/book/{author_id}")
    public List<Book> getBookByAuthorId(@PathVariable Long author_id) {
        return bService.getBookByAuthorId(author_id);
    }
    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") Long id) {
        return bService.getSingleBook(id);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        System.out.println("updating the book data for the id" + id);
        return bService.updateBook(book, id);
    }

    @DeleteMapping("/books")
    public void deleteBook(@RequestParam Long id) {
        bService.deleteBook(id);
    }
}
