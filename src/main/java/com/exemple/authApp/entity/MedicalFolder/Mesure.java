package com.exemple.authApp.entity.MedicalFolder;

import com.exemple.authApp.entity.User;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Mesure {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Date date;
    private String hauteur;
    private String poids;
    private String groupeSanguin;
    private String pressionSanguine;
    private String description;
    @CreationTimestamp
    private Date creationDate;


    public Mesure(){
    }

    public Mesure(String name, Date date, String hauteur, String poids, String groupeSanguin, String pressionSanguine, String description) {
        this.name = name;
        this.date = date;
        this.hauteur = hauteur;
        this.poids = poids;
        this.groupeSanguin = groupeSanguin;
        this.pressionSanguine = pressionSanguine;
        this.description = description;
    }
}
