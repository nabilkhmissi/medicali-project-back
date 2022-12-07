package com.exemple.authApp.validators;

import com.exemple.authApp.Dtos.UserDataDto;
import com.exemple.authApp.Dtos.UserDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsUpdateValidators {
    public static List<String> validateUser(UserDataDto user){
        List<String> errors = new ArrayList<>();

        if (StringUtils.isEmpty(user.getFirstName())) {
            errors.add("saisissez votre prénom s'il vous plait !");
        }
        if (StringUtils.isEmpty(user.getLastName())) {
            errors.add("saisissez votre nom s'il vous plait !");
        }
        if (StringUtils.isEmpty(user.getUsername())) {
            errors.add("saisissez votre identifiant s'il vous plait !");
        }
        return errors;
    }
}
