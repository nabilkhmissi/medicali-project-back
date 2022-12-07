package com.exemple.authApp.entity;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Doctor extends Praticien {

    @OneToOne
    private Speciality speciality;

    private int prixConsultation;

    public Doctor(){
    }

    public Doctor(String firstName, String lastName, String username, String password, String phone, String role, String avatarUrl, String address, String gouvernaurat, String postalCode, String rpps_code, boolean valid, Speciality speciality, int prixConsultation) {
        super(firstName, lastName, username, password, phone, role, avatarUrl, address, gouvernaurat, postalCode, rpps_code, valid);
        this.speciality = speciality;
        this.prixConsultation = prixConsultation;
    }


}
