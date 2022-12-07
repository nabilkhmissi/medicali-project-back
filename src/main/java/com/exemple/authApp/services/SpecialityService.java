package com.exemple.authApp.services;


import com.exemple.authApp.entity.Speciality;

import java.util.List;

public interface SpecialityService {
    Speciality add(Speciality speciality);
    List<Speciality> findAll();
    Speciality save(Speciality speciality);
    void delete(Long id);
}

