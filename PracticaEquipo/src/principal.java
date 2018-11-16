/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author alumno
 */
public class principal {
    public static void main(String args[]){
        carrito c1 = new carrito("Yaxko");
        carrito c2 = new carrito("Daniel");
        carrito c3 = new carrito("Conde");
        
        ArrayList<producto>disp = new ArrayList<>();
        
        producto p1 = new producto("Gansito",10f,10);
        producto p2 = new producto("Doritos",12f,10);
        producto p3 = new producto("XX",35f,10);
        producto p4 = new producto("Indio",35f,10);
        producto p5 = new producto("Donitas Bimbo",12f,10);
        producto p6 = new producto("Coca",15f,10);
        producto p7 = new producto("Pepsi",35f,10);
        producto p8 = new producto("Malboro",45f,10);
        producto p9 = new producto("Clorets",12f,10);
        producto p10 = new producto("Doraditas",15f,10);
       
        disp.add(p1);
        disp.add(p2);
        disp.add(p3);
        disp.add(p4);
        disp.add(p5);
        disp.add(p6);
        disp.add(p7);
        disp.add(p8);
        disp.add(p9);
        disp.add(p10);
         
        while(true){
            int opc=Integer.parseInt(JOptionPane.showInputDialog(null,"Elige el carrito:\n1.-"+c1.getNombre()+
                " ("+c1.getnumproductos()+")\n2.-"+c2.getNombre()+" ("+c2.getnumproductos()+")\n3.-"+c3.getNombre()+
                " ("+c3.getnumproductos()+")\n4.-Salir.\n","Menu 1",JOptionPane.INFORMATION_MESSAGE));
            int opc1=0;
            switch(opc){
                case 1:
                    while(opc1!=7){
                        opc1=Integer.parseInt(JOptionPane.showInputDialog(null,"Elige opcion:"
                                + "\n1.-Mostrar catalogo \n2.-Mostrar carro \n3.-Agregar producto \n4.-Seleccionar producto\n5.-Vaciar carro\n6.-Check out\n7.-Regresar",c1.getNombre(),JOptionPane.INFORMATION_MESSAGE));
                        switch(opc1){
                            case 1:
                                JOptionPane.showMessageDialog(null,
                                        "0. "+p1.getnombre()+".   Existencia: "+p1.getStock()
                                        +"\n1. "+p2.getnombre()+".   Existencia: "+p2.getStock()
                                        +"\n2. "+p3.getnombre()+".   Existencia: "+p3.getStock()
                                        +"\n3. "+p4.getnombre()+".   Existencia: "+p4.getStock()
                                        +"\n4. "+p5.getnombre()+".   Existencia: "+p5.getStock()
                                        +"\n5. "+p6.getnombre()+".   Existencia: "+p6.getStock()
                                        +"\n6. "+p7.getnombre()+".   Existencia: "+p7.getStock()
                                        +"\n7. "+p8.getnombre()+".   Existencia: "+p8.getStock()
                                        +"\n8. "+p9.getnombre()+".   Existencia: "+p9.getStock()
                                        +"\n9. "+p10.getnombre()+".   Existencia: "+p10.getStock()
                                        , "Catalogo productos", JOptionPane.INFORMATION_MESSAGE); 
                                break;
                            case 2:
                                String cad="";
                                int tam = c1.getProductos().size();
                                if(tam==0){
                                    JOptionPane.showMessageDialog(null,"El carro esta vacio","", JOptionPane.INFORMATION_MESSAGE); 
                                }else{
                                    for(int i=0;i<tam;i++){
                                    
                                        int cant;                               
                                        cant =c1.getProductos().get(i).getCantidad();

                                        cad=cad+c1.getProductos().get(i).getProduct().getnombre()+ ". Cantidad adquirida: "+cant+"\n";
                                          
                                    }
                                    JOptionPane.showMessageDialog(null,cad,"", JOptionPane.INFORMATION_MESSAGE); 
                                }
                                  
                                break;
                            case 3:
                                String cadena="\n";
                                
                                for(int i=0;i<disp.size();i++){
                                    cadena=cadena+i+".- "+disp.get(i).getnombre()+"  $"+disp.get(i).getprecio()+"\n";
                                    
                                }
                                int index= Integer.parseInt(JOptionPane.showInputDialog(null,"Productos"+cadena, JOptionPane.INFORMATION_MESSAGE)); 
                                int cantidad= Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresar cantidad: ",disp.get(index).getnombre(),JOptionPane.INFORMATION_MESSAGE)); 
                                
                                if(cantidad>disp.get(index).getStock()){
                                   JOptionPane.showMessageDialog(null,"Cantidad insuficiente de "+disp.get(index).getnombre(),"", JOptionPane.WARNING_MESSAGE); 
                                }else if(!(cantidad<=0)){
                                  
                                    String nom="";
                                    boolean ban=false;
                                    nom=disp.get(index).getnombre();
                                  
                                   
                                    for(int i=0;i<c1.getProductos().size();i++){
                                        if(c1.getProductos().get(i).getProduct().getnombre().equals(nom)){
                                            c1.getProductos().get(i).setCantidad(c1.getProductos().get(i).getCantidad()+cantidad);
                                            ban=true;
                                            break;
                                        }
                                    }    
                                  
                                    if(!ban){
                                        c1.agregaracarrito(disp.get(index), cantidad);
                                    }
                                    
                                    disp.get(index).setStock(disp.get(index).getStock()-cantidad);
                                    JOptionPane.showMessageDialog(null,"Compra exitosa","Congratulations", JOptionPane.INFORMATION_MESSAGE); 
                                }
                                break;
                            case 4:
                                String cadena2="\n";
                                
                                if(c1.getProductos().size()==0){
                                    JOptionPane.showMessageDialog(null,"El carro esta vacio","", JOptionPane.WARNING_MESSAGE); 
                                }else{
                                    
                                    int index3= Integer.parseInt(JOptionPane.showInputDialog(null,"1.-Cambiar cantidad de producto\n 2.-Eliminar producto", JOptionPane.INFORMATION_MESSAGE)); 
                                    switch(index3){
                                        case 1:
                                            String cadena3="\n";
                                            for(int i=0;i<c1.getProductos().size();i++){
                                                cadena3=cadena3+i+".- "+c1.getProductos().get(i).getProduct().getnombre()+". Cantidad adquirida: "+c1.getProductos().get(i).getCantidad()+"\n";
                                            }
                                            int index0= Integer.parseInt(JOptionPane.showInputDialog(null,cadena3,"Productos del carrito", JOptionPane.INFORMATION_MESSAGE)); 

                                            if(index0<0 || index0>c1.getProductos().size()){
                                                JOptionPane.showMessageDialog(null,"Opcion no existente","", JOptionPane.WARNING_MESSAGE); 
                                            }else{
                                                int cantidadD = Integer.parseInt(JOptionPane.showInputDialog(null,"Que cantidad deseas quitar del carro",c1.getProductos().get(index0).getProduct().getnombre(), JOptionPane.INFORMATION_MESSAGE)); 
                                                
                                                int result=c1.getProductos().get(index0).getCantidad()-cantidadD;
                                                
                                                if(result<0){
                                                    JOptionPane.showMessageDialog(null,"Opcion no valida","", JOptionPane.WARNING_MESSAGE); 
                                                }else if(result==0){
                                                    
                                                    int nindex1;
                                                    String aux;
                                                
                                                    aux=c1.getProductos().get(index0).getProduct().getnombre();
                                               
                                                    for(int i=0;i<disp.size();i++){
                                                        if(disp.get(i).getnombre().equals(aux)){
                                                            disp.get(i).setStock(disp.get(i).getStock()+cantidadD);
                                                            break;
                                                        }
                                                    }
                                                    
                                                    
                                                    c1.getProductos().remove(index0);
                                                    JOptionPane.showMessageDialog(null,"El producto fue eliminado del carrito","Congratulations", JOptionPane.WARNING_MESSAGE); 
                                                  
                                                }else{
                                                    int nindex2;
                                                    String aux;
                                                
                                                    aux=c1.getProductos().get(index0).getProduct().getnombre();
                                               
                                                    for(int i=0;i<disp.size();i++){
                                                        if(disp.get(i).getnombre().equals(aux)){
                                                            disp.get(i).setStock(disp.get(i).getStock()+cantidadD);
                                                            break;
                                                        }
                                                    }

                                                    c1.getProductos().get(index0).setCantidad(c1.getProductos().get(index0).getCantidad()-cantidadD);
                                                    JOptionPane.showMessageDialog(null,"Se redujo exitosamente la cantidad de producto","", JOptionPane.WARNING_MESSAGE); 
                                                }
                                                
                                            }
                                            
                                            
                                            break;
                                        case 2:
                                            for(int i=0;i<c1.getProductos().size();i++){
                                                cadena2=cadena2+i+".- "+c1.getProductos().get(i).getProduct().getnombre()+". Cantidad adquirida: "+c1.getProductos().get(i).getCantidad()+"\n";
                                            }
                                
                                            int index1= Integer.parseInt(JOptionPane.showInputDialog(null,"Productos del carrito"+cadena2, JOptionPane.INFORMATION_MESSAGE)); 
                                
                                            if(index1<0 || index1>c1.getProductos().size()){
                                                JOptionPane.showMessageDialog(null,"Opcion no existente","", JOptionPane.WARNING_MESSAGE); 
                                            }else{
                                                int nindex;
                                                String aux;
                                                
                                                aux=c1.getProductos().get(index1).getProduct().getnombre();
                                               
                                                for(int i=0;i<disp.size();i++){
                                                    if(disp.get(i).getnombre().equals(aux)){
                                                        disp.get(i).setStock(disp.get(i).getStock()+c1.getProductos().get(index1).getCantidad());
                                                        break;
                                                    }
                                                }
                                                 
                                              
                                                c1.getProductos().remove(index1);
                                                JOptionPane.showMessageDialog(null,"El producto fue eliminado del carrito","Congratulations", JOptionPane.WARNING_MESSAGE); 
                                               
                                            }
                                            break;
                                        default:
                                            JOptionPane.showMessageDialog(null,"Opcion no existente","", JOptionPane.WARNING_MESSAGE); 
                                            break;
                                          
                                    }
                                    
                                    
                                    
                                }
                                
                                break;
                            case 5:
                                if(c1.getProductos().size()==0){
                                    JOptionPane.showMessageDialog(null,"El carro esta vacio","", JOptionPane.WARNING_MESSAGE); 
                                }else{

                                    for(int i=0;i<c1.getProductos().size();i++){
                                        String prod=c1.getProductos().get(i).getProduct().getnombre();
                                        int cprod = c1.getProductos().get(i).getCantidad();
                                        for(int j=0;j<disp.size();j++){
                                            if(disp.get(j).getnombre().equals(prod)){
                                                disp.get(j).setStock(disp.get(j).getStock()+cprod);
                                                break;
                                            }
                                        }
                                    }
                                    
                                    c1.getProductos().clear();
                                                                        
                                    JOptionPane.showMessageDialog(null,"El carro fue vaciado exitosamente","Congratulations", JOptionPane.WARNING_MESSAGE); 
                                }                      
                                break;
                            case 6:
                                
                                int ar=c1.getProductos().size();
                                String cadFinal="\n";
                                
                                if(ar==0){
                                    JOptionPane.showMessageDialog(null,"El carro esta vacio","", JOptionPane.WARNING_MESSAGE); 
                                }else{
                                    float sum=0;
                                    for(int i=0;i<ar;i++){
                                        
                                        int cant;
                                        float subtotal,precio = c1.getProductos().get(i).getProduct().getprecio();
                                        
                                        cant =c1.getProductos().get(i).getCantidad();
                                        subtotal =  (float)cant*precio;
                                                
                                        cadFinal=cadFinal+i+".- "+c1.getProductos().get(i).getProduct().getnombre()+
                                                ". Cantidad adquirida: "+cant+
                                                ". Precio Unitario: $"+ precio+
                                                ". Subtotal: $"+subtotal+"\n";
                                        
                                        sum+=subtotal;
        
                                    } 
                                    
                                    JOptionPane.showMessageDialog(null,cadFinal+"\nTotal: "+sum,"Ticket de compra", JOptionPane.INFORMATION_MESSAGE); 
                                    c1.getProductos().clear();
                                }
                                
                                
                                break;
                            case 7:
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case 2:
                    while(opc1!=7){
                        opc1=Integer.parseInt(JOptionPane.showInputDialog(null,"Elige opcion:"
                                + "\n1.-Mostrar catalogo \n2.-Mostrar carro \n3.-Agregar producto \n4.-Seleccionar producto\n5.-Vaciar carro\n6.-Check out\n7.-Regresar",c2.getNombre(),JOptionPane.INFORMATION_MESSAGE));
                        switch(opc1){
                            case 1:
                                JOptionPane.showMessageDialog(null,
                                        "0. "+p1.getnombre()+".   Existencia: "+p1.getStock()
                                        +"\n1. "+p2.getnombre()+".   Existencia: "+p2.getStock()
                                        +"\n2. "+p3.getnombre()+".   Existencia: "+p3.getStock()
                                        +"\n3. "+p4.getnombre()+".   Existencia: "+p4.getStock()
                                        +"\n4. "+p5.getnombre()+".   Existencia: "+p5.getStock()
                                        +"\n5. "+p6.getnombre()+".   Existencia: "+p6.getStock()
                                        +"\n6. "+p7.getnombre()+".   Existencia: "+p7.getStock()
                                        +"\n7. "+p8.getnombre()+".   Existencia: "+p8.getStock()
                                        +"\n8. "+p9.getnombre()+".   Existencia: "+p9.getStock()
                                        +"\n9. "+p10.getnombre()+".   Existencia: "+p10.getStock()
                                        , "Catalogo productos", JOptionPane.INFORMATION_MESSAGE); 
                                break;
                            case 2:
                                String cad="";
                                int tam = c2.getProductos().size();
                                if(tam==0){
                                    JOptionPane.showMessageDialog(null,"El carro esta vacio","", JOptionPane.INFORMATION_MESSAGE); 
                                }else{
                                    for(int i=0;i<tam;i++){
                                    
                                        int cant;                               
                                        cant =c2.getProductos().get(i).getCantidad();

                                        cad=cad+c2.getProductos().get(i).getProduct().getnombre()+ ". Cantidad adquirida: "+cant+"\n";
                                          
                                    }
                                    JOptionPane.showMessageDialog(null,cad,"", JOptionPane.INFORMATION_MESSAGE); 
                                }
                                
                                break;
                            case 3:
                                String cadena="\n";
                                
                                for(int i=0;i<disp.size();i++){
                                    cadena=cadena+i+".- "+disp.get(i).getnombre()+"  $"+disp.get(i).getprecio()+"\n";
                                    
                                }
                                int index= Integer.parseInt(JOptionPane.showInputDialog(null,"Productos"+cadena, JOptionPane.INFORMATION_MESSAGE)); 
                                int cantidad= Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresar cantidad: ",disp.get(index).getnombre(),JOptionPane.INFORMATION_MESSAGE)); 
                                
                                if(cantidad>disp.get(index).getStock()){
                                   JOptionPane.showMessageDialog(null,"Cantidad insuficiente de "+disp.get(index).getnombre(),"", JOptionPane.WARNING_MESSAGE); 
                                }else if(!(cantidad<=0)){
                                  
                                    String nom="";
                                    boolean ban=false;
                                    nom=disp.get(index).getnombre();
                                  
                                   
                                    for(int i=0;i<c2.getProductos().size();i++){
                                        if(c2.getProductos().get(i).getProduct().getnombre().equals(nom)){
                                            c2.getProductos().get(i).setCantidad(c2.getProductos().get(i).getCantidad()+cantidad);
                                            ban=true;
                                            break;
                                        }
                                    }    
                                  
                                    if(!ban){
                                        c2.agregaracarrito(disp.get(index), cantidad);
                                    }
                                    
                                    disp.get(index).setStock(disp.get(index).getStock()-cantidad);
                                    JOptionPane.showMessageDialog(null,"Compra exitosa","Congratulations", JOptionPane.INFORMATION_MESSAGE); 
                                }
                                break;
                            case 4:
                                String cadena2="\n";
                                
                                if(c2.getProductos().size()==0){
                                    JOptionPane.showMessageDialog(null,"El carro esta vacio","", JOptionPane.WARNING_MESSAGE); 
                                }else{
                                    
                                    int index3= Integer.parseInt(JOptionPane.showInputDialog(null,"1.-Cambiar cantidad de producto\n 2.-Eliminar producto", JOptionPane.INFORMATION_MESSAGE)); 
                                    switch(index3){
                                        case 1:
                                            String cadena3="\n";
                                            for(int i=0;i<c2.getProductos().size();i++){
                                                cadena3=cadena3+i+".- "+c2.getProductos().get(i).getProduct().getnombre()+". Cantidad adquirida: "+c2.getProductos().get(i).getCantidad()+"\n";
                                            }
                                            int index0= Integer.parseInt(JOptionPane.showInputDialog(null,cadena3,"Productos del carrito", JOptionPane.INFORMATION_MESSAGE)); 

                                            if(index0<0 || index0>c2.getProductos().size()){
                                                JOptionPane.showMessageDialog(null,"Opcion no existente","", JOptionPane.WARNING_MESSAGE); 
                                            }else{
                                                int cantidadD = Integer.parseInt(JOptionPane.showInputDialog(null,"Que cantidad deseas quitar del carro",c2.getProductos().get(index0).getProduct().getnombre(), JOptionPane.INFORMATION_MESSAGE)); 
                                                
                                                int result=c2.getProductos().get(index0).getCantidad()-cantidadD;
                                                
                                                if(result<0){
                                                    JOptionPane.showMessageDialog(null,"Opcion no valida","", JOptionPane.WARNING_MESSAGE); 
                                                }else if(result==0){
                                                    
                                                    int nindex1;
                                                    String aux;
                                                
                                                    aux=c2.getProductos().get(index0).getProduct().getnombre();
                                               
                                                    for(int i=0;i<disp.size();i++){
                                                        if(disp.get(i).getnombre().equals(aux)){
                                                            disp.get(i).setStock(disp.get(i).getStock()+cantidadD);
                                                            break;
                                                        }
                                                    }
                                                    
                                                    
                                                    c2.getProductos().remove(index0);
                                                    JOptionPane.showMessageDialog(null,"El producto fue eliminado del carrito","Congratulations", JOptionPane.WARNING_MESSAGE); 
                                                  
                                                }else{
                                                    int nindex2;
                                                    String aux;
                                                
                                                    aux=c2.getProductos().get(index0).getProduct().getnombre();
                                               
                                                    for(int i=0;i<disp.size();i++){
                                                        if(disp.get(i).getnombre().equals(aux)){
                                                            disp.get(i).setStock(disp.get(i).getStock()+cantidadD);
                                                            break;
                                                        }
                                                    }

                                                    c2.getProductos().get(index0).setCantidad(c2.getProductos().get(index0).getCantidad()-cantidadD);
                                                    JOptionPane.showMessageDialog(null,"Se redujo exitosamente la cantidad de producto","", JOptionPane.WARNING_MESSAGE); 
                                                }
                                                
                                            }
                                            
                                            
                                            break;
                                        case 2:
                                            for(int i=0;i<c2.getProductos().size();i++){
                                                cadena2=cadena2+i+".- "+c2.getProductos().get(i).getProduct().getnombre()+". Cantidad adquirida: "+c2.getProductos().get(i).getCantidad()+"\n";
                                            }
                                
                                            int index1= Integer.parseInt(JOptionPane.showInputDialog(null,"Productos del carrito"+cadena2, JOptionPane.INFORMATION_MESSAGE)); 
                                
                                            if(index1<0 || index1>c2.getProductos().size()){
                                                JOptionPane.showMessageDialog(null,"Opcion no existente","", JOptionPane.WARNING_MESSAGE); 
                                            }else{
                                                int nindex;
                                                String aux;
                                                
                                                aux=c2.getProductos().get(index1).getProduct().getnombre();
                                               
                                                for(int i=0;i<disp.size();i++){
                                                    if(disp.get(i).getnombre().equals(aux)){
                                                        disp.get(i).setStock(disp.get(i).getStock()+c2.getProductos().get(index1).getCantidad());
                                                        break;
                                                    }
                                                }
                                                 
                                              
                                                c2.getProductos().remove(index1);
                                                JOptionPane.showMessageDialog(null,"El producto fue eliminado del carrito","Congratulations", JOptionPane.WARNING_MESSAGE); 
                                               
                                            }
                                            break;
                                        default:
                                            JOptionPane.showMessageDialog(null,"Opcion no existente","", JOptionPane.WARNING_MESSAGE); 
                                            break;
                                          
                                    }
                                    
                                    
                                    
                                }
                                
                                break;
                            case 5:
                                if(c2.getProductos().size()==0){
                                    JOptionPane.showMessageDialog(null,"El carro esta vacio","", JOptionPane.WARNING_MESSAGE); 
                                }else{
                                    for(int i=0;i<c2.getProductos().size();i++){
                                        String prod=c2.getProductos().get(i).getProduct().getnombre();
                                        int cprod = c2.getProductos().get(i).getCantidad();
                                        for(int j=0;j<disp.size();j++){
                                            if(disp.get(j).getnombre().equals(prod)){
                                                disp.get(j).setStock(disp.get(j).getStock()+cprod);
                                                break;
                                            }
                                        }
                                    }
                                    c2.getProductos().clear();
                                    JOptionPane.showMessageDialog(null,"El carro fue vaciado exitosamente","Congratulations", JOptionPane.WARNING_MESSAGE); 
                                }                      
                                break;
                            case 6:
                                
                                int ta=c2.getProductos().size();
                                String cadFinal="\n";
                                
                                if(ta==0){
                                    JOptionPane.showMessageDialog(null,"El carro esta vacio","", JOptionPane.WARNING_MESSAGE); 
                                }else{
                                    float sum=0;
                                    for(int i=0;i<ta;i++){
                                        
                                        int cant;
                                        float subtotal,precio = c2.getProductos().get(i).getProduct().getprecio();
                                        
                                        cant =c2.getProductos().get(i).getCantidad();
                                        subtotal =  (float)cant*precio;
                                                
                                        cadFinal=cadFinal+i+".- "+c2.getProductos().get(i).getProduct().getnombre()+
                                                ". Cantidad adquirida: "+cant+
                                                ". Precio Unitario: $"+ precio+
                                                ". Subtotal: $"+subtotal+"\n";
                                        
                                        sum+=subtotal;
        
                                    } 
                                    
                                    JOptionPane.showMessageDialog(null,cadFinal+"\nTotal: "+sum,"Ticket de compra", JOptionPane.INFORMATION_MESSAGE); 
                                    c2.getProductos().clear();
                                }
                                
                                
                                break;
                            case 7:
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case 3:
                    while(opc1!=7){
                        opc1=Integer.parseInt(JOptionPane.showInputDialog(null,"Elige opcion:"
                                + "\n1.-Mostrar catalogo \n2.-Mostrar carro \n3.-Agregar producto \n4.-Seleccionar producto \n5.-Vaciar carro \n6.-Check out \n7.-Regresar",c3.getNombre(),JOptionPane.INFORMATION_MESSAGE));
                        switch(opc1){
                            case 1:
                                JOptionPane.showMessageDialog(null,
                                        "0. "+p1.getnombre()+".   Existencia: "+p1.getStock()
                                        +"\n1. "+p2.getnombre()+".   Existencia: "+p2.getStock()
                                        +"\n2. "+p3.getnombre()+".   Existencia: "+p3.getStock()
                                        +"\n3. "+p4.getnombre()+".   Existencia: "+p4.getStock()
                                        +"\n4. "+p5.getnombre()+".   Existencia: "+p5.getStock()
                                        +"\n5. "+p6.getnombre()+".   Existencia: "+p6.getStock()
                                        +"\n6. "+p7.getnombre()+".   Existencia: "+p7.getStock()
                                        +"\n7. "+p8.getnombre()+".   Existencia: "+p8.getStock()
                                        +"\n8. "+p9.getnombre()+".   Existencia: "+p9.getStock()
                                        +"\n9. "+p10.getnombre()+".   Existencia: "+p10.getStock()
                                        , "Catalogo productos", JOptionPane.INFORMATION_MESSAGE); 
                                break;
                            case 2:
                                String cad="";
                                int ta = c3.getProductos().size();
                                if(ta==0){
                                    JOptionPane.showMessageDialog(null,"El carro esta vacio","", JOptionPane.INFORMATION_MESSAGE); 
                                }else{
                                    for(int i=0;i<ta;i++){
                                    
                                        int cant;                               
                                        cant =c3.getProductos().get(i).getCantidad();

                                        cad=cad+c3.getProductos().get(i).getProduct().getnombre()+ ". Cantidad adquirida: "+cant+"\n";
                                          
                                    }
                                    JOptionPane.showMessageDialog(null,cad,"", JOptionPane.INFORMATION_MESSAGE); 
                                }
                                
                                break;
                            case 3:
                                String cadena="\n";
                                
                                for(int i=0;i<disp.size();i++){
                                    cadena=cadena+i+".- "+disp.get(i).getnombre()+"  $"+disp.get(i).getprecio()+"\n";
                                    
                                }
                                int index= Integer.parseInt(JOptionPane.showInputDialog(null,"Productos"+cadena, JOptionPane.INFORMATION_MESSAGE)); 
                                int cantidad= Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresar cantidad: ",disp.get(index).getnombre(),JOptionPane.INFORMATION_MESSAGE)); 
                                
                                if(cantidad>disp.get(index).getStock()){
                                   JOptionPane.showMessageDialog(null,"Cantidad insuficiente de "+disp.get(index).getnombre(),"", JOptionPane.WARNING_MESSAGE); 
                                }else if(!(cantidad<=0)){
                                  
                                    String nom="";
                                    boolean ban=false;
                                    nom=disp.get(index).getnombre();
                                  
                                   
                                    for(int i=0;i<c3.getProductos().size();i++){
                                        if(c3.getProductos().get(i).getProduct().getnombre().equals(nom)){
                                            c3.getProductos().get(i).setCantidad(c2.getProductos().get(i).getCantidad()+cantidad);
                                            ban=true;
                                            break;
                                        }
                                    }    
                                  
                                    if(!ban){
                                        c3.agregaracarrito(disp.get(index), cantidad);
                                    }
                                    
                                    disp.get(index).setStock(disp.get(index).getStock()-cantidad);
                                    JOptionPane.showMessageDialog(null,"Compra exitosa","Congratulations", JOptionPane.INFORMATION_MESSAGE); 
                                }
                                break;
                            case 4:
                                String cadena2="\n";
                                
                                if(c3.getProductos().size()==0){
                                    JOptionPane.showMessageDialog(null,"El carro esta vacio","", JOptionPane.WARNING_MESSAGE); 
                                }else{
                                    
                                    int index3= Integer.parseInt(JOptionPane.showInputDialog(null,"1.-Cambiar cantidad de producto\n 2.-Eliminar producto", JOptionPane.INFORMATION_MESSAGE)); 
                                    switch(index3){
                                        case 1:
                                            String cadena3="\n";
                                            for(int i=0;i<c3.getProductos().size();i++){
                                                cadena3=cadena3+i+".- "+c3.getProductos().get(i).getProduct().getnombre()+". Cantidad adquirida: "+c3.getProductos().get(i).getCantidad()+"\n";
                                            }
                                            int index0= Integer.parseInt(JOptionPane.showInputDialog(null,cadena3,"Productos del carrito", JOptionPane.INFORMATION_MESSAGE)); 

                                            if(index0<0 || index0>c3.getProductos().size()){
                                                JOptionPane.showMessageDialog(null,"Opcion no existente","", JOptionPane.WARNING_MESSAGE); 
                                            }else{
                                                int cantidadD = Integer.parseInt(JOptionPane.showInputDialog(null,"Que cantidad deseas quitar del carro",c3.getProductos().get(index0).getProduct().getnombre(), JOptionPane.INFORMATION_MESSAGE)); 
                                                
                                                int result=c3.getProductos().get(index0).getCantidad()-cantidadD;
                                                
                                                if(result<0){
                                                    JOptionPane.showMessageDialog(null,"Opcion no valida","", JOptionPane.WARNING_MESSAGE); 
                                                }else if(result==0){
                                                    
                                                    int nindex1;
                                                    String aux;
                                                
                                                    aux=c3.getProductos().get(index0).getProduct().getnombre();
                                               
                                                    for(int i=0;i<disp.size();i++){
                                                        if(disp.get(i).getnombre().equals(aux)){
                                                            disp.get(i).setStock(disp.get(i).getStock()+cantidadD);
                                                            break;
                                                        }
                                                    }
                                                    
                                                    
                                                    c3.getProductos().remove(index0);
                                                    JOptionPane.showMessageDialog(null,"El producto fue eliminado del carrito","Congratulations", JOptionPane.WARNING_MESSAGE); 
                                                  
                                                }else{
                                                    int nindex2;
                                                    String aux;
                                                
                                                    aux=c3.getProductos().get(index0).getProduct().getnombre();
                                               
                                                    for(int i=0;i<disp.size();i++){
                                                        if(disp.get(i).getnombre().equals(aux)){
                                                            disp.get(i).setStock(disp.get(i).getStock()+cantidadD);
                                                            break;
                                                        }
                                                    }

                                                    c3.getProductos().get(index0).setCantidad(c2.getProductos().get(index0).getCantidad()-cantidadD);
                                                    JOptionPane.showMessageDialog(null,"Se redujo exitosamente la cantidad de producto","", JOptionPane.WARNING_MESSAGE); 
                                                }
                                                
                                            }
                                            
                                            
                                            break;
                                        case 2:
                                            for(int i=0;i<c3.getProductos().size();i++){
                                                cadena2=cadena2+i+".- "+c3.getProductos().get(i).getProduct().getnombre()+". Cantidad adquirida: "+c3.getProductos().get(i).getCantidad()+"\n";
                                            }
                                
                                            int index1= Integer.parseInt(JOptionPane.showInputDialog(null,"Productos del carrito"+cadena2, JOptionPane.INFORMATION_MESSAGE)); 
                                
                                            if(index1<0 || index1>c3.getProductos().size()){
                                                JOptionPane.showMessageDialog(null,"Opcion no existente","", JOptionPane.WARNING_MESSAGE); 
                                            }else{
                                                int nindex;
                                                String aux;
                                                
                                                aux=c3.getProductos().get(index1).getProduct().getnombre();
                                               
                                                for(int i=0;i<disp.size();i++){
                                                    if(disp.get(i).getnombre().equals(aux)){
                                                        disp.get(i).setStock(disp.get(i).getStock()+c3.getProductos().get(index1).getCantidad());
                                                        break;
                                                    }
                                                }
                                                 
                                              
                                                c3.getProductos().remove(index1);
                                                JOptionPane.showMessageDialog(null,"El producto fue eliminado del carrito","Congratulations", JOptionPane.WARNING_MESSAGE); 
                                               
                                            }
                                            break;
                                        default:
                                            JOptionPane.showMessageDialog(null,"Opcion no existente","", JOptionPane.WARNING_MESSAGE); 
                                            break;
                                          
                                    }
                                    
                                    
                                    
                                }
                                
                                break;
                            case 5:
                                if(c3.getProductos().size()==0){
                                    JOptionPane.showMessageDialog(null,"El carro esta vacio","", JOptionPane.WARNING_MESSAGE); 
                                }else{
                                    for(int i=0;i<c3.getProductos().size();i++){
                                        String prod=c3.getProductos().get(i).getProduct().getnombre();
                                        int cprod = c3.getProductos().get(i).getCantidad();
                                        for(int j=0;j<disp.size();j++){
                                            if(disp.get(j).getnombre().equals(prod)){
                                                disp.get(j).setStock(disp.get(j).getStock()+cprod);
                                                break;
                                            }
                                        }
                                    }

                                    c3.getProductos().clear();
                                    JOptionPane.showMessageDialog(null,"El carro fue vaciado exitosamente","Congratulations", JOptionPane.WARNING_MESSAGE); 
                                }                      
                                break;
                            case 6:
                                
                                int tam=c3.getProductos().size();
                                String cadFinal="\n";
                                
                                if(tam==0){
                                    JOptionPane.showMessageDialog(null,"El carro esta vacio","", JOptionPane.WARNING_MESSAGE); 
                                }else{
                                    float sum=0;
                                    for(int i=0;i<tam;i++){
                                        
                                        int cant;
                                        float subtotal,precio = c3.getProductos().get(i).getProduct().getprecio();
                                        
                                        cant =c3.getProductos().get(i).getCantidad();
                                        subtotal =  (float)cant*precio;
                                                
                                        cadFinal=cadFinal+i+".- "+c3.getProductos().get(i).getProduct().getnombre()+
                                                ". Cantidad adquirida: "+cant+
                                                ". Precio Unitario: $"+ precio+
                                                ". Subtotal: $"+subtotal+"\n";
                                        
                                        sum+=subtotal;
        
                                    } 
                                    
                                    JOptionPane.showMessageDialog(null,cadFinal+"\nTotal: "+sum,"Ticket de compra", JOptionPane.INFORMATION_MESSAGE); 
                                    c3.getProductos().clear();
                                }
                                
                                
                                break;
                            case 7:
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case 4:
                    System.exit(0);
                default:
                    break;
            }
        }
    }
    
}
