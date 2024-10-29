/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Laura Nathalia
 */
public class Administrador {
    int codigo;
    String contrasena, fechaCreacion, primerNombre, segundoNombre, primerApellido, segundoApellido;
    
    public Administrador(int codigo, String contrasena, String fechaCreacion, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido) {
        this.codigo = codigo;
        this.contrasena = contrasena;
        this.fechaCreacion = fechaCreacion;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
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

    public int getCodigo() {
        return codigo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
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

    @Override
    public String toString() {
        return "Administrador{" + "codigo=" + codigo + ", contrasena=" + contrasena + ", fechaCreacion=" + fechaCreacion + ", primerNombre=" + primerNombre + ", segundoNombre=" + segundoNombre + ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + '}';
    }
    
}
