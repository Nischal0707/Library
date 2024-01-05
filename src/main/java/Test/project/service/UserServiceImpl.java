package Test.project.service;

import Test.project.dto.UserDto;
import Test.project.model.User;
import Test.project.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository uRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<User> getUser() {
        return uRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
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
        return null;
    }

    @Override

    public UserDto registerNewUser(UserDto userDto) {

        User user = this.modelMapper.map(userDto, User.class);


        user.setPassword(this.passwordEncoder.encode(user.getPassword()));

        User newUser = this.uRepository.save(user);

        return this.modelMapper.map(newUser, UserDto.class);

    }
    public User dtoToUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);
        return user;
    }

    public UserDto userToDto(User user) {
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        return userDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.uRepository.findAll();
        List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public UserDto saveUserDto(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto getSingleUserDto(Long id) {
        User user = this.uRepository.findById(id)
                .orElseThrow();
        UserDto userDto = userToDto(user);
        return userDto;
    }



    @Override
    public UserDto updateUserDto(UserDto userDto, Long userId) {
        User user = uRepository.findById(userId)
                .orElseThrow();
        User updatedUser = uRepository.save(user);

        return userToDto(updatedUser);
    }

    @Override
    public void deleteUserDto(Long id) {

    }

    @Override
    public void deleteUser(Long userId) {
        User user = this.uRepository.findById(userId)
                .orElseThrow();
        this.uRepository.delete(user);
    }
}
