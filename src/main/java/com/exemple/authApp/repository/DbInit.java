package com.exemple.authApp.repository;

import com.exemple.authApp.Dtos.UserDto;
import com.exemple.authApp.entity.*;
import com.exemple.authApp.entity.MedicalFolder.Maladie;
import com.exemple.authApp.serviceImpl.PatientService;
import com.exemple.authApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {

    private SpecialityRepo specialityRepo;
    private UserService userService;
    private LaboratoireRepo laboratoireRepo;
    private PatientRepo patientRepo;
    private PatientService patientService;

    @Autowired
    public DbInit(SpecialityRepo specialityRepo, UserService userService, LaboratoireRepo laboratoireRepo, PatientRepo patientRepo, PatientService patientService) {
        this.specialityRepo = specialityRepo;
        this.userService = userService;
        this.laboratoireRepo = laboratoireRepo;
        this.patientRepo = patientRepo;
        this.patientService = patientService;
    }

    @Override
    public void run(String... args) throws Exception {
        createSpecialities();
        Patient p1 = new Patient("admin", "admin", "admin", "admin", "admin" );
        Patient p2 = new Patient("user", "user", "user", "user", "user" );

        patientService.save(p1);
        patientService.save(p2);
    }
    private void createSpecialities() {
        Speciality s1 = new Speciality("Generaliste");
        Speciality s2 = new Speciality("Pédiatre(enfant)");
        Speciality s17 = new Speciality("Gériatre(personnes agées)");
        Speciality s3 = new Speciality("Dentiste");
        Speciality s4 = new Speciality("Allergologue");
        Speciality s5 = new Speciality("Cardiologue");
        Speciality s6 = new Speciality("Chirugien Cardio-Vasculaire");
        Speciality s18 = new Speciality("Chirugien Générale");
        Speciality s19 = new Speciality("Chirugien Pédiatre");
        Speciality s20 = new Speciality("Dermatologue");
        Speciality s21 = new Speciality("Gastro-Entérologue");
        Speciality s7 = new Speciality("Neurologue");
        Speciality s8 = new Speciality("Ophtalmologue");
        Speciality s9 = new Speciality("Gynécologue");
        Speciality s10 = new Speciality("Médecin interniste");
        Speciality s11 = new Speciality("ORL(oreille, nez,gorge)");
        Speciality s12 = new Speciality("Orthopédiste");
        Speciality s13 = new Speciality("Pédopsychiatre");
        Speciality s14 = new Speciality("Psychiatre");
        Speciality s15 = new Speciality("Rhumatologue");
        Speciality s31 = new Speciality("veterinaire");

        List<Speciality> specilities = Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s17, s18, s19, s31);
        specialityRepo.saveAll(specilities);
    }
}
