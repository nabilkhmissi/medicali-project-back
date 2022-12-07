package com.exemple.authApp.entity;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Praticien extends User {

    private String rpps_code;
    private boolean valid;

    public Praticien() {
    }

    public Praticien(String firstName, String lastName, String username, String password, String phone, String role, String avatarUrl, String address, String gouvernaurat, String postalCode, String rpps_code, boolean valid) {
        super(firstName, lastName, username, password, phone, role, avatarUrl, address, gouvernaurat, postalCode);
        this.rpps_code = rpps_code;
        this.valid = valid;
    }
}




