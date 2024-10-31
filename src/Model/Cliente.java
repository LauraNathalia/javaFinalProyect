/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Laura Nathalia
 */
public class Cliente {
    int ID;
    String primerNombre, segundoNombre, primerApellido, segundoApellido, correo, contrasena;
    long telefono;
    boolean activo;

    public Cliente() {
    }

    public Cliente(int ID, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String correo, String contrasena, long telefono, boolean activo) {
        this.ID = ID;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.activo = activo;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getID() {
        return ID;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public long getTelefono() {
        return telefono;
    }

    public boolean isActivo() {
        return activo;
    }

    
    
}
