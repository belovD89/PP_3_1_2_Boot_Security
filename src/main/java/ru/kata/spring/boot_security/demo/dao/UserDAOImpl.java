package ru.kata.spring.boot_security.demo.dao;

//import com.example.SpringBoot1.model.User;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import jakarta.persistence.Query;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        Query query = entityManager.createQuery("FROM User", User.class);
        return query.getResultList();
    }


    @Override
    public void save(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(long id) {
        entityManager.createQuery("DELETE FROM User WHERE id = :id").setParameter("id", id).executeUpdate();
    }

    @Override
    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User user) {
        entityManager.persist(entityManager.merge(user));
    }

    @Override
    public User findUserByName(String userName) {
        return entityManager.createQuery("Select u from User u left join fetch u.roles where u.name =:username", User.class)
                .setParameter("username", userName).getSingleResult();
    }

}
