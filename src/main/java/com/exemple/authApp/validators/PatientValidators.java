package com.exemple.authApp.validators;

import com.exemple.authApp.Dtos.UserDto;
import com.exemple.authApp.entity.Patient;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class PatientValidators {
    public static List<String> validateUser(Patient user){
        List<String> errors = new ArrayList<>();
        if (user == null) {
            errors.add("Remplissez les champs s'il vous plait !");
            return errors;
        }
        if (StringUtils.isEmpty(user.getFirstName())) {
            errors.add("saisissez votre prénom s'il vous plait !");
        }
        if (StringUtils.isEmpty(user.getLastName())) {
            errors.add("saisissez votre nom s'il vous plait !");
        }
        if (StringUtils.isEmpty(user.getUsername())) {
            errors.add("saisissez votre identifiant s'il vous plait !");
        }
        if (StringUtils.isEmpty(user.getPassword())) {
            errors.add("saisissez votre mot de passe s'il vous plait !");
        }
        return errors;
    }
}
