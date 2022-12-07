package com.exemple.authApp.serviceImpl.MedicalFolder;

import com.exemple.authApp.entity.MedicalFolder.Analyse;
import com.exemple.authApp.entity.User;
import com.exemple.authApp.exceptions.EntityNotFoundException;
import com.exemple.authApp.exceptions.InvalidEntitiyException;
import com.exemple.authApp.repository.AnalyseRepo;
import com.exemple.authApp.repository.UserRepo;
import com.exemple.authApp.validators.MedicalFolderValidators.AnalyseValidators;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesureService {

    private AnalyseRepo analyseRepo;
    private UserRepo userRepo;

    public MesureService(UserRepo userRepo, AnalyseRepo analyseRepo) {
        this.analyseRepo = analyseRepo;
        this.userRepo = userRepo;
    }

    public Analyse save(Analyse analyse, Long id) {
        List<String> errors = AnalyseValidators.validateAnalyse(analyse);
        if(!errors.isEmpty()){
            throw new InvalidEntitiyException("information de l'analyse sont incorrects", errors);
        }
        User u = userRepo.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("user with this id not found"));
        //analyse.setUser(u);
        return analyseRepo.save(analyse);
    }

    public void delete(Long id) {
        analyseRepo.deleteById(id);
    }
}
