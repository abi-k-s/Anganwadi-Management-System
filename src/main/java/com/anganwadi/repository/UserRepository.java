package com.anganwadi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.anganwadi.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
   Users findByUsername(String username);
   boolean existsByUsername(String username);//to check in staff if same username exist

}

