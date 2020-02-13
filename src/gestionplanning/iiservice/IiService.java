/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionplanning.iiservice;


import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author House
 */
public interface IiService<T> {
    void ajouter(T s) throws SQLException;

    List<T> readAll() throws SQLException;
}

