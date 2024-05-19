package com.virendra.firstproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.virendra.firstproject.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

     
}