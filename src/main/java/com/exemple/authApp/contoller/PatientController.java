package com.exemple.authApp.contoller;

import com.exemple.authApp.entity.Patient;
import com.exemple.authApp.serviceImpl.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/new")
    public Patient save(@RequestBody Patient patient){
        return patientService.save(patient);
    }


}
