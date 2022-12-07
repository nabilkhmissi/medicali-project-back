package com.exemple.authApp.validators.MedicalFolderValidators;

import com.exemple.authApp.entity.MedicalFolder.Analyse;
import com.exemple.authApp.entity.MedicalFolder.Maladie;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AnalyseValidators {

    public static List<String> validateAnalyse(Analyse analyse){
        List<String> errors = new ArrayList<>();
        if (StringUtils.isEmpty(analyse.getName())) {
            errors.add("donnez un nom à l'analyse !");
        }
        if (StringUtils.isEmpty(analyse.getEtablissement())) {
            errors.add("saisissez l'etablissement de l'analyse !");
        }
        //if (analyse.getDate() == null) {
            //errors.add("saisissez la date de l'analyse !");
        //}
        return errors;
    }


}
