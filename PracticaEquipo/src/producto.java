/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class producto {
    private String nombre;
    private float precio;
    private int stock;
    
    public producto(String nombre,float precio, int stock){
        this.nombre=nombre;
        this.precio=precio;
        this.stock=stock;
    }
    
    public String getnombre(){
        return nombre;
    }
    
    public float getprecio(){
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
}
