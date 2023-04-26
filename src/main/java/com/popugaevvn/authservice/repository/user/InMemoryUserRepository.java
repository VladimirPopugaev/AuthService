package com.popugaevvn.authservice.repository.user;

import com.popugaevvn.authservice.models.User;

import java.util.ArrayList;
import java.util.List;

public abstract class InMemoryUserRepository implements UserRepository {

    private final List<User> users = new ArrayList<>();

    public User getUserById(int id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

}
