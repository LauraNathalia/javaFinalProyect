/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Laura Nathalia
 */
public class Product {
    int ID;
    long precio;
    String nombre, ingredientesPrincipales, tipo;
    boolean activo; //si se encuentra disponible

    public Product() {
    }

    public Product(String nombre,long precio, String ingredientesPrincipales, String tipo, boolean activo) {//este constructor no tiene id, ya que seráusado para agregar productos (el id es autoincrementable en la BD)
        this.precio = precio;
        this.nombre = nombre;
        this.ingredientesPrincipales = ingredientesPrincipales;
        this.tipo = tipo;
        this.activo = activo;
    }
//este constructor sie tiene id para realizar otras funciones como listar:
    public Product(int ID, String nombre, long precio, String ingredientesPrincipales, String tipo, boolean activo) {
        this.ID = ID;
        this.precio = precio;
        this.nombre = nombre;
        this.ingredientesPrincipales = ingredientesPrincipales;
        this.tipo = tipo;
        this.activo = activo;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIngredientesPrincipales(String ingredientesPrincipales) {
        this.ingredientesPrincipales = ingredientesPrincipales;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getID() {
        return ID;
    }

    public long getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIngredientesPrincipales() {
        return ingredientesPrincipales;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isActivo() {
        return activo;
    }

    @Override
    public String toString() {
        return "Product{" + "ID=" + ID + ", precio=" + precio + ", nombre=" + nombre + ", ingredientesPrincipales=" + ingredientesPrincipales + ", tipo=" + tipo + ", activo=" + activo + '}';
    }
     
    
}
