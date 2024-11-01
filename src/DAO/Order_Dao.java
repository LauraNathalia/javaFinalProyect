/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.ConnectionBD;
import Model.Order;
import static Model.ConnectionBD.connection;
import static Model.ConnectionBD.statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Laura Nathalia
 */
public class Order_Dao extends ConnectionBD{
    private Random random = new Random(); 

    private boolean verificarCodigo(String codigo) //funcional
    {
        boolean existe = false;
        String sql = "SELECT COUNT(*) FROM pedidos WHERE codigo = ?"; 

        try {
            connect();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, codigo); 

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
    
    public String generarCodigo() 
    {
        //el codigo sigue la secuencia: 1 letra, 2 numeros, 2 letras, 5 numeros, un total de 10caracteres
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "0123456789";
        StringBuilder sb = new StringBuilder();
        boolean existe;
        do
        {
            sb.append(letras.charAt(random.nextInt(letras.length())));
            for (int i = 0; i < 2; i++) {
                sb.append(numeros.charAt(random.nextInt(numeros.length())));
            }
            for (int i = 0; i < 2; i++) {
                sb.append(letras.charAt(random.nextInt(letras.length())));
            }
            for (int i = 0; i < 5; i++) {
                sb.append(numeros.charAt(random.nextInt(numeros.length())));
            }
            existe = verificarCodigo(sb.toString());
        }while(existe);
        return sb.toString();
    }
    
    public void agregarPedido(Order pedido)//funcional
    {
        try {
            connect();
            String sql = "insert into pedidos values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, pedido.getCodigo());
            preparedStatement.setString(2, pedido.getFechaPedido());
            preparedStatement.setString(3, pedido.getNomenclaturaDir());
            preparedStatement.setString(4, pedido.getCalleDir());
            preparedStatement.setString(5, pedido.getCarreraDir());
            preparedStatement.setString(6, pedido.getBarrioDir());
            preparedStatement.setString(7, pedido.getEstado());
            preparedStatement.setLong(8, pedido.getTotal());
            preparedStatement.setString(9, pedido.getMetodoPago());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar pedido: " + e);
        }
        finally
        {
            disconnect();
        }
    }
    
     public List<Order> listarPedidos()//funcional
    {
        List<Order> results = new ArrayList<>();
        try {
            connect();
            String sql = "select * from pedidos";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while(resultSet.next())
            {
                Order pedido = new Order(resultSet.getString("codigo"), resultSet.getString("fechaDePedido"), resultSet.getString("nomenclaturaDir"), resultSet.getString("calleDir"), resultSet.getString("carreraDir"), resultSet.getString("barrioDir"), resultSet.getString("estado"), resultSet.getLong("total"), resultSet.getString("metodoPago"));
                results.add(pedido);
            }
            
            resultSet.close();
            
        } 
        catch (SQLException e) {
            System.out.println("Error al listar pedidos: " + e);
        }
        finally
        {
            disconnect();
        }
        return results;
    }
    
     public Order buscarPedido(String codigo)//funcional
    {
        //para hacer mas breve buscar el codigo se hará uso de la funcion listarPedido
        List pedidos = listarPedidos();
        for (int i = 0; i < pedidos.size(); i++) {
            Order get = (Order) pedidos.get(i);
            if (get.getCodigo().equals(codigo)) {
                return get;//se encontro pedido
            }

        }
        return null;//no se encontro el pedido buscado con el codigo
    }
     
     public void eliminarPedido(String codigo)//funcional
    {
        //eliminar por codigo
        //no se implementará la logica se si es null o no porque antes de que se ejecute la accion eliminar pedido, el programa primero lo buscara, por lo que seria redundante
        try {
            connect();
            String sql = "delete from pedidos where codigo = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);            
            preparedStatement.setString(1, codigo);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar pedido: " + e);
        }
        finally
        {
            disconnect();
        }
    }
     
        public void editarPedido(Order pedido)//
    {
        try {
            connect();
            String sql = "update pedidos set fechaDePedido=?, nomenclaturaDir=?, calleDir=?, carreraDir=?, barrioDir=?, estado=?, total=?, metodoPago=? where codigo=?";//la pk en pedido no se puede cambiar
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, pedido.getFechaPedido());
            preparedStatement.setString(2, pedido.getNomenclaturaDir());
            preparedStatement.setString(3, pedido.getCalleDir());
            preparedStatement.setString(4, pedido.getCarreraDir());
            preparedStatement.setString(5, pedido.getBarrioDir());
            preparedStatement.setString(6, pedido.getEstado());
            preparedStatement.setLong(7, pedido.getTotal());
            preparedStatement.setString(8, pedido.getMetodoPago());
            preparedStatement.setString(9, pedido.getCodigo());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar pedido: " + e);
        }
        finally
        {
            disconnect();
        }
    
    }
    
}
