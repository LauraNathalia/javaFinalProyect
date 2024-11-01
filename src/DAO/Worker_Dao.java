/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.ConnectionBD;
import Model.Worker;
import static Model.ConnectionBD.*;
import java.math.BigInteger;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Laura Nathalia
 */
public class Worker_Dao extends ConnectionBD{

    public Worker_Dao() {
    }
    
    public void agregarTrabajador(Worker trabajador)//funcional
    {
        try {
            connect();
            String sql = "insert into trabajadores values (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, trabajador.getDNI().longValue());
            preparedStatement.setString(2, trabajador.getPrimerNombre());
            preparedStatement.setString(3, trabajador.getSegundoNombre());
            preparedStatement.setString(4, trabajador.getPrimerApellido());
            preparedStatement.setString(5, trabajador.getSegundoApellido());
            preparedStatement.setLong(6, trabajador.getTelefono().longValue());
            preparedStatement.setString(7, trabajador.getCorreo());
            preparedStatement.setString(8, trabajador.getContrasena());
            preparedStatement.setString(9, trabajador.getFechaNacimiento());
            preparedStatement.setLong(10, trabajador.getSueldo().longValue());
            preparedStatement.setBoolean(11, trabajador.isActivo());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar trabajador: " + e);
        }
        finally
        {
            disconnect();
        }
    }
    
     public List<Worker> listarTrabajadores()//funcional
    {
        List<Worker> results = new ArrayList<>();
        try {
            connect();
            String sql = "select * from trabajadores";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while(resultSet.next())
            {
                Worker trabajador = new Worker(new BigInteger(resultSet.getString("DNI")), resultSet.getString("primerNombre"), resultSet.getString("segundoNombre"), resultSet.getString("primerApellido"), resultSet.getString("segundoApellido"), new BigInteger(resultSet.getString("telefono")), resultSet.getString("correo"), resultSet.getString("contrasena"), resultSet.getString("fechaNacimiento"), new BigInteger(resultSet.getString("sueldo")), resultSet.getBoolean("activo"));
                results.add(trabajador);
            }
            
            resultSet.close();
            
        } 
        catch (SQLException e) {
            System.out.println("Error al listar trabajadores: " + e);
        }
        finally
        {
            disconnect();
        }
        return results;
    }
    
     public Worker buscarTrabajador(BigInteger DNI)//funcional
    {
        //para hacer mas breve buscar el dni se hará uso de la funcion listarTrabajadores
        List trabajadores = listarTrabajadores();
        for (int i = 0; i < trabajadores.size(); i++) {
            Worker get = (Worker) trabajadores.get(i);
            if(get.getDNI().equals(DNI))
            {
                return get;//se encontró el trabajador
            }
        }
        return null;//no se encontro el trabajador buscado con el dni
    }
     
     public void eliminarTrabajador(BigInteger DNI)//funcional
    {
        //eliminar por DNI
        //no se implementará la logica se si es null o no porque antes de que se ejecute la accion eliminar trabajador, el programa primero lo buscara, por lo que seria redundante
        try {
            connect();
            String sql = "delete from trabajadores where DNI = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);            
            preparedStatement.setLong(1, DNI.longValue());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar trabajador: " + e);
        }
        finally
        {
            disconnect();
        }
    }
     
        public void editarTrabajador(Worker trabajador)//
    {
        try {
            connect();
            String sql = "update trabajadores set primerNombre = ?,segundoNombre=?, primerApellido=?, segundoApellido=?, telefono=?, correo=?, contrasena=?, fechaNacimiento=?, sueldo=?, activo=? where DNI=?";//la pk en trabajador no se puede cambiar
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, trabajador.getPrimerNombre());
            preparedStatement.setString(2, trabajador.getSegundoNombre());
            preparedStatement.setString(3, trabajador.getPrimerApellido());
            preparedStatement.setString(4, trabajador.getSegundoApellido());
            preparedStatement.setLong(5, trabajador.getTelefono().longValue());
            preparedStatement.setString(6, trabajador.getCorreo());
            preparedStatement.setString(7, trabajador.getContrasena());
            preparedStatement.setString(8, trabajador.getFechaNacimiento());
            preparedStatement.setLong(9, trabajador.getSueldo().longValue());
            preparedStatement.setBoolean(10, trabajador.isActivo());
            preparedStatement.setLong(11, trabajador.getDNI().longValue());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar trabajador: " + e);
        }
        finally
        {
            disconnect();
        }
    }
}
