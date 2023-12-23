package ru.javamentor.springboot.dao;

import ru.javamentor.springboot.model.User;

import java.util.List;

public interface UserDao {
    void createUser(User user);
    void updateUser(User user);
    List<User> getAllUsers();
    User readUser(Long id);
    User deleteUser(Long id);
}