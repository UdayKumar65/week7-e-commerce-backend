package service;

import java.util.List;

import model.dto.UserDTO;
import model.entity.User;

public interface UserService {

    User registerUser(UserDTO userDTO);

    User getUserById(Long userId);

    List<User> getAllUsers();

    void deleteUser(Long userId);
}