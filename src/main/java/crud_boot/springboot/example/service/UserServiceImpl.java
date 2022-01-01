package crud_boot.springboot.example.service;

import crud_boot.springboot.example.dao.UserDAO;
import crud_boot.springboot.example.models.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }
    @Override
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }
    @Override
    public void updateUser(User user, Long id) {
        userDAO.updateUser(user,id);
    }

    @Override
    public User getUserByName(String name) {
        return userDAO.getUserByName(name);
    }

}
