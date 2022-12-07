package com.exemple.authApp.entity.MedicalFolder;

import com.exemple.authApp.entity.Patient;
import com.exemple.authApp.entity.User;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class DossierMedical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Analyse> analyses = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Maladie> maladies = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    List<Mesure> mesures = new ArrayList<>();

    public DossierMedical(){
    }

    public DossierMedical(List<Analyse> analyses, List<Maladie> maladies, List<Mesure> mesures) {
        this.analyses = analyses;
        this.maladies = maladies;
        this.mesures = mesures;
    }
}
