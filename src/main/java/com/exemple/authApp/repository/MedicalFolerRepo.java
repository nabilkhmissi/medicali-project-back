package com.exemple.authApp.repository;


import com.exemple.authApp.entity.MedicalFolder.DossierMedical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedicalFolerRepo extends JpaRepository<DossierMedical, Long> {


   // @Query("select d from DossierMedical d where d.patient.id = :patientId")
    //DossierMedical findByPatientId(@Param(value = "patientId") Long id);
}
