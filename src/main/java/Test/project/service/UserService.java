package Test.project.service;

import Test.project.model.User;

import java.util.List;

public interface UserService {

    List<User> getUser();

    User saveUser (User user);

    User getSingleUser (Long id);

    User updateUser (User user, Long userId);

    void deleteUser(Long id);
}
