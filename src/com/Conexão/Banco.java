/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Conexão;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thiago.napoleao
 */
public class Banco {
    
      public Banco () {    } //Possibilita instancias
       public static Connection con = null;
 
      public static void Conectar() {
      System.out.println("Conectando ao banco...");
      try {
      Class.forName("com.mysql.jdbc.Driver");
      con =  (Connection) DriverManager.getConnection("jdbc:mysql://10.16.0.79/conf","default","123456");
      System.out.println("Conectado.");
       } catch (ClassNotFoundException ex) {
    System.out.println("Classe não encontrada, adicione o driver nas bibliotecas.");
    Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
    } catch(SQLException e) {
    System.out.println(e);
    throw new RuntimeException(e);
    }
 
   }
    
    
    
}
