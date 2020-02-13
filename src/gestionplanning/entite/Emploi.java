/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionplanning.entite;

/**
 *
 * @author Darius
 */
public class Emploi {
    private int num_emploi ;
    private String jour;
    private int heure_deb;
    private int heure_fin;
    private int nb_heures;

    public Emploi(int num_emploi, String jour, int heure_deb, int heure_fin, int nb_heures) {
        this.num_emploi = num_emploi;
        this.jour = jour;
        this.heure_deb = heure_deb;
        this.heure_fin = heure_fin;
        this.nb_heures = nb_heures;
    }

    public Emploi(String jour, int heure_deb, int heure_fin, int nb_heures) {
        this.jour = jour;
        this.heure_deb = heure_deb;
        this.heure_fin = heure_fin;
        this.nb_heures = nb_heures;
    }
 
    


    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public int getHeure_deb() {
        return heure_deb;
    }

    public void setHeure_deb(int heure_deb) {
        this.heure_deb = heure_deb;
    }

    public int getHeure_fin() {
        return heure_fin;
    }

    public void setHeure_fin(int heure_fin) {
        this.heure_fin = heure_fin;
    }

    public int getNum_emploi() {
        return num_emploi;
    }

    public void setNum_emploi(int num_emploi) {
        this.num_emploi = num_emploi;
    }

    public int getNb_heures() {
        return nb_heures;
    }

    public void setNb_heures(int nb_heures) {
        this.nb_heures = nb_heures;
    }

    @Override
    public String toString() {
        return "Emploi{" + "num_emploi=" + num_emploi + ", jour=" + jour + ", heure_deb=" + heure_deb + ", heure_fin=" + heure_fin + ", nb_heures=" + nb_heures + '}';
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
        final Emploi other = (Emploi) obj;
        if (this.num_emploi != other.num_emploi) {
            return false;
        }
        return true;
    }

    

  
  
    
}
