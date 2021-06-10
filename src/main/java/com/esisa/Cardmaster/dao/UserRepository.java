package com.esisa.Cardmaster.dao;

import com.esisa.Cardmaster.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserById(int id);

	Optional<User> findUserByUsername(String username);
}
