package org.lpro.devwebService.entity;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sandwich")
public class Sandwich {

    @Id
    private String id;
    private String nom;
    private String desc;

    public Sandwich () {}

    public Sandwich (String nom, String desc) {
        this.nom  = nom;
        this.desc = desc;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nom='" + getNom() + "'" +
            ", desc='" + getDesc() + "'" +
            "}";
    }
    
}