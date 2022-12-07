package com.exemple.authApp.contoller;

import com.exemple.authApp.Dtos.AuthenticationResponse;
import com.exemple.authApp.Dtos.UserDataDto;
import com.exemple.authApp.Dtos.PasswordChange;
import com.exemple.authApp.Dtos.UserDto;
import com.exemple.authApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/find-all")
    public List<UserDto> findAll() throws InterruptedException{
        TimeUnit.SECONDS.sleep(1);
        return userService.findAllUsers();
    }



    @GetMapping("/find-by-id/{id}")
    public UserDataDto findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping("/change-password")
    public void changePassword(@RequestBody PasswordChange passwordChange){
        userService.changePassword(passwordChange);
    }


    @PostMapping("/update-user-details")
    public AuthenticationResponse updateUserDetails(@RequestBody UserDataDto userDataDto){
        return userService.updateUserDetails(userDataDto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        userService.deleteUser(id);
    }



}

