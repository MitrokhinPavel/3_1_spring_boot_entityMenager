package ru.javamentor.springboot.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.javamentor.springboot.dao.UserDao;
import ru.javamentor.springboot.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void createUser(User user) {
        userDao.createUser(user);
    }
    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
    @Override
    public User readUser(Long id) {
        return userDao.readUser(id);
    }
    @Override
    @Transactional
    public User deleteUser(Long id) {
        User user = userDao.readUser(id);
        if (user != null) {
            userDao.deleteUser(id);
        } else {
            System.out.println("User with id " + id + " does not exist");
        }
        return user;
    }
}