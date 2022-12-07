package com.exemple.authApp.contoller;

import com.exemple.authApp.Dtos.DoctorDto;
import com.exemple.authApp.Dtos.SearchBy;
import com.exemple.authApp.entity.Doctor;
import com.exemple.authApp.services.DoctorService;
import com.exemple.authApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/doctor")
public class DoctorController {

    private DoctorService doctorService;
    private UserService userService;

    @Autowired
    public DoctorController(DoctorService doctorService, UserService userService) {
        this.doctorService = doctorService;
        this.userService = userService;
    }


    @GetMapping("/find-all")
    public List<DoctorDto> findAll() throws InterruptedException{
        TimeUnit.SECONDS.sleep(1);
        return doctorService.findAll();
    }


    @GetMapping("/speciality/{speciality}")
    public List<DoctorDto> findAllBySpeciality(@PathVariable String speciality){
        return doctorService.findBySpeciality(speciality);
    }
    @GetMapping("/find-by-id/{id}")
    public DoctorDto findById(@PathVariable Long id){
        return DoctorDto.fromEntity(doctorService.findById(id));
    }

    @GetMapping("/find-unvalid")
    public List<DoctorDto> findUnvalid(){
        return doctorService.findUnvalid();
    }

    @PostMapping("/save")
    public Doctor save(@RequestBody Doctor doctor){
        return doctorService.save(doctor);
    }

    @PostMapping("/findBy")
    public List<DoctorDto> findAllBySpeciality(@RequestBody SearchBy request) throws InterruptedException{
        TimeUnit.SECONDS.sleep(1);
        String praticienName = request.getPraticienName();
        String speciality = request.getSpeciality();
        String gouvernaurat = request.getGouvernaurat();
        return doctorService.findBy(praticienName,speciality, gouvernaurat);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        doctorService.delete(id);
    }


}
