package com.foft.microservicedelegue.modele;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    private Integer idClasse;

    public Delegue() {
        super();
        password = "1234";
    }
}
