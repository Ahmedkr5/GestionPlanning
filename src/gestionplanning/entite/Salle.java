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
public class Salle {
    public int num_salle;
   private int capacite;
    
    public Salle(int num_salle,int capacite) {
        this.num_salle=num_salle;
        this.capacite=capacite;
    }
   public int getnum_salle() {
        return num_salle;
    }

    public void setnum_salle(int num_salle) {
        this.num_salle = num_salle;
    }
      public int getcapacite() {
        return capacite;
    }

    public void setcapacite(int capacite) {
        this.capacite = capacite;
    }
    
     @Override
    public String toString() {
        return "Salle{" + "salle n°=" + num_salle + ", capacite=" + capacite + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Salle other = (Salle) obj;
        if (this.num_salle != other.num_salle) {
            return false;
        }
        return true;
    }
    
}
 