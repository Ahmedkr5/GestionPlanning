/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionplanning.entite;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Darius
 */
public class Groupe {
    
    private String nom_group;
    private String id_enfant;
    private String nom;
    private String prenom;
    List<Enfant> listenfant;

    public String getNom_group() {
        return nom_group;
    }

    public void setNom_group(String nom_group) {
        this.nom_group = nom_group;
    }

    public String getId_enfant() {
        return id_enfant;
    }

    public void setId_enfant(String id_enfant) {
        this.id_enfant = id_enfant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Groupe other = (Groupe) obj;
        if (!Objects.equals(this.id_enfant, other.id_enfant)) {
            return false;
        }
        return true;
    }

  
    
    
    
    
    
}
