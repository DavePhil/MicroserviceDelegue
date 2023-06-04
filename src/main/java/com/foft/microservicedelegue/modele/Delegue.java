package com.foft.microservicedelegue.modele;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@DynamicUpdate
public class Delegue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String email;
    private String matricule;
    private String password;
    private String photo;
    private int id_classe;


    public Delegue() {
        super();
        password = "1234";
    }
}
