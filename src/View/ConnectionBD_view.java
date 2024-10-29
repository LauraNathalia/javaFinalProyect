/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.ConnectionBD_ctrl;
import java.awt.Cursor;
import static java.awt.Frame.HAND_CURSOR;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Laura Nathalia
 */

/*esta clase solicita la informacion de contrasena y usuario de mySQL del usuario admin*/
public class ConnectionBD_view extends JFrame{
    public JTextField JTusuario;
    public JPasswordField JPcontrasena;
    private JLabel JLusuario, JLcontrasena;
    public JButton aceptar;
    ConnectionBD_ctrl connectionBD_ctrl;
    
    public ConnectionBD_view()
    {
        super("Coffee & Milk");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        
        connectionBD_ctrl = new ConnectionBD_ctrl(this);
        
        JLusuario = new JLabel("Usuario de la conección a mySQL:");
        JLusuario.setBounds(20, 40, 200, 30);
        JTusuario = new JTextField();
        JTusuario.setBounds(40, 70, 200, 30);
        JTusuario.setCursor(new Cursor(HAND_CURSOR));
        add(JLusuario);
        add(JTusuario);
        
        JLcontrasena = new JLabel("Contraseña de la conección a mySQL:");
        JLcontrasena.setBounds(20, 120, 220, 30);
        JPcontrasena = new JPasswordField();
        JPcontrasena.setBounds(40, 150, 200, 30);
        JPcontrasena.setCursor(new Cursor(HAND_CURSOR));
        add(JLcontrasena);
        add(JPcontrasena);
        
        aceptar = new JButton("Aceptar");
        aceptar.setBounds(90, 200, 100, 20);
        aceptar.addActionListener(connectionBD_ctrl);
        add(aceptar);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        ConnectionBD_view ejecutar = new ConnectionBD_view();
    }
}
