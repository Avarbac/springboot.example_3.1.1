package crud_boot.springboot.example.service;

import crud_boot.springboot.example.models.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {

    User getUserById(Long id);

    List<User> getAllUsers();

    void saveUser(User user);

    void deleteUser(Long id);

    void updateUser(User user, Long id);

    User getUserByName(String name);
}
