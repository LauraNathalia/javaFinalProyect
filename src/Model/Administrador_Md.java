/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.ConnectionBD_ctrl;
import View.ConnectionBD_view;
import java.util.*;
import java.sql.*;

/**
 *
 * @author Laura Nathalia
 */
public class Administrador_Md extends ConnectionBD{
    ConnectionBD_ctrl connectionBD_ctrl;
    public ConnectionBD_view connectionBD_view;

    public Administrador_Md(ConnectionBD_view connectionBD_view) {
        this.connectionBD_view = connectionBD_view;
    }
    
    private boolean verificarCodigo(int codigo) {
        boolean existe = false;
        String sql = "SELECT COUNT(*) FROM administradores WHERE codigo = ?"; 

        try {
            // Conéctate a la base de datos con las credenciales de la vista
            connect(connectionBD_view.JTusuario.getText(), new String(connectionBD_view.JPcontrasena.getPassword()));

            // Prepara la consulta
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, codigo); // Establece el parámetro en la consulta

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                existe = resultSet.getInt(1) > 0; // Si el conteo es mayor a 0, el código existe
            }

            resultSet.close();
            preparedStatement.close(); // Cierra el PreparedStatement
        } catch (SQLException e) {
            System.err.println("Error al verificar el nuevo código: " + e);
        }

        return existe;
    }

    private int generarCodigo() {
        Random random = new Random();
        int codigo;
        boolean existe;

        do {
            codigo = random.nextInt(100000); // genarar un codigo ramdom de 5 cifras
            existe = verificarCodigo(codigo); //verificar que no exista
        } while (existe);

        return codigo;
    }
    
    public List<Administrador> listarAdmins()
    {
        List<Administrador> results = new ArrayList<>();
        try {
            connect(connectionBD_view.JTusuario.getText(), new String(connectionBD_view.JPcontrasena.getPassword()));
            String sql = "select * from administradores";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while(resultSet.next())
            {
                Administrador admin = new Administrador(resultSet.getInt("codigo"), resultSet.getString("contrasena"), resultSet.getString("fechaCreacion"), resultSet.getString("primerNombre"), resultSet.getString("segundoNombre"), resultSet.getString("primerApellido"), resultSet.getString("segundoApellido"));
                results.add(admin);
            }
            
            resultSet.close();
            
        } 
        catch (SQLException e) {
            System.out.println("Error al consultar administrador: " + e);
        }
        finally
        {
            disconnect();
        }
        return results;
    }
    
    public Administrador buscarAdmin(int codigo)
    {
        //para hacer mas breve buscar el codigo se hará uso de la funcion listarAdmins
        List administradores = listarAdmins();
        for (int i = 0; i < administradores.size(); i++) {
            Administrador get = (Administrador) administradores.get(i);
            if(get.getCodigo()==codigo)
            {
                return get;
            }
        }
        return null;//no se encontro el admin buscado con el código
    }
    
    public static void main(String[] args) {/*main de pruebass*/
        ConnectionBD_view ejecutar = new ConnectionBD_view();
        while (true) {
            if (!ejecutar.isDisplayable()) { // Verifica si la ventana ha sido cerrada
                break; // Sale del bucle si la ventana se ha cerrado
            }
            // Agrega un pequeño retraso para no bloquear el hilo de la interfaz de usuario
            try {
                Thread.sleep(500); // Verifica cada medio segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Administrador_Md xx = new Administrador_Md(ejecutar); // Pasa valores por defecto si es necesario
        int codigo = xx.generarCodigo();
        System.out.println("codigo:" + codigo);
        
        List<Administrador> lista = xx.listarAdmins();
        for (Administrador administrador : lista) {
            System.out.println(administrador);
        }
    }
}