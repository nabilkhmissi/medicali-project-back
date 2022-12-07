package com.exemple.authApp.serviceImpl;

import com.exemple.authApp.Dtos.UserDto;
import com.exemple.authApp.entity.MedicalFolder.Analyse;
import com.exemple.authApp.entity.MedicalFolder.DossierMedical;
import com.exemple.authApp.entity.Patient;
import com.exemple.authApp.exceptions.EntityNotFoundException;
import com.exemple.authApp.exceptions.ErrorCodes;
import com.exemple.authApp.exceptions.InvalidEntitiyException;
import com.exemple.authApp.repository.MedicalFolerRepo;
import com.exemple.authApp.repository.PatientRepo;
import com.exemple.authApp.repository.PraticienRepo;
import com.exemple.authApp.validators.PatientValidators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {


    private PatientRepo patientRepo;
    private MedicalFolerRepo medicalFolerRepo;

    @Autowired
    public PatientService(PatientRepo patientRepo, MedicalFolerRepo medicalFolerRepo) {
        this.patientRepo = patientRepo;
        this.medicalFolerRepo = medicalFolerRepo;
    }

    public Patient save(Patient patient){
        List<String> errors = PatientValidators.validateUser(patient);
        if(!errors.isEmpty()){
            throw new InvalidEntitiyException("les données saisis sont manqués/invalides", ErrorCodes.USER_NOT_VALID, errors);
        }
        if(patient.getAvatarUrl() == "" || patient.getAvatarUrl() == null){
            patient.setAvatarUrl(UserDto.generateAvatarUrl());
        }
        if(patient.getId() == null){
            patient.setDossierMedical(new DossierMedical());
        }
        return patientRepo.save(patient);
    }

    public Patient findById(Long userId) {

        return patientRepo.findById(userId).orElseThrow(()-> new EntityNotFoundException("patient avec cette n'existe pas"));
    }



}
