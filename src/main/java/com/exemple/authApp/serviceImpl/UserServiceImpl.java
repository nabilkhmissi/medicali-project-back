package com.exemple.authApp.serviceImpl;

import com.exemple.authApp.Dtos.AuthenticationResponse;
import com.exemple.authApp.Dtos.UserDataDto;
import com.exemple.authApp.Dtos.UserDto;
import com.exemple.authApp.Dtos.AuthenticationRequest;
import com.exemple.authApp.Dtos.PasswordChange;
import com.exemple.authApp.entity.User;
import com.exemple.authApp.exceptions.EntityNotFoundException;
import com.exemple.authApp.exceptions.ErrorCodes;
import com.exemple.authApp.exceptions.InvalidEntitiyException;
import com.exemple.authApp.repository.UserRepo;
import com.exemple.authApp.services.UserService;
import com.exemple.authApp.validators.UserDetailsUpdateValidators;
import com.exemple.authApp.validators.UserValidators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;


    @Override
    public UserDto saveUser(UserDto user) {
        List<String> errors = UserValidators.validateUser(user);
        if(!errors.isEmpty()){
            throw new InvalidEntitiyException("invalid user details", ErrorCodes.USER_NOT_VALID, errors);
        }
        User u = userRepo.findByUsername(user.getUsername());
        if(user.getId() == null && u != null){
            throw new InvalidEntitiyException("Utilisateur avec cet identifiant existe déja", ErrorCodes.USER_EXISTS);
        }
        if(user.getAvatarUrl() == "" || user.getAvatarUrl() == null){
            user.setAvatarUrl(UserDto.generateAvatarUrl());
        }

        return UserDto.fromEntity(userRepo.save(UserDto.toEntity(user)));
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest user) {
       String username = user.getUsername();
       String password = user.getPassword();
       User loggedUser = userRepo.findByUsernameAndPassword(username, password);
       if(loggedUser == null){
           throw new EntityNotFoundException("identifiant/mot de passe incorrect", ErrorCodes.USER_NOT_FOUND);
       }
        return AuthenticationResponse.getAuthenticationResponseFromUser(loggedUser) ;
    }

    @Override
    public List<UserDto> findAllUsers() {
        return userRepo.findAllUsers().stream().map(UserDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public UserDataDto findById(Long id) {
        User u = userRepo.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("user with this id not found", ErrorCodes.USER_NOT_FOUND)
        );
        return UserDataDto.fromEntity(u);
    }

    @Override
    public void changePassword(PasswordChange passwordChange) {
        User u = userRepo.findById(passwordChange.getUserId()).orElseThrow(
                ()->new EntityNotFoundException("user avec cette id n'existe pas",ErrorCodes.USER_NOT_FOUND)
        );
        String actualPassword = passwordChange.getActualPassword();
        String newPassword = passwordChange.getNewPassword();
        String confirmNewPassword = passwordChange.getConfirmNewPassword();

        if(!u.getPassword().equals(actualPassword)){
            throw new InvalidEntitiyException("mot de passe actuel n'est pas valide",ErrorCodes.USER_NOT_VALID);
        }
        if(!newPassword.equals(confirmNewPassword)){
            throw new InvalidEntitiyException("veuillez confirmer votre mot de passe");
        }
        u.setPassword(newPassword);
        userRepo.save(u);
    }

    @Override
    public AuthenticationResponse updateUserDetails(UserDataDto userDataDto) {
        List<String> errors = UserDetailsUpdateValidators.validateUser(userDataDto);
        if(!errors.isEmpty()){
            throw new InvalidEntitiyException("Nom, prenom et identifiant ne faut pas être nuls", errors);
        }
        User u = userRepo.getById(userDataDto.getId());
        u.setFirstName(userDataDto.getFirstName());
        u.setLastName(userDataDto.getLastName());
        u.setPhone(userDataDto.getPhone());
        u.setAddress(userDataDto.getAddress());
        u.setGouvernaurat(userDataDto.getGouvernaurat());
        u.setPostalCode(userDataDto.getPostalCode());
        u.setUsername(userDataDto.getUsername());
        u.setAvatarUrl(userDataDto.getAvatarUrl());
        return AuthenticationResponse.getAuthenticationResponseFromUser(userRepo.save(u));
    }
}
