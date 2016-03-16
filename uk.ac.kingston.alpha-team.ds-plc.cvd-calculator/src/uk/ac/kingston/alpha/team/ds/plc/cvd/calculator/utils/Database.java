/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author k1317897
 */
public class Database {
    
    //Final static class attributes. 
    private static final String username = "k1234966";
    private static final String password = "database";
    private static final String url = "jdbc:oracle:thin:@kussdb.kingston.ac.uk:16450:ATPR";
    
    /**
     * Class default constructor.
     */
    public Database() 
    {
        
    }
    
    /**
     * Method of type Connection to establish a connection to the database. 
     * This method will be called each time a connection will need to be established before 
     * queries can be executed. 
     * @return 
     */
    public static Connection establishConnection() 
    {
       Connection connection = null;
            try
            {
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                connection = DriverManager.getConnection(url, username, password);
                return connection;
            } 
            catch(SQLException e) 
            { 
                JOptionPane.showMessageDialog(null,"Connection could not be established!");
            }
            return connection;
    }
    
    
    
}
