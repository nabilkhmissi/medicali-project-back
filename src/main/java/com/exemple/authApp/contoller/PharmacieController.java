package com.exemple.authApp.contoller;

import com.exemple.authApp.entity.Pharmacie;
import com.exemple.authApp.Dtos.PharmacieSearchBy;
import com.exemple.authApp.services.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/pharmacie")
public class PharmacieController {

    @Autowired
    private PharmacyService pharmacyService;

    @PostMapping("/findBy")
    public List<Pharmacie> findBy(@RequestBody PharmacieSearchBy request) throws InterruptedException{
        TimeUnit.SECONDS.sleep(1);
        String gouvernaurat = request.getGouvernaurat();
        String name = request.getName();
        String dayOrNight  = request.getDayOrNight();
        return pharmacyService.findBy(name, gouvernaurat, dayOrNight);
    }

    @PostMapping("/save")
    public Pharmacie save(@RequestBody Pharmacie pharmacie){
        return pharmacyService.save(pharmacie);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        pharmacyService.delete(id);
    }

    @GetMapping("/find-all")
    public List<Pharmacie> findAll() throws InterruptedException{
        TimeUnit.SECONDS.sleep(1);
        return pharmacyService.findAll();
    }

}

