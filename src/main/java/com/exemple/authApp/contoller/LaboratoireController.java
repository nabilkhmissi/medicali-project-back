package com.exemple.authApp.contoller;

import com.exemple.authApp.entity.Laboratoire;
import com.exemple.authApp.Dtos.LaboratoireSearchBy;
import com.exemple.authApp.services.LaboratoireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/laboratoires")
public class LaboratoireController {


    private LaboratoireService laboratoireService;

    @Autowired
    public LaboratoireController(LaboratoireService laboratoireService) {
        this.laboratoireService = laboratoireService;
    }


    @GetMapping("/find-all")
    public List<Laboratoire> findAll() throws InterruptedException{
        TimeUnit.SECONDS.sleep(1);
        return laboratoireService.findAll();
    }

    @PostMapping("/findBy")
    public List<Laboratoire> findBy(@RequestBody LaboratoireSearchBy request) throws InterruptedException{
        TimeUnit.SECONDS.sleep(1);
        String gouvernaurat = request.getGouvernaurat();
        String nomLaboratoire = request.getNomLaboratoire();
        return laboratoireService.findBy(nomLaboratoire, gouvernaurat);
    }

    @PostMapping("/save")
    public Laboratoire save(@RequestBody Laboratoire laboratoire){
        return laboratoireService.save(laboratoire);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        laboratoireService.delete(id);
    }

}

