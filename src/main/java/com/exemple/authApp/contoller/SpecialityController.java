package com.exemple.authApp.contoller;

import com.exemple.authApp.entity.Speciality;
import com.exemple.authApp.services.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/speciality")
public class SpecialityController {

    @Autowired
    private SpecialityService specialityService;

    @GetMapping("/find-all")
    public List<Speciality> findAll() throws InterruptedException{
        TimeUnit.SECONDS.sleep(1);
        return specialityService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        specialityService.delete(id);
    }

    @PostMapping("/add")
    public Speciality save(@RequestBody Speciality speciality){
        return specialityService.save(speciality);
    }
}
