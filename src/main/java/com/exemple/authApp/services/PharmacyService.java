package com.exemple.authApp.services;

import com.exemple.authApp.entity.Pharmacie;

import java.util.List;

public interface PharmacyService {

    Pharmacie save(Pharmacie pharmacie);

    List<Pharmacie> findBy(String name, String gouvernaurat, String dayOrNight);

    List<Pharmacie> findAll();

    void delete(Long id);
}

