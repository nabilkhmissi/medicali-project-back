package com.exemple.authApp.entity.MedicalFolder;

import com.exemple.authApp.entity.User;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Analyse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String etablissement;
    private Date date;
    private String description;
    @CreationTimestamp
    private Date creationDate;

    //@ManyToMany(mappedBy = "analyses")
    //private List<DossierMedical> dossierMedical;



    public Analyse(){
    }

    public Analyse(String name, String etablissement, Date date, String description, Date creationDate) {
        this.name = name;
        this.etablissement = etablissement;
        this.date = date;
        this.description = description;
        this.creationDate = creationDate;
    }
}
