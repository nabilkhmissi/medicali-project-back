package com.exemple.authApp.contoller.MedicalFolderControllers;

import com.exemple.authApp.entity.MedicalFolder.Analyse;
import com.exemple.authApp.entity.MedicalFolder.DossierMedical;
import com.exemple.authApp.exceptions.EntityNotFoundException;
import com.exemple.authApp.repository.MedicalFolerRepo;
import com.exemple.authApp.serviceImpl.MedicalFolder.AnalyseService;
import org.hibernate.action.internal.EntityActionVetoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/medical-folder")
public class AnalyseController {



    private AnalyseService analyseService;

    @Autowired
    public AnalyseController(AnalyseService analyseService) {
        this.analyseService = analyseService;
    }

    @Autowired
    private MedicalFolerRepo medicalFolerRepo;

    //@GetMapping("/user/{id}/analyse/find-all")
    //public List<Analyse> findByUserId(@PathVariable Long id){
       /// return analyseService.findAllByUserId(id);
    //}

    @PostMapping("/analyse/{id}")
    public void save(@RequestBody Analyse analyse,
                        @PathVariable Long id){
        DossierMedical m = medicalFolerRepo.findById(id).orElseThrow(()->new EntityNotFoundException("dossier medical non trouver"));
        List<Analyse> a = m.getAnalyses();
        a.add(analyse);
        medicalFolerRepo.save(m);
    }


    @DeleteMapping("/user/{userId}/analyse/delete/{analyseId}")
    public void delete(@PathVariable Long analyseId){
       analyseService.delete(analyseId);
    }

}
