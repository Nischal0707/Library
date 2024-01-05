package Test.project.controller;

import Test.project.dto.ApiResponse;
import Test.project.dto.UserDto;
import Test.project.model.User;
import Test.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService uService;

    @GetMapping("/user")
    public List<User> getUser(){
        return uService.getUser();
    }
    @GetMapping("/users/{id}")
    public String getUser (@PathVariable("id")Long id){
        return "Fetching the user details for the id"+id;
    }

    @PostMapping("/addUser")
    public User saveUser (@RequestBody User user){
        return uService.saveUser(user);
    }

    @PutMapping("/users/{id}")
    public  User updateUser (@PathVariable Long id, @RequestBody  User user){
        System.out.println("updating the user data for the id"+id);
        return uService.updateUser(user, id);
    }

    @DeleteMapping("/users")
    public void deleteUser (@RequestParam Long id){
        uService.deleteUser(id);
    }
    @PostMapping("/addUserDto")
    public UserDto addUser (@RequestBody UserDto userDto){
        return uService.registerNewUser(userDto);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(this.uService.getAllUsers());
    }

}

