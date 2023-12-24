package ru.javamentor.springboot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.javamentor.springboot.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }
    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }
    @Override
    public List<User> getAllUsers() {
        List<User> userList = entityManager.createQuery("from User", User.class).getResultList();
        return userList;
    }
    @Override
    public User readUser(Long id) {
        return entityManager.find(User.class, id);
    }
    @Override
    public User deleteUser(Long id) {
        User user = readUser(id);
        entityManager.remove(user);
        return user;
    }
}