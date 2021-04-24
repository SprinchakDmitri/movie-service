package com.daa.movieservice.repository;

import com.daa.movieservice.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph
    Optional<User> getUserByUserName(String username);

    boolean existsUserByUserNameOrEmail(String userName, String email);
}
