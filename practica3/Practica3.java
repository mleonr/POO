import java.io.*;
public class Practica3{
	public static void main(String []args){
		
	
		Interfaz ifz= new Interfaz();	
		Agenda Ag = new Agenda("Agenda1");


		Ag.CrearContacto("MARCOS LEON","MARCOS@GMAIL.COM","15582258");
		Ag.CrearContacto("MARCOS LEON","MARCOS@OUTLOOK.COM","5576618466");
		Ag.CrearContacto("ARIADNA","ARI@GMAIL.COM","33223344");
		Ag.CrearContacto("GIBE","GIBE@GMAIL.COM","44332244");
		Ag.CrearContacto("MIRIAM","MIRIAM@GMAIL.COM","22334533");

		while(true){
			int menu=ifz.menu("1.-Elegir Contacto\n2.-Crear contacto\n3.-Buscar contacto\n4.-Salir","Menu");
			switch(menu){

				case 1:
					String lista= new String("");
					for(int i=0;i<Ag.getContactos().size();i++){	
						lista+=i+") Nombre: "+Ag.getContactos().get(i).getNombre()
						+". Correo: "+Ag.getContactos().get(i).getCorreo()
						+". Telefono: "+Ag.getContactos().get(i).getNumero()+"\n";
					}
					lista+="\n";

					int index = ifz.menu(lista,"Contactos");

					Contacto c = Ag.getContactos().get(index);

					int submenu = ifz.menu("1.-Editar\n2.-Borrar\n3.-Regresar",c.getNombre());

					switch(submenu){
						case 1:
							String nom = new String(ifz.eTexto("Nombre: ","Editar contacto"));
							String cor = new String(ifz.eTexto("Correo: ","Editar contacto"));
							String tel = new String(ifz.eTexto("Telefono: ","Editar contacto"));	

							nom = nom.toUpperCase();
							cor = cor.toUpperCase();
							tel = tel.toUpperCase();

							if(cor.equals(c.getCorreo()) && (!tel.equals(c.getNumero()))){
								if((!Ag.buscarNumero(tel).equals("nF"))){
									ifz.mensajeW("Telefono ya registrado","");
								}else{
									c.setNombre(nom);
									c.setNumero(tel);
									ifz.mensajeI("Contacto modificado","");
								}
							}else if(!(cor.equals(c.getCorreo())) && tel.equals(c.getNumero())){
								if((!Ag.buscarCorreo(cor).equals("nF"))){
									ifz.mensajeW("Correo ya registrado","");
								}else{
									c.setNombre(nom);
									c.setCorreo(cor);
									ifz.mensajeI("Contacto modificado","");
								}
							}else if(cor.equals(c.getCorreo()) && tel.equals(c.getNumero())){
								c.setNombre(nom);
								ifz.mensajeI("Contacto modificado","");
							}else if(!Ag.buscarCorreo(cor).equals("nF")){
								ifz.mensajeW("Correo ya registrado","");
							}else if(!Ag.buscarNumero(tel).equals("nF")){
								ifz.mensajeW("Telefono ya registrado","");
							}else{	
								c.setCorreo(cor);
								c.setNumero(tel);
								ifz.mensajeI("Contacto modificado","");
							}
						
						break;	
						case 2:
							Ag.EliminarContacto(c);
							ifz.mensajeI("Contacto eliminado","");
						break;
					}

				break;
				case 2:
					String nom = new String(ifz.eTexto("Nombre: ","Editar contacto"));
					String cor = new String(ifz.eTexto("Correo: ","Editar contacto"));
					String tel = new String(ifz.eTexto("Telefono: ","Editar contacto"));

					nom = nom.toUpperCase();
					cor = cor.toUpperCase();
					tel = tel.toUpperCase();

					if((!Ag.buscarCorreo(cor).equals("nF")) || (!Ag.buscarNumero(tel).equals("nF"))){
						ifz.mensajeW("Contacto ya registrado","");
					}else{
						Ag.CrearContacto(nom,cor,tel);
						ifz.mensajeI("Contacto registrado","");
					}
				break;
				case 3:
					String entrada = new String(ifz.eTexto("","Buscar contacto"));
					if(Ag.BuscarContacto(entrada).equals("nF"))
						ifz.mensajeW("Contacto no encontrado","");
					else
						ifz.mensajeI(Ag.BuscarContacto(entrada),"");
				break;
				case 4:
					System.exit(0);
				break;
				default:
					ifz.mensajeW("Opcion invalida","");
				break;
			}
		}


	}
}