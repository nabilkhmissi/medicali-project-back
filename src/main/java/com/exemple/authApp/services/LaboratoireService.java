package com.exemple.authApp.services;


import com.exemple.authApp.entity.Laboratoire;

import java.util.List;

public interface LaboratoireService {
    Laboratoire save(Laboratoire laboratoire);
    List<Laboratoire> findAll();
    List<Laboratoire> findBy(String name, String gouvernaurat);
    void delete(Long id);
}

