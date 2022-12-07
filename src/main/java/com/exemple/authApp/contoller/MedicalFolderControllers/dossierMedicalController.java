package com.exemple.authApp.contoller.MedicalFolderControllers;


import com.exemple.authApp.entity.MedicalFolder.Analyse;
import com.exemple.authApp.entity.MedicalFolder.DossierMedical;
import com.exemple.authApp.entity.MedicalFolder.Maladie;
import com.exemple.authApp.entity.MedicalFolder.Mesure;
import com.exemple.authApp.entity.Patient;
import com.exemple.authApp.exceptions.InvalidEntitiyException;
import com.exemple.authApp.repository.MedicalFolerRepo;
import com.exemple.authApp.serviceImpl.MedicalFolder.AnalyseService;
import com.exemple.authApp.serviceImpl.MedicalFolder.MaladieService;
import com.exemple.authApp.serviceImpl.PatientService;
import com.exemple.authApp.validators.MedicalFolderValidators.AnalyseValidators;
import com.exemple.authApp.validators.MedicalFolderValidators.MesureValidators;
import com.exemple.authApp.validators.MedicalFolderValidators.NewMaladieValidators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/user")
public class dossierMedicalController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private AnalyseService analyseService;
    @Autowired
    private MaladieService maladieService;


    @GetMapping("/{userId}/dossier-medical/find")
    public DossierMedical find(@PathVariable Long userId){
        Patient p = patientService.findById(userId);
       return p.getDossierMedical();
    }


    //ajouter analyse
    @PostMapping("/{patientId}/dossier-medical/analyse/new")
    public Analyse save(@RequestBody Analyse analyse, @PathVariable Long patientId){

       List<String> errors =  AnalyseValidators.validateAnalyse(analyse);
        if(!errors.isEmpty()){
            throw new InvalidEntitiyException("les données de l'analyse de sont pas valides/manquants", errors);
        }
        Patient p = patientService.findById(patientId);
        DossierMedical d = p.getDossierMedical();
        List<Analyse> a = d.getAnalyses();
        a.add(analyse);
        patientService.save(p);
        return analyse;
    }


    @GetMapping("/{patientId}/dossier-medical/analyse/find-all")
    public List<Analyse> findAll(@PathVariable Long patientId){
        Patient p = patientService.findById(patientId);
        return p.getDossierMedical().getAnalyses();
    }

    @DeleteMapping("dossier-medical/analyse/{analyseId}")
    public void deleteAnalyse(@PathVariable Long analyseId){
        analyseService.delete(analyseId);
    }



//gestion maladies
    //ajouter maladie
@PostMapping("/{patientId}/dossier-medical/maladie/new")
public Maladie save(@RequestBody Maladie maladie, @PathVariable Long patientId){

    List<String> errors =  NewMaladieValidators.validateMaladie(maladie);
    if(!errors.isEmpty()){
        throw new InvalidEntitiyException("les données du maladie ne sont pas valides/manquants", errors);
    }
    Patient p = patientService.findById(patientId);
    DossierMedical d = p.getDossierMedical();
    List<Maladie> m = d.getMaladies();
    m.add(maladie);

    patientService.save(p);
    return maladie;
}


    @GetMapping("/{patientId}/dossier-medical/maladie/find-all")
    public List<Maladie> findAllMaladies(@PathVariable Long patientId){
        Patient p = patientService.findById(patientId);
        return p.getDossierMedical().getMaladies();
    }

    @DeleteMapping("dossier-medical/maladie/{maladieId}")
    public void deleteMaladie(@PathVariable Long maladieId){
        maladieService.delete(maladieId);
    }

    //gestion mesures
    //ajouter mesure
    @PostMapping("/{patientId}/dossier-medical/mesure/new")
    public Mesure save(@RequestBody Mesure mesure, @PathVariable Long patientId){

        List<String> errors =  MesureValidators.validateMesure(mesure);
        if(!errors.isEmpty()){
            throw new InvalidEntitiyException("les données du mesure sont invalides/manquants", errors);
        }
        Patient p = patientService.findById(patientId);
        DossierMedical d = p.getDossierMedical();
        List<Mesure> m = d.getMesures();
        m.add(mesure);

        patientService.save(p);
        return mesure;
    }


    @GetMapping("/{patientId}/dossier-medical/mesures/find-all")
    public List<Mesure> findAllMesures(@PathVariable Long patientId){
        Patient p = patientService.findById(patientId);
        return p.getDossierMedical().getMesures();
    }







}
