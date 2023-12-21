package Test.project.controller;


import Test.project.model.Author;
import Test.project.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService  aService;

    @GetMapping("/author")
    public List<Author> getAuthor(){
        return aService.getAuthor();
    }

    @GetMapping("/authors/{id}")
    public Author getAuthor (@PathVariable("id")Long id){
        return aService.getSingleAuthor(id);
    }

    @PostMapping("/author")
    public Author saveAuthor (@RequestBody Author author){
        return aService.saveAuthor(author);
    }

    @PutMapping("/authors/{id}")
    public  Author updateAuthor (@PathVariable Long id, @RequestBody  Author author){
        System.out.println("updating the author data for the id"+id);
        return aService.updateAuthor(author, id);
    }

    @DeleteMapping("/authors")
    public void deleteAuthor (@RequestParam Long id){
        aService.deleteAuthor(id);

    }

}

