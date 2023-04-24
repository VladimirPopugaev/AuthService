package com.popugaevvn.authservice.repository.user;

import com.popugaevvn.authservice.models.Role;
import com.popugaevvn.authservice.models.User;

import java.util.List;
import java.util.stream.Stream;

public abstract class InMemoryUserRepository implements UserRepository {

    private final List<User> users = Stream.of(
            new User(1, "login1", "Test name 1", Role.USER),
            new User(2, "login2", "Test name 2", Role.USER),
            new User(3, "login3", "Test name 3", Role.USER)
    ).toList();

    public User getUserById(int id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

}
