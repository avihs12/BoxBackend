package com.boxproject.backend.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boxproject.backend.Entities.Userr;

public interface UserRepository extends JpaRepository<Userr, Integer> {

    @Query("SELECT u FROM Userr u WHERE u.username = :username")
    public Userr getUserByUsername(@Param("username") String username);

    @Query(value = "select username from Userr", nativeQuery = true)
    List<String> getUsernames();
}
