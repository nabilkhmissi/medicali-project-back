package com.exemple.authApp.repository;

import com.exemple.authApp.entity.Praticien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PraticienRepo extends JpaRepository<Praticien, Long> {

    @Query("select p from Praticien p where p.valid = false ")
    List<Praticien> findUnvalid();
}
