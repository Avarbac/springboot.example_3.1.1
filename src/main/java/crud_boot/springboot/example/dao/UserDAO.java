package crud_boot.springboot.example.dao;

import crud_boot.springboot.example.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO {

    User getUserById(Long id);

    List<User> getAllUsers();

    void saveUser(User user);

    void deleteUser(Long id);

    void updateUser(User user, Long id);

    User getUserByName(String name);
}