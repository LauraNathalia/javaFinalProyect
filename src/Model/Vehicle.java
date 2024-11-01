/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Laura Nathalia
 */
public class Vehicle {
    String matricula, modelo, tipo, marca;
    boolean disponible, activo; //diferencia: activo es si el vehiculo hace o ya no hace parte de la empresa, disponible es para saber si está o no ocupado

    public Vehicle() {
    }

    public Vehicle(String matricula, String modelo, String tipo, String marca, boolean disponible, boolean activo) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.tipo = tipo;
        this.marca = marca;
        this.disponible = disponible;
        this.activo = activo;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMarca() {
        return marca;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public boolean isActivo() {
        return activo;
    }
    
    
}
