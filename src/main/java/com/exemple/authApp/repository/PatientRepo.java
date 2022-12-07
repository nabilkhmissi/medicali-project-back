package com.exemple.authApp.repository;

import com.exemple.authApp.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepo extends JpaRepository<Patient, Long> {
    //@Query("select u from User u where u.role = 'user'")
   // List<User> findAllUsers();
   // User findByUsernameAndPassword(String username, String password);
    //User findByUsername(String username);
}
