/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belajarjava;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Rakha Agung trimanda
 */
public class Koneksi {
    private Connection con;
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/artikata"; // nama database
    private String username = "root";// user name dbms
    private String password = "";// pswd dbms
    
    public Connection logOn(){
        try{
            //load JDBC Driver
            Class.forName(driver).newInstance();
            //Buat object Connection
            con = DriverManager.getConnection(url, username, password);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return con;
    }
    
    public void logOff(){
        try{
            //Tutup Koneksi
            con.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}