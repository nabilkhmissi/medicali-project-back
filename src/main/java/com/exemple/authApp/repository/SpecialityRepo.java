package com.exemple.authApp.repository;

import com.exemple.authApp.entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialityRepo extends JpaRepository<Speciality, Long> {
    Speciality getByName(String name);
}
