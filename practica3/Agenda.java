import java.util.ArrayList;
public class Agenda{

	private String nombreA;
	private ArrayList<Contacto>contactos;

	public Agenda(String nombreA){
		this.nombreA=nombreA;
		contactos= new ArrayList<Contacto>();
	}

	public String getNombreA(){
		return nombreA;
	}

	public void setNombreA(String nombreA){
		this.nombreA=nombreA;
	}

	public ArrayList<Contacto> getContactos(){
		return contactos;
	}

	public void CrearContacto(String nombre,String correo,String numero){
		Contacto c= new Contacto(nombre,correo,numero);
		c.AsignarAgenda(this);
		contactos.add(c);
	}

	public void EliminarContacto(Contacto c){
		contactos.remove(c);
	}

	public String BuscarContacto(String s){

		s = (s.trim()).toUpperCase();
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='@'){
				return buscarCorreo(s);
			}
		}

		for(int i=0;i<s.length();i++){
			int val =  (int)s.charAt(0);
			
			if(val>=65 && val<=90){
				return buscarNombre(s);
			}
		}
		
		return buscarNumero(s);
	}

	public String buscarNombre(String s){
		String aux = new String("");
		for(int i=0;i<contactos.size();i++){
			if(contactos.get(i).getNombre().equals(s)){
				aux+="Nombre: "+ contactos.get(i).getNombre()
				+". Correo: "+ contactos.get(i).getCorreo()
				+". Telefono: "+ contactos.get(i).getNumero()+"\n";
			} 
		}
		if(!aux.isEmpty()){
			return aux;
		}
		return 	"nF";	
	}

	public String buscarCorreo(String s){
		for(int i=0;i<contactos.size();i++){
			if(contactos.get(i).getCorreo().equals(s)){
				return "Nombre: "+ contactos.get(i).getNombre()
				+". Correo: "+ contactos.get(i).getCorreo()
				+". Telefono: "+ contactos.get(i).getNumero()+"\n";
			} 
		}
		return 	"nF";	
	}

	public String buscarNumero(String s){
		for(int i=0;i<contactos.size();i++){
			if(contactos.get(i).getNumero().equals(s)){
				return "Nombre: "+ contactos.get(i).getNombre()
				+". Correo: "+ contactos.get(i).getCorreo()
				+". Telefono: "+ contactos.get(i).getNumero()+"\n";
			} 
		}
		return 	"nF";	
	}

	



}