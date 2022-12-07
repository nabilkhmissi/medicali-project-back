package com.exemple.authApp.services;


import com.exemple.authApp.Dtos.DoctorDto;
import com.exemple.authApp.entity.Doctor;
import java.util.List;


public interface DoctorService {


    Doctor save(Doctor user);
    List<DoctorDto> findBySpeciality(String speciality);
    List<DoctorDto> findAll();
    List<DoctorDto> findBy(String praticienName, String speciality, String gouvernaurat);
    Doctor findById(Long id);
    void delete(Long id);
    List<DoctorDto> findUnvalid();
    void validate(Long id);
}

