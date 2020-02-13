/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionplanning.test;

import gestionplanning.entite.Emploi;
import gestionplanning.entite.Enfant;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.sql.*;
import gestionplanning.entite.Salle;
import gestionplanning.service.EnfantCrud;
import gestionplanning.service.gestion_emploi;
import gestionplanning.utils.baseDB;
import gestionplanning.service.gestion_salle;
import java.util.Scanner;
/**
 *
 * @author Darius
 */
public class GestionPlanning {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
       
         gestion_salle S= new gestion_salle();
         gestion_emploi Er = new gestion_emploi();
          EnfantCrud Enf = new EnfantCrud();
        boolean var=true;
        while(var){
        
       
        System.out.println("***************Gestion Planning*******************");
        
        System.out.println("Menu Principal");
        System.out.println("1- Gestion des salles");
        System.out.println("2- Gestion des emplois");
        System.out.println("3- consulter les groupes");
        System.out.println("4- Quitter");
        System.out.println("Choix :");
        
        Scanner scanner= new Scanner (System.in);
        
        int choix =scanner.nextInt();
        
        
       switch (choix){
           case 1:
               
               boolean var1=true;
               while(var1){
               
               System.out.println("***************Gestion Salles*******************");
        System.out.println("1- Ajouter Salle");
        System.out.println("2- Modifier Salle");
        System.out.println("3- Supprimer Salle");
        System.out.println("4- Afficher les salles");
        System.out.println("5- rechercher une salle");
        System.out.println("6- Trier les salles");
         System.out.println("7- Quitter");
          int choixSalle =scanner.nextInt();
        System.out.println("Choix :");
        switch(choixSalle){
            case 1:
               
                System.out.println("Ajouter salle");
                System.out.println("numSalle:");
                int numSalle =scanner.nextInt();
                System.out.println("Capacite:");
                  int Capacite =scanner.nextInt();
                Salle s1=new Salle(numSalle,Capacite);
                S.ajouter(s1);
                System.out.println("Salle Ajoutée:");
                break;
            case 2:
                System.out.println("Modifier salle");
                System.out.println("Entrer le numero de la salle a modifier:");
                System.out.println("numero:");
                int num=scanner.nextInt();
                 System.out.println("Entrer les information a modifer:");
                 System.out.println("numero:");
                  int num2=scanner.nextInt();
                  System.out.println("capacite:");
                   int cap=scanner.nextInt();
                Salle s2=new Salle(num2,cap);
                    S.update(s2,num);
                    System.out.println("Salle modifiée ");
                break;
            case 3:
                System.out.println("Supprimer salle");
                System.out.println("Entrer le numSalle:");
                int numS=scanner.nextInt();
                S.delete(numS);
                System.out.println("Salle supprimée");
                break;
            case 4:
                try{
                   List<Salle> list = S.readAll();
            System.out.println(list);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
                break;
            case 5:
                System.out.println("Entrer le numero de salle a rechercher:");
                   int rechs = scanner.nextInt();
                try {           
            List<Salle> list = S.recherchersalle(rechs);
            System.out.println(list);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
                break;
            case 6:
                System.out.println("trier les salles selon?");
                String rep = scanner.next();
                   try {        
            List<Salle> list = S.orderread(rep);
            System.out.println(list);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
                
                break;
            case 7:
                 System.out.println("***************Bye*******************");
                 var1=false;
                 var=true;
                break;
            default:
                 System.out.println("choix invalide");
                break;
        
                
        }}
               break;
           case 2:
               
                boolean var2=true;
               while(var2){
               System.out.println("***************Gestion Emplois*******************");
               System.out.println("1- Ajouter Emploi");
        System.out.println("2- Modifier Emploi");
        System.out.println("3- Supprimer Emploi");
        System.out.println("4- Afficher les emplois");
        System.out.println("5- rechercher un emploi");
        System.out.println("6- Trier les emplois");
         System.out.println("7- Quitter");
           int choixEmploi=scanner.nextInt();
        System.out.println("Choix :");
          switch(choixEmploi){
            case 1:
                  System.out.println("Ajouter Emploi");
                System.out.println("jour:");
                String jour =scanner.next();
                System.out.println("heure_deb:");
                  int hd =scanner.nextInt();
                  System.out.println("heure_fin:");
                  int hf =scanner.nextInt();
                   System.out.println("nb_heures:");
                   int nbh =scanner.nextInt();
                 Emploi e1=new Emploi(jour,hd,hf,nbh);
                  Er.ajouter(e1);
                System.out.println("Emploi Ajoutée:");
                break;
            case 2: System.out.println("Modifier Emploi");
                System.out.println("Entrer le numero de l emploi a modifier:");
                System.out.println("numero:");
                int numE=scanner.nextInt();
                 System.out.println("Entrer les information a modifer:");
                 System.out.println("jour:");
                  String jour1=scanner.next();
                  System.out.println("heure debut:");
                   int hd1=scanner.nextInt();
                   System.out.println("heure fin:");
                   int hf1=scanner.nextInt();
                   System.out.println("nombre d heures:");
                   int nbh1=scanner.nextInt();
               Emploi e2=new Emploi(jour1,hd1,hf1,nbh1);
                    Er.update(e2,numE);
                    System.out.println("Emploi modifiée ");
                    
                break;
                
            case 3:
                System.out.println("Supprimer Emploi");
                System.out.println("Entrer le numEmploi:");
                int numEs=scanner.nextInt();
                Er.delete(numEs);
                System.out.println("Emploi supprimée");
                
                break;
            case 4:
                try{
      List<Emploi> list = Er.readAll();
      System.out.println(list);
       } catch (SQLException ex) {
     System.out.println(ex);}
                break;
            case 5: 
                System.out.println(" rechercher selon? :");
                   String rep2 = scanner.next();
                System.out.println(" valeur? :");   
                String re = scanner.next();
                try {
            List<Emploi> list = Er.rechercheremploi(rep2,re);
            System.out.println(list);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
                break;
            case 6:
                 System.out.println("trier les emplois selon?");
                String rep3 = scanner.next();
                      try {
            List<Emploi> list = Er.orderread(rep3);
            System.out.println(list);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

                break;
            case 7:
                 System.out.println("***************Bye*******************");
                 var2=false;
                 var=true;
                break;
            default:
                 System.out.println("choix invalide");
                break;
        
                
        }}
               break;
           case 3:
               boolean var3=true;
               while(var3){
                
               System.out.println("***************Liste des groupes*******************");
                System.out.println("1-consulter la liste des groupes");
                 System.out.println("2- Quitter");
                  int choixGroup =scanner.nextInt();
        System.out.println("Choix :");
        switch(choixGroup){
            case 1: 
                System.out.println("donner le nom du group");
                String nameg = scanner.next();
                      try {
         
            List<Enfant> list = Enf.grouperEnfant(nameg);
            System.out.println(list);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
                break;
            case 2:
                System.out.println("***************Bye*******************");
                var3=false;
                var=true;
                break;
        }}
               break;
           case 4:
               System.out.println("***************Bye*******************");
                System.exit(0);
               break;
           default:
               System.out.println("choix invalide");
               break;
       }
       
//gestion_salle S= new gestion_salle();
//        
//        Salle s1=new Salle(1,30);
       // Salle s2=new Salle(2,40);
       // Salle s3=new Salle(2,40);
          //try {
//         
           // S.ajouter(s2);    
           // S.ajouter(s1);
            //  S.ajouter(s3);
             // S.update(s3,3);
             // S.delete(8);
//            List<Salle> list = S.readAll();
//            System.out.println(list);
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//          
//          //trier
//          try {
//         
//            List<Salle> list = S.orderread();
//            System.out.println(list);
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }

//           try {
//         
//            List<Salle> list = S.recherchersalle(28);
//            System.out.println(list);
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
          
       
  //-------------------------------------------------------------------------//      
        
//  gestion_emploi Er = new gestion_emploi();
//        Emploi e1=new Emploi("lundi",8,16,8);
//        Emploi e2=new Emploi("mardi",10,14,4);
//        Emploi e3=new Emploi("jeudi",10,12,2);
//        
//        try {
//         
//              Er.ajouter(e1);
//               Er.ajouter(e2);      
//              Er.ajouter(e3);
//              Er.update(e3,3);
//              Er.delete(2);
//      List<Emploi> list = Er.readAll();
//      System.out.println(list);
//       } catch (SQLException ex) {
//     System.out.println(ex);
//   }
//    
//          
//          //trier
//          try {
//         
//            List<Emploi> list = Er.orderread("num_emploi");
//            System.out.println(list);
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }

//           try {
//         
//            List<Emploi> list = Er.rechercheremploi(4);
//            System.out.println(list);
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }

       //----------------grouper les enfants--------------//
//  EnfantCrud Enf = new EnfantCrud();
// 
//        try {
//         
//            List<Enfant> list = Enf.grouperEnfant("G03");
//            System.out.println(list);
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//        
        
        
        
        
        
        
        
    } }
    }
    

