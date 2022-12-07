package com.exemple.authApp.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Laboratoire extends Praticien{
   public Laboratoire() {
    }

    public Laboratoire(String firstName, String lastName, String username, String password, String phone, String role, String avatarUrl, String address, String gouvernaurat, String postalCode, String rpps_code, boolean valid) {
        super(firstName, lastName, username, password, phone, role, avatarUrl, address, gouvernaurat, postalCode, rpps_code, valid);
    }


}
