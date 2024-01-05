package Test.project.service;

import Test.project.dto.UserDto;
import Test.project.model.User;

import java.util.List;

public interface UserService {

    List<User> getUser();

    User saveUser(User user);

    User getSingleUser(Long id);

    User updateUser(User user, Long userId);

    UserDto registerNewUser(UserDto userDto);

    void deleteUser(Long id);


    List<UserDto> getAllUsers();

    UserDto saveUserDto (UserDto userDto);

    UserDto getSingleUserDto (Long id);

    UserDto updateUserDto (UserDto userDto, Long userId);

    void deleteUserDto(Long id);

}