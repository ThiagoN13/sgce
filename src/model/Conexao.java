/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;

/**
 *
 * @author thiago
 */
public class Conexao {
  
	public Connection getConnection() {
	     try {
	    	Class.forName("com.mysql.jdbc.Driver");
	         return (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/loja", "root", "");
	     } catch (Exception e) {
	    	 System.out.println("Erro ao conectar ao banco");
	         throw new RuntimeException(e);
	     }
	 }   
}