package com.example.back.repository;

import com.example.back.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,String> {
    User findByEmail(String email);
    User findByEmailAndPassword(String email,String password);
    User findByFirstName(String firstName);
    Optional<User> findByUsername(String username);

    @Transactional
    @Modifying
    @Query(value = "update User as u Set u.online = false WHERE u.online = true")
    void setIsOnlineToFalse();
}
