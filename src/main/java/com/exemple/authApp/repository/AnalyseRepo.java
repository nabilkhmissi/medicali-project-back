package com.exemple.authApp.repository;

import com.exemple.authApp.entity.MedicalFolder.Analyse;
import com.exemple.authApp.entity.MedicalFolder.Maladie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnalyseRepo extends JpaRepository<Analyse, Long> {

    //@Query("select a from Analyse a where a..id = :id")
    //List<Analyse> findByUserId(@Param(value = "id") Long id);
}
