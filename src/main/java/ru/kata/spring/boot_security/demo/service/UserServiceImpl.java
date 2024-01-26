package ru.kata.spring.boot_security.demo.service;

//import com.example.SpringBoot1.dao.UserDAO;
//import com.example.SpringBoot1.model.User;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.UserDAO;
import ru.kata.spring.boot_security.demo.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{


    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userDAO.save(user);
    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        userDAO.deleteUser(id);
    }

    @Transactional
    @Override
    public User getUser(long id) {
        return userDAO.getUser(id);
    }
}
