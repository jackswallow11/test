package com.crud.test.repository;

import com.crud.test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<User, Integer> {
     User findByEmail(String email);

}
