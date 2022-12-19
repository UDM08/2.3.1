package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;


    public void saveUser(User user) {
        entityManager.persist(user);
    }


    public void updateUser(long id, User user) {
        entityManager.merge(user);
    }


    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }


    public void removeUserById(long id) {
        entityManager.remove(getUserById(id));

    }


    public List<User> getAllUsers() {

        return entityManager.createQuery("SELECT user FROM User user ", User.class).getResultList();
    }
}


