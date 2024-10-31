/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ConnectionBD;
import View.ConnectionBD_view;
import java.awt.event.*;

/**
 *
 * @author Laura Nathalia
 */
public class ConnectionBD_ctrl implements ActionListener{
    public ConnectionBD_view connectionBD_view;
    
    public ConnectionBD_ctrl(ConnectionBD_view obj)
    {
        connectionBD_view = obj;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(connectionBD_view.aceptar))
        {
            String usuario = connectionBD_view.JTusuario.getText();
            String contrasena = new String(connectionBD_view.JPcontrasena.getPassword());
            ConnectionBD connectionBD = new ConnectionBD();
            connectionBD.connect();
            connectionBD_view.dispose();
        }
    }
    
}
