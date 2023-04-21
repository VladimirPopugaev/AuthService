package com.popugaevvn.authservice.repository.user;

import com.popugaevvn.authservice.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class InMemoryUserRepository implements UserRepository {

    private final List<User> users = Stream.of(
            new User(1, "login1", "Test name 1"),
            new User(2, "login2", "Test name 2"),
            new User(3, "login3", "Test name 3")
    ).toList();

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User getUserById(int id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

}
