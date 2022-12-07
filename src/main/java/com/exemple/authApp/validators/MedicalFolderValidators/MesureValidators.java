package com.exemple.authApp.validators.MedicalFolderValidators;

import com.exemple.authApp.entity.MedicalFolder.Mesure;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MesureValidators {

    public static List<String> validateMesure(Mesure mesure){
        List<String> errors = new ArrayList<>();
        if (StringUtils.isEmpty(mesure.getName())) {
            errors.add("donnez un nom au mesure !");
        }

        if (mesure.getDate() == null) {
            errors.add("saisissez la date du mesure !");
        }
        return errors;
    }


}
