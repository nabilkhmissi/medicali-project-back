package com.exemple.authApp.serviceImpl;

import com.exemple.authApp.entity.Laboratoire;
import com.exemple.authApp.repository.LaboratoireRepo;
import com.exemple.authApp.services.LaboratoireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class LaboratoireServiceImpl implements LaboratoireService {

    private LaboratoireRepo laboratoireRepo;

    @Autowired
    public LaboratoireServiceImpl(LaboratoireRepo laboratoireRepo) {
        this.laboratoireRepo = laboratoireRepo;
    }

    @Override
    public Laboratoire save(Laboratoire laboratoire) {
        laboratoire.setValid(false);
        return laboratoireRepo.save(laboratoire);
    }

    @Override
    public List<Laboratoire> findAll() {
        return laboratoireRepo.findAll();
    }

    @Override
    public List<Laboratoire> findBy(String name, String gouvernaurat) {
        if(!name.equals("") && gouvernaurat.equals("")){
            return laboratoireRepo.findByName(name);
        }else if(!name.equals("") && !gouvernaurat.equals("")) {
            return laboratoireRepo.findByNameAndGouvernaurat(name, gouvernaurat);
        }else if(name.equals("") && !gouvernaurat.equals("")) {
            return laboratoireRepo.findByGouvernaurat(gouvernaurat);
        }
        return Collections.emptyList();
    }

    @Override
    public void delete(Long id) {
        laboratoireRepo.deleteById(id);
    }
}



