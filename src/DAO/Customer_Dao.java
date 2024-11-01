/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.ConnectionBD;
import Model.Customer;
import java.math.BigInteger;
import java.util.*;
import java.sql.*;

/**
 *
 * @author Laura Nathalia
 */
public class Customer_Dao extends ConnectionBD{

    public Customer_Dao() 
    {
    }
    
    private boolean verificarID(int id) //funcional
    {
        boolean existe = false;
        String sql = "SELECT COUNT(*) FROM clientes WHERE ID = ?"; 

        try {
            connect();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id); 

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                existe = resultSet.getInt(1) > 0; // Si el conteo es mayor a 0, el código existe
            }

            resultSet.close();
            preparedStatement.close(); 
        } catch (SQLException e) {
            System.err.println("Error al verificar el nuevo código: " + e);
        }

        return existe;
    }

    public int generarID() //funcional
    {
        Random random = new Random();
        int codigo;
        boolean existe;

        do {
            codigo = random.nextInt(100000); // genarar un id ramdom de 5 cifras
            existe = verificarID(codigo); //verificar que no exista
        } while (existe);

        return codigo;
    }
    
    public void agregarCliente(Customer cliente)//funcional
    {
        try {
            connect();
            String sql = "insert into clientes values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cliente.getID());
            preparedStatement.setString(2, cliente.getPrimerNombre());
            preparedStatement.setString(3, cliente.getSegundoNombre());
            preparedStatement.setString(4, cliente.getPrimerApellido());
            preparedStatement.setString(5, cliente.getSegundoApellido());
            preparedStatement.setLong(6, cliente.getTelefono().longValue());
            preparedStatement.setString(7, cliente.getCorreo());
            preparedStatement.setString(8, cliente.getContrasena());
            preparedStatement.setBoolean(9, cliente.isActivo());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar cliente: " + e);
        }
        finally
        {
            disconnect();
        }
    }
    
     public List<Customer> listarClientes()//funcional
    {
        List<Customer> results = new ArrayList<>();
        try {
            connect();
            String sql = "select * from clientes";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while(resultSet.next())
            {
                Customer cliente = new Customer(resultSet.getInt("ID"), resultSet.getString("primerNombre"), resultSet.getString("segundoNombre"), resultSet.getString("primerApellido"), resultSet.getString("segundoApellido"),  new BigInteger(resultSet.getString("telefono")), resultSet.getString("correo"), resultSet.getString("Contrasena"),resultSet.getBoolean("activo"));
                results.add(cliente);
            }
            
            resultSet.close();
            
        } 
        catch (SQLException e) {
            System.out.println("Error al listar clientes: " + e);
        }
        finally
        {
            disconnect();
        }
        return results;
    }
    
     public Customer buscarCliente(int ID)//funcional
    {
        //para hacer mas breve buscar el codigo se hará uso de la funcion listarClientes
        List clientes = listarClientes();
        for (int i = 0; i < clientes.size(); i++) {
            Customer get = (Customer) clientes.get(i);
            if(get.getID()==ID)
            {
                return get;//se encontró el cliente
            }
        }
        return null;//no se encontro el cliente buscado con el id
    }
     
     public void eliminarCliente(int ID)//funcional
    {
        //eliminar por id
        //no se implementará la logica se si es null o no porque antes de que se ejecute la accion eliminar cliente, el programa primero lo buscara, por lo que seria redundante
        try {
            connect();
            String sql = "delete from clientes where ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);            
            preparedStatement.setInt(1, ID);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e);
        }
        finally
        {
            disconnect();
        }
    }
     
        public void editarCliente(Customer cliente)//
    {
        try {
            connect();
            String sql = "update clientes set primerNombre = ?, segundoNombre=?, primerApellido=?, segundoApellido=?, telefono=?, correo=?, contrasena=?, activo=? where ID=?";//la pk en cliente no se puede cambiar
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cliente.getPrimerNombre());
            preparedStatement.setString(2, cliente.getSegundoNombre());
            preparedStatement.setString(3, cliente.getPrimerApellido());
            preparedStatement.setString(4, cliente.getSegundoApellido());
            preparedStatement.setLong(5, cliente.getTelefono().longValue());
            preparedStatement.setString(6, cliente.getCorreo());
            preparedStatement.setString(7, cliente.getContrasena());
            preparedStatement.setBoolean(8, cliente.isActivo());
            preparedStatement.setInt(9, cliente.getID());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente: " + e);
        }
        finally
        {
            disconnect();
        }
    }
}
