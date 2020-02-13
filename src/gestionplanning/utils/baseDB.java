/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionplanning.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;





public class baseDB {
     String url = "jdbc:mysql://localhost:3306/minimiracles";
     String login = "root";
     String pwd = "";
    public  static baseDB db;
    public Connection con;
    private baseDB() {
         try {
             con=DriverManager.getConnection(url, login, pwd);
             System.out.println("connexion etablie");
         } catch (SQLException ex) {
             System.out.println(ex);
         }
    }
    
    public Connection  getConnection()
    {
    return con;
    }     
    public static baseDB getInstance()
    {if(db==null)
        db=new baseDB();
    return db;
    }     
     
     
     
     
}
