package com.exemple.authApp.repository;

import com.exemple.authApp.entity.MedicalFolder.Analyse;
import com.exemple.authApp.entity.MedicalFolder.Maladie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaladieRepo extends JpaRepository<Maladie, Long> {

    //@Query("select a from Analyse a where a..id = :id")
    //List<Analyse> findByUserId(@Param(value = "id") Long id);
}
