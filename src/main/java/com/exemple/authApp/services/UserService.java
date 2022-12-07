package com.exemple.authApp.services;


import com.exemple.authApp.Dtos.AuthenticationResponse;
import com.exemple.authApp.Dtos.UserDataDto;
import com.exemple.authApp.Dtos.UserDto;
import com.exemple.authApp.Dtos.AuthenticationRequest;
import com.exemple.authApp.Dtos.PasswordChange;
import com.exemple.authApp.entity.User;
import java.util.List;

public interface UserService {
    UserDto saveUser(UserDto user);
    AuthenticationResponse authenticate(AuthenticationRequest user);
    List<UserDto> findAllUsers();
    void deleteUser(Long id);
    UserDataDto findById(Long id);
    void changePassword(PasswordChange passwordChange);

    AuthenticationResponse updateUserDetails(UserDataDto userDataDto);


}

