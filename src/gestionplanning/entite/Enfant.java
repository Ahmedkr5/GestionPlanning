/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionplanning.entite;


public class Enfant {
private String idEnfant;
private String nom;
private String prenom;
private String dateNaiss;
private String sexe;
private String nom_group;
    public Enfant() {
    }

    public Enfant(String idEnfant, String nom, String prenom, String dateNaiss, String sexe, String nom_group) {
        this.idEnfant = idEnfant;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaiss = dateNaiss;
        this.sexe = sexe;
        this.nom_group = nom_group;
    }

  

    public String getIdEnfant() {
        return idEnfant;
    }

    public void setIdEnfant(String idEnfant) {
        this.idEnfant = idEnfant;
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

    public String getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(String dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getNom_group() {
        return nom_group;
    }

    public void setNom_group(String nom_group) {
        this.nom_group = nom_group;
    }

    @Override
    public String toString() {
        return "Enfant{" + "idEnfant=" + idEnfant + ", nom=" + nom + ", prenom=" + prenom + ", dateNaiss=" + dateNaiss + ", sexe=" + sexe + ", nom_group=" + nom_group + '}';
    }

   

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Enfant other = (Enfant) obj;
        if (this.idEnfant != other.idEnfant) {
            return false;
        }
        return true;
    }

}
