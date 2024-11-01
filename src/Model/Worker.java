/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.math.BigInteger;//para el dni, telefono y sueldo

/**
 *
 * @author Laura Nathalia
 */
public class Worker {
    BigInteger DNI, telefono, sueldo;
    String primerNombre, segundoNombre, primerApellido, segundoApellido, correo, contrasena, fechaNacimiento;
    boolean activo;

    public Worker() {
    }

    public Worker(BigInteger DNI, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, BigInteger telefono, String correo, String contrasena, String fechaNacimiento, BigInteger sueldo, boolean activo) {
        this.DNI = DNI;
        this.telefono = telefono;
        this.sueldo = sueldo;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.fechaNacimiento = fechaNacimiento;
        this.activo = activo;
    }

    public void setDNI(BigInteger DNI) {
        this.DNI = DNI;
    }

    public void setTelefono(BigInteger telefono) {
        this.telefono = telefono;
    }

    public void setSueldo(BigInteger sueldo) {
        this.sueldo = sueldo;
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

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public BigInteger getDNI() {
        return DNI;
    }

    public BigInteger getTelefono() {
        return telefono;
    }

    public BigInteger getSueldo() {
        return sueldo;
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public boolean isActivo() {
        return activo;
    }

    @Override
    public String toString() {
        return "Worker{" + "DNI=" + DNI + ", telefono=" + telefono + ", sueldo=" + sueldo + ", primerNombre=" + primerNombre + ", segundoNombre=" + segundoNombre + ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + ", correo=" + correo + ", contrasena=" + contrasena + ", fechaNacimiento=" + fechaNacimiento + ", activo=" + activo + '}';
    }
    
    
}
