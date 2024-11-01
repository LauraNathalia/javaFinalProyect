/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
Nombre: Laura Nathalia Padilla Castaño
Código: 202357635
Nombre del programa: Coffee & Milk
Funcion de la clase:
    la presente clase implementa las funciones de las acciones que se pueden realizar en la entidad administrador. 
    a la hora de agregar el administrador, esta accion solo sera realizada por el programador, quien le brindara acceso
    al administrador de manejar su programa. por lo tanto este metodo de agregar administrador solo lo podra manejar el programador.
    en otras palabras programador creara admin en la bd y admin inicia sesion en el programa con los datos que le proporcione este
*/

package Model;

import java.util.*;
import java.sql.*;

/**
 *
 * @author Laura Nathalia
**/
public class Administrator_Md extends ConnectionBD{

    public Administrator_Md() 
    {
    }
    
    private void agregarAdmin(Administrator administrador)//funcional
    {
        try {
            connect();
            String sql = "insert into administradores values (?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, administrador.getCodigo());
            preparedStatement.setString(2, administrador.getContrasena());
            preparedStatement.setString(3, administrador.getFechaCreacion());
            preparedStatement.setString(4, administrador.getPrimerNombre());
            preparedStatement.setString(5, administrador.getSegundoNombre());
            preparedStatement.setString(6, administrador.getPrimerApellido());
            preparedStatement.setString(7, administrador.getSegundoApellido());
            preparedStatement.setString(8, administrador.getCorreo());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar administrador: " + e);
        }
        finally
        {
            disconnect();
        }
    }
    
    public List<Administrator> listarAdmins()//funcional
    {
        List<Administrator> results = new ArrayList<>();
        try {
            connect();
            String sql = "select * from administradores";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while(resultSet.next())
            {
                Administrator admin = new Administrator(resultSet.getInt("codigo"), resultSet.getString("contrasena"), resultSet.getString("fechaCreacion"), resultSet.getString("primerNombre"), resultSet.getString("segundoNombre"), resultSet.getString("primerApellido"), resultSet.getString("segundoApellido"), resultSet.getString("correo"));
                results.add(admin);
            }
            
            resultSet.close();
            
        } 
        catch (SQLException e) {
            System.out.println("Error al listar administradores: " + e);
        }
        finally
        {
            disconnect();
        }
        return results;
    }
    
    public Administrator buscarAdmin(int codigo)//funcional
    {
        //para hacer mas breve buscar el codigo se hará uso de la funcion listarAdmins
        List administradores = listarAdmins();
        for (int i = 0; i < administradores.size(); i++) {
            Administrator get = (Administrator) administradores.get(i);
            if(get.getCodigo()==codigo)
            {
                return get;//se encontró el administrador
            }
        }
        return null;//no se encontro el admin buscado con el código
    }
    
    private void eliminarAdmin(int codigo)//funcional
    {
        //eliminar por codigo
        //parahacer mas breve eliminar se buscara el admin con la funcion buscar primero:
        Administrator admin = buscarAdmin(codigo);
        //no se implementará la logica se si es null o no porque antes de que se ejecute la accion eliminar admin, el programa primero lo buscara, por lo que seria redundante
        try {
            connect();
            String sql = "delete from administradores where codigo = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);            
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar administrador: " + e);
        }
        finally
        {
            disconnect();
        }
    }
    
    public void editarAdmin(Administrator admin)//
    {
        //solo hayun administrador en el sistema, (el cliente, comprador del programa, dueño del negocio, etc)
        //el metodo pide un obj. cliente y lo actualizara completo, pero a la hora de pedir actualizar admin se da la opcion
        //de cuales atributos actualizar, se cambian en el objeto, y se deja el resto igual.
        try {
            connect();
            String sql = "update administradores set contrasena=?,fechaCreacion=?,primerNombre = ?, segundoNombre=?, primerApellido=?, segundoApellido=?, correo=? where codigo=?";//la pk en administrador no puede cambiar
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, admin.getContrasena());
            preparedStatement.setString(2, admin.getFechaCreacion());
            preparedStatement.setString(3, admin.getPrimerNombre());
            preparedStatement.setString(4, admin.getSegundoNombre());
            preparedStatement.setString(5, admin.getPrimerApellido());
            preparedStatement.setString(6, admin.getSegundoApellido());
            preparedStatement.setString(7, admin.getCorreo());
            preparedStatement.setInt(8, admin.getCodigo());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar administrador : " + e);
        }
        finally
        {
            disconnect();
        }
    
    }
}
