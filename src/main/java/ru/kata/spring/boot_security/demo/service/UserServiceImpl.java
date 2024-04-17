package ru.kata.spring.boot_security.demo.service;

//import com.example.SpringBoot1.dao.UserDAO;
//import com.example.SpringBoot1.model.User;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.dao.UserDAO;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;
    private final RoleDao roleDao;


    public UserServiceImpl(UserDAO userDAO, PasswordEncoder passwordEncoder, RoleDao roleDao) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
        this.roleDao = roleDao;
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
    public User getUserId(long id) {
        return userDAO.getUser(id);
    }

    @Transactional
    @Override
    public void addUser(List<Role> role, String name, String surname, String password, String email) {
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setPassword(password);
        user.setEmail(email);
        user.setRoles(new HashSet<>(role));

        userDAO.save(user);
    }

    @Override
    @Transactional
    public User findUserByName(String userName) {
        return userDAO.findUserByName(userName);
    }

    @Override
    @Transactional
    public void update(Long id, User user) {
        var userExist = userDAO.getUser(id);
        if (userExist == null) {
            throw new IllegalArgumentException("Пользователь с таким id " + id + " не найден");
        }

        boolean passwordChanged = !user.getPassword().isEmpty();
        if (passwordChanged) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        userDAO.update(user);
    }


//    @Override
//    @Transactional
//    public void update(Long id, User user) {
//        var userExist = userDAO.getUser(id);
//        if (!user.getPassword().isEmpty()) {
//            user.setPassword(passwordEncoder.encode(user.getPassword()));
//        } else {
//            user.setPassword(userExist.getPassword());
//        }
//        userDAO.update(user);
//    }


}

