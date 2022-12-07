package com.exemple.authApp.contoller;

import com.exemple.authApp.Dtos.AuthenticationResponse;
import com.exemple.authApp.Dtos.AuthenticationRequest;
import com.exemple.authApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/login")
public class AuthenticationController {

    @Autowired
    private UserService userService;
    @PostMapping
    public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest user) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return userService.authenticate(user);
    }


}
