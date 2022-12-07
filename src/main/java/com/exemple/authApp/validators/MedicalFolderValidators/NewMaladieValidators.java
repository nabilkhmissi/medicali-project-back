package com.exemple.authApp.validators.MedicalFolderValidators;

import com.exemple.authApp.entity.MedicalFolder.Maladie;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class NewMaladieValidators {

    public static List<String> validateMaladie(Maladie maladie){
        List<String> errors = new ArrayList<>();
        if (StringUtils.isEmpty(maladie.getName())) {
            errors.add("saisissez le nom du maladie s'il vous plait !");
        }
        if (StringUtils.isEmpty(maladie.getMedicalSpeciality())) {
            errors.add("saisissez la spécialité medicale s'il vous plait !");
        }
        return errors;
    }


}
