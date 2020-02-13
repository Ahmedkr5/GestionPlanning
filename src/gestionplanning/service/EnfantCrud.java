/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionplanning.service;

import gestionplanning.entite.Emploi;
import gestionplanning.entite.Enfant;
import gestionplanning.utils.baseDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EnfantCrud {
    
     private Connection con;
    private Statement ste;

    public EnfantCrud() {
       con = baseDB.getInstance().getConnection();
    }
    
    
    public void ajouterEnfant(Enfant a) {

        try {
            String requete1 = "INSERT INTO enfant (idEnfant ,nom , prenom, dateNaiss,sexe) VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(requete1);
            pst.setString(1, a.getIdEnfant());
            pst.setString(2, a.getNom());
            pst.setString(3, a.getPrenom());
            pst.setString(4, a.getDateNaiss());
            pst.setString(5, a.getSexe());
            pst.setString(6, a.getNom_group());
            pst.executeUpdate();
            System.out.println("Enfant ajouté !");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void afficher() {

        try {
            String requete3 = "SELECT * FROM enfant";
            PreparedStatement pst2 = con.prepareStatement(requete3);
            ResultSet rs = pst2.executeQuery();

            while (rs.next()) {

                Enfant a = new Enfant();
                a.setIdEnfant(rs.getString(1));
                a.setNom(rs.getString(2));
                a.setPrenom(rs.getString(3));
                a.setDateNaiss(rs.getString(4));
                a.setSexe(rs.getString(5));
                a.setNom_group(rs.getString(6));
                System.out.println("L'enfant numero " + a.getIdEnfant());
                System.out.println("Nom = " + a.getNom());
                System.out.println("Prenom = " + a.getPrenom());
                System.out.println("Date de naissance = " + a.getDateNaiss());
                System.out.println("Sexe = " + a.getSexe());
                System.out.println("nomgroup = " + a.getNom_group());
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

      //return Act;
    }
    public List<Enfant> afficherEnfant() {
        ArrayList<Enfant> kidList = new ArrayList<>();
        try {

            String requete3 = "SELECT * FROM enfant";
            PreparedStatement pst = con.prepareStatement(requete3);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Enfant en = new Enfant();

                en.setIdEnfant(rs.getString(1));
                en.setNom(rs.getString(2));
                en.setPrenom(rs.getString(3));
                en.setDateNaiss(rs.getString(4));
                en.setSexe(rs.getString(5));
                en.setNom_group(rs.getString(6));
                kidList.add(en);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return kidList;
    }

    public void ajouterEnfant2() {
        try {
            String dateNaiss="1998-05-09";
            String requete = "INSERT INTO enfant (idEnfant,nom , prenom, dateNaiss,sexe,nomgroup) VALUES ('E99','abdelhak'','dimassi','"+dateNaiss+"','M','G05')";
            ste = con.createStatement();
            ste.executeUpdate(requete);
            System.out.println("Ajout enfant done");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void SupprimerEnfant(String idEnf) {

        try {
            String requete = " DELETE FROM enfant where idEnfant = ? ";
            PreparedStatement pst2 = con.prepareStatement(requete);
            pst2.setString(1, idEnf);
            pst2.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Enfant DELETED");
    }
    
    public void modifierEnfant(String idEnfant, String nom, String prenom, String dateNaiss, String sexe, String nomgroup) {

        String requete5 = "UPDATE enfant SET nom = ?, prenom = ?  , dateNaiss = ?, sexe=? ,nomgroup=? WHERE idEnfant = ?";

        try {

            PreparedStatement pst2 = con.prepareStatement(requete5);
            pst2.setString(1, nom);
            pst2.setString(2, prenom); 
            pst2.setString(3, dateNaiss);
            pst2.setString(4, sexe);
             pst2.setString(5, nomgroup);
            pst2.setString(6, idEnfant);
            pst2.executeUpdate();
            System.out.println("Enfant updated");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void rechercherEnfant(String besoin, String caractere) {

        String requete = "select * from enfant where " + besoin + " LIKE '" + caractere + "%'";

        try {
            PreparedStatement pst2 = con.prepareStatement(requete);
            pst2.executeQuery();
            System.out.println("recherche done");

            ResultSet rs = pst2.executeQuery();

            while (rs.next()) {
                Enfant a = new Enfant();
                a.setIdEnfant(rs.getString(1));
                a.setNom(rs.getString(2));
                a.setPrenom(rs.getString(3));
                a.setDateNaiss(rs.getString(4));
                a.setSexe(rs.getString(5));
                 a.setNom_group(rs.getString(6));
                System.out.println("L'enfant numero " + a.getIdEnfant());
                System.out.println("Nom = " + a.getNom());
                System.out.println("Prenom = " + a.getPrenom());
                System.out.println("Date de naissance = " + a.getDateNaiss());
                System.out.println("Sexe = " + a.getSexe());
                 System.out.println("Group = " + a.getNom_group());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void trierEnfant(String o) {
        try {

            String requete2 = "SELECT * FROM enfant order by " + o;
            PreparedStatement pst = con.prepareStatement(requete2);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Enfant a = new Enfant();
                a.setIdEnfant(rs.getString(1));
                a.setNom(rs.getString(2));
                a.setPrenom(rs.getString(3));
                a.setDateNaiss(rs.getString(4));
                a.setSexe(rs.getString(5));
                 a.setNom_group(rs.getString(6));
                System.out.println(a);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    
         public List<Enfant> grouperEnfant(String o) throws SQLException{
        List<Enfant> arr=new ArrayList<>();
          ste=con.createStatement();
          ResultSet rs=ste.executeQuery("select * from enfant where nomgroup='"+o+"'");
      while (rs.next()) {                
               String idEnfant=rs.getString(1);
               String nom=rs.getString(2);
                String prenom=rs.getString(3);
                 String dateNaiss=rs.getString(4);
                  String sexe=rs.getString(5);
                  String nom_group=rs.getString(6);
               Enfant s=new Enfant(idEnfant, nom,prenom,dateNaiss,sexe,nom_group);
     arr.add(s);
     }
    return arr;
    }    
}
