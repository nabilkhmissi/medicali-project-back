package com.exemple.authApp.serviceImpl;
import com.exemple.authApp.entity.Speciality;
import com.exemple.authApp.exceptions.InvalidEntitiyException;
import com.exemple.authApp.repository.SpecialityRepo;
import com.exemple.authApp.services.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityServiceImpl implements SpecialityService {
    @Autowired
    private SpecialityRepo specialityRepo;


    @Override
    public Speciality add(Speciality speciality) {
        return specialityRepo.save(speciality);
    }

    @Override
    public List<Speciality> findAll() {
        return specialityRepo.findAll();
    }

    @Override
    public Speciality save(Speciality speciality) {
        if(speciality.getName() == null){
            throw new InvalidEntitiyException("Nom spécialité invalide");
        }

        Speciality s = specialityRepo.getByName(speciality.getName());
        if(s != null){
            throw new InvalidEntitiyException("spécialité existe déja !");
        }
        return specialityRepo.save(speciality);
    }

    @Override
    public void delete(Long id) {
        specialityRepo.deleteById(id);
    }
}
