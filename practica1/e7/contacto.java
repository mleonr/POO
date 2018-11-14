import javax.swing.*;
public class contacto{
	private String nombre;
	private String email;
	private String direccion;
	private String numero;


	public contacto(){
		nombre="Yaxkin Flores Mendoza";
		email="yaxkin@gmail.com";
		direccion = "Calle 2 360, Colonia Esperanza";
		numero="5576618499";
	}

	public contacto(String nom, String em, String dir, String num){
		nombre=nom;
		email=em;
		direccion=dir;
		numero= num;	
	}

	public contacto(contacto c){
		nombre = c.nombre;
		email = c.email;
		direccion = c.direccion;
		numero = c.numero;
	}


	public String getnombre(){
		return nombre;
	}

	public void setnombre(String nom){
		nombre = nom;
	}

	public String getemail(){
		return email;
	}

	public void setemail(String em){
		email=em;
	}

	public String getdireccion(){
		return direccion;	
	}

	public void setdireccion(String dir){
		direccion=dir;	
	}

	public String getnumero(){
		return numero;
	}

	public void setnumero(String num){
		numero=num;
	}



	public static void main(String []args){
		
		int entI;
		String entS,aux;

		contacto c1,c2,c3;

		c1 = new contacto();
		c2 = new contacto("Marcos Leon Reyes","marcos_leonr@outlook.com","Caballo Bayo 158, Colonia Benito Juarez","5515582258");
		c3= new contacto(c1);

		while(true){
			entS = JOptionPane.showInputDialog(null,"Contactos:\n"
				+"1) "+c1.getnombre()+"; "+c1.getemail()+"; "+c1.getdireccion()+"; "+c1.getnumero()+"\n"
				+"2) "+c2.getnombre()+"; "+c2.getemail()+"; "+c2.getdireccion()+"; "+c2.getnumero()+"\n"
				+"3) "+c3.getnombre()+"; "+c3.getemail()+"; "+c3.getdireccion()+"; "+c3.getnumero()+"\n"
				+"4) Salir\n\n","AGENDA",JOptionPane.QUESTION_MESSAGE);
			
			entI=Integer.parseInt(entS);
			switch(entI){
				case 1:
					aux=JOptionPane.showInputDialog("Nombre:\n");
					c1.setnombre(aux);
					aux=JOptionPane.showInputDialog("Email:\n");
					c1.setemail(aux);
					aux=JOptionPane.showInputDialog("Direccion:\n");
					c1.setdireccion(aux);
					aux=JOptionPane.showInputDialog("Numero:\n");
					c1.setnumero(aux);
					break;
				case 2:
					aux=JOptionPane.showInputDialog("Nombre:\n");
					c2.setnombre(aux);
					aux=JOptionPane.showInputDialog("Email:\n");
					c2.setemail(aux);
					aux=JOptionPane.showInputDialog("Direccion:\n");
					c2.setdireccion(aux);
					aux=JOptionPane.showInputDialog("Numero:\n");
					c2.setnumero(aux);
					break;
				case 3:
					aux=JOptionPane.showInputDialog("Nombre:\n");
					c3.setnombre(aux);
					aux=JOptionPane.showInputDialog("Email:\n");
					c3.setemail(aux);
					aux=JOptionPane.showInputDialog("Direccion:\n");
					c3.setdireccion(aux);
					aux=JOptionPane.showInputDialog("Numero:\n");
					c3.setnumero(aux);
					break;
				case 4:
					System.exit(0);
					break;
				default : 	
					JOptionPane.showMessageDialog(null, "Opcion no valida", "Alerta", JOptionPane.ERROR_MESSAGE); 
					break;
			}
		}

		
		
	}



}
