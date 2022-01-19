package crud_boot.springboot.example.dao;

import crud_boot.springboot.example.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserDAO {

    User getUserById(Long id);

    List<User> getAllUsers();

    void saveUser(User user);

    void deleteUser(User user);

    void updateUser(User user);

    User getUserByName(String name);
}