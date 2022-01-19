package crud_boot.springboot.example.service;

import crud_boot.springboot.example.models.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {

    User getUserById(Long id);

    List<User> getAllUsers();

    void saveUser(User user);

    void deleteUser(User user);

    void updateUser(User user);

    User getUserByName(String name);
}
