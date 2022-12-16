package web.UserDAO;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional

    public void saveUser(User user) {
        entityManager.persist(user);
    }


    @Transactional
    public void updateUser(long id, User user) {
        entityManager.merge(user);
    }


    @Transactional
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional

    public void removeUserById(long id) {
        entityManager.remove(getUserById(id));

    }

    @Transactional

    public List<User> getAllUsers() {

        return entityManager.createQuery("SELECT user FROM User user ", User.class).getResultList();
    }
}


