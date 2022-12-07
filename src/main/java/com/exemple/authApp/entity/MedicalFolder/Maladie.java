package com.exemple.authApp.entity.MedicalFolder;

import com.exemple.authApp.entity.User;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Maladie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String medicalSpeciality;
    private boolean familialAntecedent;
    private boolean longTermMalady;
    private Date dateDetection;
    private Date dateGuerir;
    private String description;
    @CreationTimestamp
    private Date creationDate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;

    public Maladie(){
    }

    public Maladie(String name, String medicalSpeciality, boolean familialAntecedent, boolean longTermMalady, Date dateDetection, Date dateGuerir, String description, Date creationDate, User user) {
        this.name = name;
        this.medicalSpeciality = medicalSpeciality;
        this.familialAntecedent = familialAntecedent;
        this.longTermMalady = longTermMalady;
        this.dateDetection = dateDetection;
        this.dateGuerir = dateGuerir;
        this.description = description;
        this.creationDate = creationDate;
        this.user = user;
    }
}
