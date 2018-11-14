
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class carrito {
    private String nombre;
    private ArrayList<item> productos;
    
    public carrito(String nombre){
        this.nombre=nombre;
        productos = new ArrayList<item>();
    }
    
    public void agregaracarrito(producto product, int cantidad){
        item it = new item(product,cantidad);
        it.AsignarCarrito(this);
        getProductos().add(it);
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<item> getProductos() {
        return productos;
    }
    
    public int getnumproductos(){
        int contador=0;
        for(int i=0;i<productos.size();i++){
            contador=contador+productos.get(i).getCantidad();
        }
        return contador;
    }

}
