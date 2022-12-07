package com.exemple.authApp.serviceImpl;

import com.exemple.authApp.entity.Pharmacie;
import com.exemple.authApp.repository.PharmacyRepo;
import com.exemple.authApp.services.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PharmacyServiceImpl implements PharmacyService {

    private PharmacyRepo pharmacyRepo;
    @Autowired
    public PharmacyServiceImpl(PharmacyRepo pharmacyRepo) {
        this.pharmacyRepo = pharmacyRepo;
    }


    @Override
    public Pharmacie save(Pharmacie pharmacie) {
        pharmacie.setValid(false);
        return pharmacyRepo.save(pharmacie);
    }

    @Override
    public List<Pharmacie> findBy(String name, String gouvernaurat, String dayOrNight) {
        if(!name.equals("") && gouvernaurat.equals("")){
            return pharmacyRepo.findByName(name);
        }
        if(name.equals("") && !gouvernaurat.equals("") && dayOrNight.equals("")) {
            return pharmacyRepo.findByGouvernaurat(gouvernaurat);
        }
        if(name.equals("") && !gouvernaurat.equals("") && !dayOrNight.equals("")) {
            return pharmacyRepo.findByGouvernauraAndDayOrNight(gouvernaurat, dayOrNight);
        }
        return Collections.emptyList();
    }

    @Override
    public List<Pharmacie> findAll() {
        return pharmacyRepo.findAll();
    }

    @Override
    public void delete(Long id) {
        pharmacyRepo.deleteById(id);
    }
}



