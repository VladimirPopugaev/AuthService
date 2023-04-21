package com.popugaevvn.authservice.repository.user;

import com.popugaevvn.authservice.models.User;

import java.util.List;

public interface UserRepository {

    List<User> getAllUsers();

    User getUserById(int id);

}
