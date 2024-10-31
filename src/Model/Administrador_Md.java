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

import View.ConnectionBD_view;
import java.util.*;
import java.sql.*;

/**
 *
 * @author Laura Nathalia
**/
public class Administrador_Md extends ConnectionBD{
    public ConnectionBD_view connectionBD_view;

    public Administrador_Md(ConnectionBD_view connectionBD_view) 
    {
        this.connectionBD_view = connectionBD_view;
    }
    
    private void agregarAdmin(Administrador administrador)//funcional
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
    
    public List<Administrador> listarAdmins()//funcional
    {
        List<Administrador> results = new ArrayList<>();
        try {
            connect();
            String sql = "select * from administradores";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while(resultSet.next())
            {
                Administrador admin = new Administrador(resultSet.getInt("codigo"), resultSet.getString("contrasena"), resultSet.getString("fechaCreacion"), resultSet.getString("primerNombre"), resultSet.getString("segundoNombre"), resultSet.getString("primerApellido"), resultSet.getString("segundoApellido"), resultSet.getString("correo"));
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
    
    public Administrador buscarAdmin(int codigo)//funcional
    {
        //para hacer mas breve buscar el codigo se hará uso de la funcion listarAdmins
        List administradores = listarAdmins();
        for (int i = 0; i < administradores.size(); i++) {
            Administrador get = (Administrador) administradores.get(i);
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
        Administrador admin = buscarAdmin(codigo);
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
    
    public void editarAdmin(Cliente cliente)//
    {
        //solo hayun administrador en el sistema, (el cliente, comprador del programa, dueño del negocio, etc)
        //el metodo pide un obj. cliente y lo actualizara completo, pero a la hora de pedir actualizar admin se da la opcion
        //de cuales atributos actualizar, se cambian en el objeto, y se deja el resto igual.
        try {
            connect();
            String sql = "update clientes set primerNombre = ?, segundoNombre=?, primerApellido=?, segundoApellido=?, correo=?, contrasena=?, telefono=? where ID=?";//la pk en administrador sí se puede cambiar
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cliente.getPrimerNombre());
            preparedStatement.setString(2, cliente.getSegundoNombre());
            preparedStatement.setString(3, cliente.getPrimerApellido());
            preparedStatement.setString(4, cliente.getSegundoApellido());
            preparedStatement.setString(5, cliente.getCorreo());
            preparedStatement.setString(6, cliente.getContrasena());
            preparedStatement.setLong(7, cliente.getTelefono());
            preparedStatement.setLong(8, cliente.getID());
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
                System.out.println("error: "+e);
            }
        }
        Administrador_Md xx = new Administrador_Md(ejecutar); // Pasa valores por defecto si es necesario
        /*int codigo = xx.generarCodigo();
        System.out.println("codigo:" + codigo);
        
        List<Administrador> lista = xx.listarAdmins();
        for (Administrador administrador : lista) {
            System.out.println(administrador);
        }
        
        int codigoABuscar = 11111; // El código que deseas buscar
        xx.eliminarAdmin(codigoABuscar);
        
        Administrador admin = new Administrador(11111, "hola", "2024/10/30", "laura", "nathalia","padilla", "castano", "hola@gmail.com");
        xx.agregarAdmin(admin);
        xx.eliminarAdmin(11111);
        */
    }
}
