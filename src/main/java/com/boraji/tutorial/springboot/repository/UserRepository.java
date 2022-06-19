package com.boraji.tutorial.springboot.repository;

import com.boraji.tutorial.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface UserRepository extends JpaRepository<User, Long>  {

    @Query(value = "SELECT * FROM user order by name", nativeQuery = true)
    public Collection<User> searchBySortName();

}
