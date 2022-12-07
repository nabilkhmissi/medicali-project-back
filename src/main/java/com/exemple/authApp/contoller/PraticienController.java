package com.exemple.authApp.contoller;
import com.exemple.authApp.entity.Praticien;
import com.exemple.authApp.exceptions.EntityNotFoundException;
import com.exemple.authApp.repository.PraticienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/praticien")
public class PraticienController {

    private PraticienRepo praticienRepo;

    @Autowired
    public PraticienController(PraticienRepo praticienRepo) {
        this.praticienRepo = praticienRepo;
    }

    @GetMapping("/validate/{id}")
    public void validate(@PathVariable Long id){
        Praticien p = praticienRepo.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("praticien avec cet id n'existe pas"));
        p.setValid(true);
        praticienRepo.save(p);
    }
    @GetMapping("/find-all")
    public List<Praticien> findAll() throws InterruptedException{
        TimeUnit.SECONDS.sleep(1);
        return praticienRepo.findAll();
    }
    @GetMapping("/find-unvalid")
    public List<Praticien> finUnvalid() throws InterruptedException{
       TimeUnit.SECONDS.sleep(1);
        return praticienRepo.findUnvalid();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        praticienRepo.deleteById(id);
    }


}

