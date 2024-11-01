/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Laura Nathalia
 */
public class Order {
    String codigo, fechaPedido, nomenclaturaDir, calleDir, carreraDir, barrioDir, estado, metodoPago;
    long total;

    public Order() {
    }

    public Order(String codigo, String fechaPedido, String nomenclaturaDir, String calleDir, String carreraDir, String barrioDir, String estado, long total, String metodoPago) {
        this.codigo = codigo;
        this.fechaPedido = fechaPedido;
        this.nomenclaturaDir = nomenclaturaDir;
        this.calleDir = calleDir;
        this.carreraDir = carreraDir;
        this.barrioDir = barrioDir;
        this.estado = estado;
        this.metodoPago = metodoPago;
        this.total = total;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public void setNomenclaturaDir(String nomenclaturaDir) {
        this.nomenclaturaDir = nomenclaturaDir;
    }

    public void setCalleDir(String calleDir) {
        this.calleDir = calleDir;
    }

    public void setCarreraDir(String carreraDir) {
        this.carreraDir = carreraDir;
    }

    public void setBarrioDir(String barrioDir) {
        this.barrioDir = barrioDir;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public String getNomenclaturaDir() {
        return nomenclaturaDir;
    }

    public String getCalleDir() {
        return calleDir;
    }

    public String getCarreraDir() {
        return carreraDir;
    }

    public String getBarrioDir() {
        return barrioDir;
    }

    public String getEstado() {
        return estado;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public long getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Pedido{" + "codigo=" + codigo + ", fechaPedido=" + fechaPedido + ", nomenclaturaDir=" + nomenclaturaDir + ", calleDir=" + calleDir + ", carreraDir=" + carreraDir + ", barrioDir=" + barrioDir + ", estado=" + estado + ", metodoPago=" + metodoPago + ", total=" + total + '}';
    }
    
    
}
