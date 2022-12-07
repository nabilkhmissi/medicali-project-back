package com.exemple.authApp.repository;

import com.exemple.authApp.entity.Pharmacie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PharmacyRepo extends JpaRepository<Pharmacie, Long> {
    @Query("select p from Pharmacie p where p.firstName = :name")
    List<Pharmacie> findByName(@Param(value = "name") String name);

    @Query("select p from Pharmacie p where p.gouvernaurat= :gouv and p.dayOrNight = :dayOrNight ")
    List<Pharmacie> findByGouvernauraAndDayOrNight(@Param(value = "gouv") String gouv,
                                                   @Param(value = "dayOrNight") String dayOrNight);

    @Query("select p from Pharmacie p where p.gouvernaurat = :gouv")
    List<Pharmacie> findByGouvernaurat(@Param(value = "gouv") String gouvernaurat);

    @Query("select f from Pharmacie f where f.valid = true")
    List<Pharmacie> findAll();
}
