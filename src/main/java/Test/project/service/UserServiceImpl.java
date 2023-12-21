package Test.project.service;

import Test.project.model.User;
import Test.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository uRepository;

    @Override
    public List<User> getUser() {
        return uRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return uRepository.save(user);
    }
    @Override
    public User getSingleUser(Long id) {
        Optional<User> user = uRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        throw new RuntimeException("User is not found for the id" + id);
    }
    @Override
    public User updateUser(User user, Long userId) {
        User user1 = this.uRepository.findById(userId)
                .orElseThrow();

        if (user.getFirstname() != null) {
            user1.setFirstname(user.getFirstname());
        }
        if (user.getLastname() != null) {
            user1.setLastname(user.getLastname());
        }
        if (user.getMobilenumber() != null) {
            user1.setMobilenumber(user.getMobilenumber());
        }
        if (user.getEmail() != null) {
            user1.setEmail(user.getEmail());
        }
        User updatedUser = this.uRepository.save(user1);
        return updatedUser;
    }
    @Override
    public void deleteUser(Long id) {
         uRepository.deleteById(id);
    }
}
