package com.example.Database;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by sumi on 2/8/16.
 */
@org.springframework.stereotype.Repository
public interface DatabaseRepository extends JpaRepository<Database, Long> {
    List<Database> findByUserId(Long userId);
    //List<Database> findByPasssword(String password);
}