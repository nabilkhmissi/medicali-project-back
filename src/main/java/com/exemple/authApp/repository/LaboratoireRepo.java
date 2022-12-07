package com.exemple.authApp.repository;

import com.exemple.authApp.entity.Laboratoire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LaboratoireRepo extends JpaRepository<Laboratoire, Long> {

    @Query("select l from Laboratoire l where l.firstName = :name and l.gouvernaurat = :gouv ")
    List<Laboratoire> findByNameAndGouvernaurat(@Param(value = "name") String name,
                                                @Param(value = "gouv") String gouv);

    @Query("select l from Laboratoire l where l.gouvernaurat = :gouv")
    List<Laboratoire> findByGouvernaurat(@Param(value = "gouv") String gouvernaurat);


    @Query("select l from Laboratoire l where l.firstName = :name")
    List<Laboratoire> findByName(@Param(value = "name") String name);

    @Query("select l from Laboratoire l where l.valid = true")
    List<Laboratoire> findAll();
}
