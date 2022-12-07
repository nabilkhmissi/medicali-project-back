package com.exemple.authApp.repository;

import com.exemple.authApp.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorRepo extends JpaRepository<Doctor, Long> {
    @Query("select d from Doctor d where d.speciality.name = :spec and d.valid = true")
    List<Doctor> findBySpeciality(@Param(value = "spec") String speciality);

    @Query("select d from Doctor d where d.firstName = :name and d.speciality.name = :spec and d.gouvernaurat = :gouv and d.valid = true")
    List<Doctor> findByNameAndSpecialityAndGouvernaurat(@Param(value = "name") String praticienName,
                                                           @Param(value = "spec") String speciality,
                                                           @Param(value = "gouv") String gouvernaurat);

    @Query("select d from Doctor d where d.speciality.name = :spec and d.gouvernaurat = :gouv and d.valid = true")
    List<Doctor> findBySpecialityAndGouvernaurat(@Param(value = "spec") String speciality,
                                                    @Param(value = "gouv") String gouvernaurat);

    Doctor findByUsername(String username);

    @Query("select d from Doctor d where d.firstName = :name and d.valid = true")
    List<Doctor> findByName(@Param(value = "name")String praticienName);

    @Query("select d from Doctor d where d.firstName = :name and d.speciality.name = :spec and d.valid = true")
    List<Doctor> findByNameAndSpeciality(@Param(value = "name")String praticienName,
                                            @Param(value = "spec")String speciality);
    @Query("select d from Doctor d where d.valid = false")
    List<Doctor> findUnvalid();

    @Query("select d from Doctor d where d.valid = true")
    List<Doctor> findAllValid();
}
