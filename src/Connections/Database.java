/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connections;


 import java.sql.*;
import javax.swing.JOptionPane;
public class Database {
    Connection conn = null;
    public static Connection ConnectDatabase(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn  = DriverManager.getConnection("jdbc:mysql://localhost/user_registers","root","");
            return conn;
        } catch(Exception ex){
              System.out.println(ex.getMessage());
              return null;
        }
        
    }
}


