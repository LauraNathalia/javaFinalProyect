/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.ConnectionBD;
import static Model.ConnectionBD.connection;
import static Model.ConnectionBD.statement;
import Model.Vehicle;
import Model.Worker;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laura Nathalia
 */
public class Vehicle_Dao extends ConnectionBD{

    public Vehicle_Dao() {
    }
    
    public void agregarVehiculo(Vehicle vehiculo)//funcional
    {
        try {
            connect();
            String sql = "insert into vehiculos values (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, vehiculo.getMatricula());
            preparedStatement.setString(2, vehiculo.getModelo());
            preparedStatement.setString(3, vehiculo.getTipo());
            preparedStatement.setString(4, vehiculo.getMarca());
            preparedStatement.setBoolean(5, vehiculo.isDisponible());
            preparedStatement.setBoolean(6, vehiculo.isActivo());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar vehiculo: " + e);
        }
        finally
        {
            disconnect();
        }
    }
    
     public List<Vehicle> listarVehiculos()//funcional
    {
        List<Vehicle> results = new ArrayList<>();
        try {
            connect();
            String sql = "select * from vehiculos";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while(resultSet.next())
            {
                Vehicle vehiculo = new Vehicle(resultSet.getString("matricula"), resultSet.getString("modelo"), resultSet.getString("tipo"), resultSet.getString("marca"), resultSet.getBoolean("disponible"), resultSet.getBoolean("activo"));
                results.add(vehiculo);
            }
            
            resultSet.close();
            
        } 
        catch (SQLException e) {
            System.out.println("Error al listar vehiculos: " + e);
        }
        finally
        {
            disconnect();
        }
        return results;
    }
    
     public Vehicle buscarVehiculo(String matricula)//funcional
    {
        //para hacer mas breve buscar la matricula se hará uso de la funcion listarVehiculos
        List vehiculos = listarVehiculos();
        for (int i = 0; i < vehiculos.size(); i++) {
            Vehicle get = (Vehicle) vehiculos.get(i);
            if(get.getMatricula().equals(matricula))
            {
                return get;//se encontró el vehiculo
            }
        }
        return null;//no se encontro el vehiculo buscado con la matricula
    }
     
     public void eliminarVehiculo(String matricula)//funcional
    {
        //eliminar por matricula
        //no se implementará la logica se si es null o no porque antes de que se ejecute la accion eliminar vehiculo, el programa primero lo buscara, por lo que seria redundante
        try {
            connect();
            String sql = "delete from vehiculos where matricula = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);            
            preparedStatement.setString(1, matricula);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar vehiculo: " + e);
        }
        finally
        {
            disconnect();
        }
    }
     
    public void editarVehiculo(Vehicle vehiculo)//
    {
        try {
            connect();
            String sql = "update vehiculos set modelo=?, tipo=?, marca=?, disponible=?, activo=? where matricula=?";//la matricula no se puede emodificar
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, vehiculo.getModelo());
            preparedStatement.setString(2, vehiculo.getTipo());
            preparedStatement.setString(3, vehiculo.getMarca());
            preparedStatement.setBoolean(4, vehiculo.isDisponible());
            preparedStatement.setBoolean(5, vehiculo.isActivo());
            preparedStatement.setString(6, vehiculo.getMatricula());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar vehiculo: " + e);
        }
        finally
        {
            disconnect();
        }
    }
       
}
