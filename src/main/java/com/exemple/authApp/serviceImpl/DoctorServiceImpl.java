package com.exemple.authApp.serviceImpl;

import com.exemple.authApp.Dtos.DoctorDto;
import com.exemple.authApp.Dtos.UserDto;
import com.exemple.authApp.entity.Doctor;
import com.exemple.authApp.entity.User;
import com.exemple.authApp.exceptions.EntityNotFoundException;
import com.exemple.authApp.exceptions.ErrorCodes;
import com.exemple.authApp.exceptions.InvalidEntitiyException;
import com.exemple.authApp.repository.DoctorRepo;
import com.exemple.authApp.repository.UserRepo;
import com.exemple.authApp.services.DoctorService;
import com.exemple.authApp.validators.DoctorValidators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    private DoctorRepo doctorRepo;
    private UserRepo userRepo;

    @Autowired
    public DoctorServiceImpl(DoctorRepo doctorRepo, UserRepo userRepo) {
        this.doctorRepo = doctorRepo;
        this.userRepo = userRepo;
    }


    @Override
    public Doctor save(Doctor doctor) {
        List<String> errors = DoctorValidators.validateDoctor(doctor);
        if(!errors.isEmpty()){
            throw new InvalidEntitiyException("veuillez remplir tout les champs s'il vous plait", ErrorCodes.PRATICIENT_NOT_VALID);
        }

        User u = userRepo.findByUsername(doctor.getUsername());
        Doctor d = doctorRepo.findByUsername(doctor.getUsername());
        if((doctor.getId() == null && d != null) || u != null) {
            throw new InvalidEntitiyException("utilisateur avec cet identifiant existe déja", ErrorCodes.PRATICIENT_ALREADY_EXISTS);
        }

        doctor.setAvatarUrl(UserDto.generateAvatarUrl());
        return doctorRepo.save(doctor);
    }

    @Override
    public List<DoctorDto> findBySpeciality(String speciality) {
        return doctorRepo.findBySpeciality(speciality).stream().map(DoctorDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public List<DoctorDto> findAll() {
        return doctorRepo.findAllValid().stream().map(DoctorDto::fromEntity).collect(Collectors.toList());

    }

    @Override
    public List<DoctorDto> findBy(String praticienName, String speciality, String gouvernaurat) {
        List<Doctor> searchResult = new ArrayList<>();
        //search by all fields (mrgl)
        if(!praticienName.equals("") && !gouvernaurat.equals("") && !speciality.equals("")){
            searchResult =  doctorRepo.findByNameAndSpecialityAndGouvernaurat(praticienName, speciality, gouvernaurat);
        }


        //search by spec and gouvernaurat (mrgl)
        if(praticienName.equals("") && !speciality.equals("") && !gouvernaurat.equals("")){
            searchResult =  doctorRepo.findBySpecialityAndGouvernaurat(speciality, gouvernaurat);
        }


        //search by speciality (mrgl)
        if(!speciality.equals("") && gouvernaurat.equals("") && praticienName.equals("")) {
            searchResult = doctorRepo.findBySpeciality(speciality);
        }


        //search by name (mrgl)
        if(speciality.equals("") && gouvernaurat.equals("") && !praticienName.equals("")) {
            searchResult =  doctorRepo.findByName(praticienName);
        }


        //search by name and speciality (mrgl)
        if(!speciality.equals("") && gouvernaurat.equals("") && !praticienName.equals("")) {
            searchResult =  doctorRepo.findByNameAndSpeciality(praticienName, speciality);
        }
        return searchResult.stream().map(DoctorDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public Doctor findById(Long id) {
        return doctorRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("user avec cette id n'existe pas", ErrorCodes.USER_NOT_FOUND));

    }

    @Override
    public void delete(Long id) {
        doctorRepo.deleteById(id);
    }

    @Override
    public List<DoctorDto> findUnvalid() {
        return doctorRepo.findUnvalid().stream().map(DoctorDto::fromEntity).collect(Collectors.toList());

    }

    @Override
    public void validate(Long id) {
        Doctor d = doctorRepo.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("doctor avec cette id n'existe pas"));
        d.setValid(true);
        doctorRepo.save(d);
    }
}
