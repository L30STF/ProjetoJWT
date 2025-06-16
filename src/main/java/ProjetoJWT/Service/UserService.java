package ProjetoJWT.Service;


import ProjetoJWT.Model.User;
import ProjetoJWT.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository Repository;

    public List<User> findAll() {
        return Repository.findAll();
    }

    public User createUser(User user) {
        return Repository.save(user);
    }

    public User getUserById(String id) {
        return Repository.findById(id).orElseThrow();
    }

    public User updateUser(String username, User user) {
        User oldUser = Repository.findByLogin(username);

        oldUser.setLogin(user.getLogin());
        oldUser.setPassword(user.getPassword());
        return Repository.save(oldUser);
    }

    public User updateUserById(String id, User user) {
        User oldUser = Repository.findById(id).orElseThrow();

        oldUser.setLogin(user.getLogin());
        oldUser.setPassword(user.getPassword());
        return Repository.save(oldUser);
    }

    public User deleteUser(String id) {
        User oldUser = Repository.findById(id).orElseThrow();
        Repository.delete(oldUser);
        return oldUser;
    }
}