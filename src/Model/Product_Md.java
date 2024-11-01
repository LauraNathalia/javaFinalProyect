/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import static Model.ConnectionBD.connection;
import static Model.ConnectionBD.statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laura Nathalia
 */
public class Product_Md extends ConnectionBD{

    public Product_Md() {
    }
    public void agregarProducto(Product producto)//funcional
    {
        try {
            connect();
            String sql = "INSERT INTO productos (nombre, precio, ingredientesPrincipales, tipo, activo) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, producto.getNombre());
            preparedStatement.setLong(2, producto.getPrecio());
            preparedStatement.setString(3, producto.getIngredientesPrincipales());
            preparedStatement.setString(4, producto.getTipo());
            preparedStatement.setBoolean(5, producto.isActivo());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar producto: " + e);
        }
        finally
        {
            disconnect();
        }
    }
    
     public List<Product> listarProductos()//funcional
    {
        List<Product> results = new ArrayList<>();
        try {
            connect();
            String sql = "select * from productos";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while(resultSet.next())
            {
                Product producto = new Product(resultSet.getInt("ID"), resultSet.getString("nombre"), resultSet.getLong("precio"), resultSet.getString("ingredientesPrincipales"),resultSet.getString("tipo"), resultSet.getBoolean("activo"));
                results.add(producto);
            }
            
            resultSet.close();
            
        } 
        catch (SQLException e) {
            System.out.println("Error al listar productos: " + e);
        }
        finally
        {
            disconnect();
        }
        return results;
    }
    
     public Product buscarProducto(int ID)//funcional
    {
        //para hacer mas breve buscar el codigo se hará uso de la funcion listarProductos
        List productos = listarProductos();
        for (int i = 0; i < productos.size(); i++) {
            Product get = (Product) productos.get(i);
            if(get.getID()==ID)
            {
                return get;//se encontró el producto
            }
        }
        return null;//no se encontro el producto buscado con el id
    }
     
     public void eliminarProducto(int ID)//funcional
    {
        //eliminar por id
        //no se implementará la logica se si es null o no porque antes de que se ejecute la accion eliminar producto, el programa primero lo buscara, por lo que seria redundante
        try {
            connect();
            String sql = "delete from productos where ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);            
            preparedStatement.setInt(1, ID);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e);
        }
        finally
        {
            disconnect();
        }
    }
     
        public void editarProducto(Product producto)//
    {
        try {
            connect();
            String sql = "update clientes set nombre = ?, precio=?, ingredientesPrincipales=?, tipo=?, activo=? where ID=?";//la pk en producto no se puede cambiar
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, producto.getNombre());
            preparedStatement.setLong(2, producto.getPrecio());
            preparedStatement.setString(3, producto.getIngredientesPrincipales());
            preparedStatement.setString(4, producto.getTipo());
            preparedStatement.setBoolean(5, producto.isActivo());
            preparedStatement.setInt(6, producto.getID());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar producto: " + e);
        }
        finally
        {
            disconnect();
        }
    }
        
        
    public static void main(String[] args) {/*main de pruebass*/
        ConnectionBD ejecutar = new ConnectionBD();
        ejecutar.connect();
        
        Product_Md xx = new Product_Md(); // Pasa valores por defecto si es necesario
        Product producto = new Product("pan", 500, "arina, leche", "comida", true);
        
        xx.agregarProducto(producto);
        //System.out.println(buscar);
        
        /*int codigo = xx.generarCodigo();
        System.out.println("codigo:" + codigo);
        
        List<Administrador> lista = xx.listarAdmins();
        for (Administrador administrador : lista) {
            System.out.println(administrador);
        }
        
        int codigoABuscar = 11111; // El código que deseas buscar
        xx.eliminarAdmin(codigoABuscar);
        */
        
       // Administrador admin = new Administrador(11111, "hola", "2024/10/30", "laura", "nathalia","padilla", "castano", "hola@gmail.com");
       // xx.agregarAdmin(admin);
       // xx.eliminarAdmin(11111);
    }
}
