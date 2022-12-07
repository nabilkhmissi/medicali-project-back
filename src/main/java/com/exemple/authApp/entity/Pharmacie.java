package com.exemple.authApp.entity;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@Entity
public class Pharmacie extends Praticien{

    private String dayOrNight;

    public Pharmacie(){}

    public Pharmacie(String firstName, String lastName, String username, String password, String phone, String role, String avatarUrl, String address, String gouvernaurat, String postalCode, String rpps_code, boolean valid, String dayOrNight) {
        super(firstName, lastName, username, password, phone, role, avatarUrl, address, gouvernaurat, postalCode, rpps_code, valid);
        this.dayOrNight = dayOrNight;
    }


}
