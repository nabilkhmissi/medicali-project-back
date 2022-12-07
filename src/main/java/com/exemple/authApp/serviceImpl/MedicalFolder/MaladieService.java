package com.exemple.authApp.serviceImpl.MedicalFolder;

import com.exemple.authApp.entity.MedicalFolder.Analyse;
import com.exemple.authApp.entity.User;
import com.exemple.authApp.exceptions.EntityNotFoundException;
import com.exemple.authApp.exceptions.InvalidEntitiyException;
import com.exemple.authApp.repository.AnalyseRepo;
import com.exemple.authApp.repository.MaladieRepo;
import com.exemple.authApp.repository.UserRepo;
import com.exemple.authApp.validators.MedicalFolderValidators.AnalyseValidators;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaladieService {

    private MaladieRepo maladieRepo;

    public void delete(Long id) {
        maladieRepo.deleteById(id);
    }
}
