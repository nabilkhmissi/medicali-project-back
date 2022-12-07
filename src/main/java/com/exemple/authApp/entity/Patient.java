package com.exemple.authApp.entity;

import com.exemple.authApp.entity.MedicalFolder.DossierMedical;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Data
public class Patient extends User{

    @OneToOne(cascade = CascadeType.ALL)
    private DossierMedical dossierMedical;

    public Patient(String firstName, String lastName, String username, String password, String role) {
        super(firstName, lastName, username, password, role);
    }

    public Patient() {
    }
}
