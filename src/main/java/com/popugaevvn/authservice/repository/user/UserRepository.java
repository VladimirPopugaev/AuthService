package com.popugaevvn.authservice.repository.user;

import com.popugaevvn.authservice.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByLogin(String login);

}
