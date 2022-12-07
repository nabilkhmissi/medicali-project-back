package com.exemple.authApp.validators;

import com.exemple.authApp.entity.Doctor;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class DoctorValidators {

    public static List<String> validateDoctor(Doctor doctor){
        List<String> errors = new ArrayList<>();
        if (doctor == null) {
            errors.add("Remplissez les champs s'il vous plait !");
            return errors;
        }
        if (StringUtils.isEmpty(doctor.getFirstName())) {
            errors.add("saisissez votre prénom s'il vous plait !");
        }
        if (StringUtils.isEmpty(doctor.getLastName())) {
            errors.add("saisissez votre nom s'il vous plait !");
        }
        if (StringUtils.isEmpty(doctor.getUsername())) {
            errors.add("saisissez votre identifiant s'il vous plait !");
        }
        if (StringUtils.isEmpty(doctor.getPassword())) {
            errors.add("saisissez votre mot de passe s'il vous plait !");
        }
        if (doctor.getSpeciality() == null) {
            errors.add("saisissez votre spécialité s'il vous plait !");
        }
        if (doctor.getAddress() == null) {
            errors.add("saisissez votre local de travail s'il vous plait !");
        }
        if (StringUtils.isEmpty(doctor.getRpps_code())) {
            errors.add("saisissez votre code médecin s'il vous plait !");
        }
        if (StringUtils.isEmpty(doctor.getPrixConsultation())) {
            errors.add("saisissez le prix d'une consultation s'il vous plait !");
        }
        return errors;
    }


}
