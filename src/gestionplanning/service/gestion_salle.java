/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionplanning.service;

import gestionplanning.iiservice.IiService;
import gestionplanning.entite.Salle;
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
public  class gestion_salle implements IiService<Salle>{
     private Connection con;
    private Statement ste;

    public gestion_salle() {
        con = baseDB.getInstance().getConnection();


}
 @Override
    public void ajouter(Salle s) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `minimiracles`.`salles` (`num_salle`,`capacite`) VALUES ('" + s.getnum_salle() +"','" + s.getcapacite() + "');";
        ste.executeUpdate(requeteInsert);
    }
    
    
    
    
    public void delete(int nums) throws SQLException {
     ste = con.createStatement();
     PreparedStatement pre=con.prepareStatement("delete from salles where  num_salle=?");
      pre.setInt(1, nums);
    pre.executeUpdate();
    }
    
  
     
    public void update(Salle s,int nums) throws SQLException{
	ste = con.createStatement();
	PreparedStatement pre=con.prepareStatement("update salles set num_salle= '"+s.getnum_salle()+"',capacite='"+s.getcapacite()+"' where num_salle=? ");
        pre.setInt(1,nums);
    pre.executeUpdate();
        
	
}
    
 @Override
    public List<Salle> readAll() throws SQLException {
    List<Salle> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from salles ");
     while (rs.next()) {                
               int num_salle=rs.getInt(1);
               int capacite=rs.getInt(2);
               Salle s=new Salle(num_salle, capacite);
     arr.add(s);
     }
    return arr;
    }
    
   
    public List<Salle> orderread(String o) throws SQLException {
    List<Salle> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from salles order by "+o);
     while (rs.next()) {                
               int num_salle=rs.getInt(1);
               int capacite=rs.getInt(2);
               Salle s=new Salle(num_salle, capacite);
     arr.add(s);
     }
    return arr;
    }
 
    public List<Salle> recherchersalle(int num) throws SQLException{
        List<Salle> arr=new ArrayList<>();
          ste=con.createStatement();
          ResultSet rs=ste.executeQuery("select * from salles where num_salle='"+num+"'");
      while (rs.next()) {                
               int num_salle=rs.getInt(1);
               int capacite=rs.getInt(2);
               Salle s=new Salle(num_salle, capacite);
     arr.add(s);
     }
    return arr;
    }    
        
}

