import javax.swing.JOptionPane;

public class Interfaz{

	public int menu(String opciones,String titulo){
		try{	
			return Integer.parseInt(JOptionPane.showInputDialog(null,opciones,titulo,JOptionPane.QUESTION_MESSAGE));
		}catch(Exception e){
			System.out.println("MenuPrincipal");
		}
		return -1;
	}

	public String eTexto(String mensaje,String titulo){
		try{
			return JOptionPane.showInputDialog(null,mensaje,titulo,JOptionPane.QUESTION_MESSAGE);
		}catch(Exception e){
			System.out.println("Mensaje");
		}
		return "";
	}

	public void mensajeI(String mensaje,String titulo){
		JOptionPane.showMessageDialog(null,mensaje,titulo, JOptionPane.INFORMATION_MESSAGE); 
	}

	public void mensajeW(String mensaje,String titulo){
		JOptionPane.showMessageDialog(null,mensaje,titulo, JOptionPane.WARNING_MESSAGE); 
	}

	public void mensajeE(String mensaje,String titulo){
		JOptionPane.showMessageDialog(null,mensaje,titulo, JOptionPane.ERROR_MESSAGE); 
	}


}