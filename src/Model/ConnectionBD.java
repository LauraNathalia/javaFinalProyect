/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Laura Nathalia
 */
public class ConnectionBD {
    public static Connection connection;
    public static Statement statement;

    public ConnectionBD() {
    }
    
    
    public void connect(String usuario, String contrasena){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/proyectofinal", usuario,contrasena);
            statement = connection.createStatement();
            System.out.println("Conectado...");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            System.err.println("Error de conexión a la base de datos: " + e);
        }
    }
    
    public void disconnect()
    {
        try {
            if(statement != null)
            {
                statement.close();
            }
            if(connection != null)
            {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Error de desconexión de la base de datos: " + e);
        }
    }
}