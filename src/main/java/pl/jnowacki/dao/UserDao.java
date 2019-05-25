package pl.jnowacki.dao;

import pl.jnowacki.model.User;

import java.util.Optional;

public interface UserDao {
    Optional<User> getUser(String login);
}
