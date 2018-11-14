/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
/**
 *
 * @author alumno
 */
public class item {
    private producto product;
    private int cantidad;
    private carrito c;
    
    public item(producto product,int cantidad){
        this.product=product;
        this.cantidad=cantidad;
    }

    public producto getProduct() {
        return product;
    }
    
    public void setProduct(producto product) {
        this.product = product;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public void AsignarCarrito(carrito c){
        this.c=c;
    }
        
}
