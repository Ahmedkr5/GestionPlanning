/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionplanning.service;

import gestionplanning.iiservice.IiService;
import gestionplanning.entite.Emploi;
import gestionplanning.utils.baseDB;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.sql.*;
/**
 *
 * @author Darius
 */
public class gestion_emploi implements IiService<Emploi>{
     private Connection con;
    private Statement ste;

    public gestion_emploi() {
        con = baseDB.getInstance().getConnection();


    }
    
    @Override
    public void ajouter(Emploi e) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `minimiracles`.`emplois` (`num_emploi`,`jour`,`heure_deb`,`heure_fin`,`nb_heures`) VALUES (NULL, '" + e.getJour() +"','" + e.getHeure_deb() + "','" + e.getHeure_fin() + "','" + e.getNb_heures() + "');";
        ste.executeUpdate(requeteInsert);
    }
     public void delete(int nums) throws SQLException {
     ste = con.createStatement();
     PreparedStatement pre=con.prepareStatement("delete from emplois where  num_emploi=?");
      pre.setInt(1, nums);
    pre.executeUpdate();
    }
     
      public void update(Emploi e,int nums) throws SQLException{
	ste = con.createStatement();
	PreparedStatement pre=con.prepareStatement("update emplois set jour= '"+e.getJour()+"',heure_deb='"+e.getHeure_deb()+"',heure_fin='"+e.getHeure_fin()+"',nb_heures='"+e.getNb_heures()+"' where num_emploi=? ");
        pre.setInt(1,nums);
    pre.executeUpdate();
        
	
}
    @Override
    public List<Emploi> readAll() throws SQLException {
    List<Emploi> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from `minimiracles`.`emplois`");
     while (rs.next()) {                
               int num_emploi=rs.getInt(1);
               String jour=rs.getString(2);
                int heure_deb=rs.getInt(3);
                 int heure_fin=rs.getInt(4);
                  int nb_heures=rs.getInt(5);
               Emploi s=new Emploi(num_emploi, jour,heure_deb,heure_fin,nb_heures);
     arr.add(s);
     }
    return arr;
    }
    
    public List<Emploi> orderread(String o) throws SQLException {
    List<Emploi> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from emplois order by "+o);
     while (rs.next()) {                
              int num_emploi=rs.getInt(1);
               String jour=rs.getString(2);
                int heure_deb=rs.getInt(3);
                 int heure_fin=rs.getInt(4);
                  int nb_heures=rs.getInt(5);
               Emploi s=new Emploi(num_emploi, jour,heure_deb,heure_fin,nb_heures);
     arr.add(s);
     }
    return arr;
    }
     public List<Emploi> rechercheremploi(String besoin, String caractere) throws SQLException{
        List<Emploi> arr=new ArrayList<>();
          ste=con.createStatement();
          ResultSet rs=ste.executeQuery("select * from emplois where " + besoin + " LIKE '" + caractere + "%'");
      while (rs.next()) {                
               int num_emploi=rs.getInt(1);
               String jour=rs.getString(2);
                int heure_deb=rs.getInt(3);
                 int heure_fin=rs.getInt(4);
                  int nb_heures=rs.getInt(5);
               Emploi s=new Emploi(num_emploi, jour,heure_deb,heure_fin,nb_heures);
     arr.add(s);
     }
    return arr;
    }    
    
}
