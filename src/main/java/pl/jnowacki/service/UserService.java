package pl.jnowacki.service;

import pl.jnowacki.dao.UserDao;
import pl.jnowacki.dao.UserDaoImpl;
import pl.jnowacki.model.User;
import pl.jnowacki.util.PasswordUtil;

import java.util.Optional;

public class UserService {

    private UserDao userDao = new UserDaoImpl();

    public boolean isUserValid(String login, String password) {

        return userDao.getUser(login)
                .map(user -> {
                    boolean doesPasswordMatch = PasswordUtil.checkPassword(password, user.getPassword());
                    return doesPasswordMatch && login.equals(user.getLogin());
                })
                .orElse(false);
    }

    public Optional<User> getUser(String username) {
        return userDao.getUser(username);
    }
}
