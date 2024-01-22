/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.utl.dsm.primerparcial.test;

import java.sql.Connection;
import java.sql.SQLException;
import org.utl.dsm.primerparcial.util.MySQLConnection;
/**
 *
 * @author alejandro
 */
public class ConnectionTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
    }
    
    static Connection testGetConnection() throws SQLException {
        MySQLConnection mySQLConnection = new MySQLConnection();
        try (Connection connection = mySQLConnection.getConnection()) {
            return connection;
        }
    }
    
}
