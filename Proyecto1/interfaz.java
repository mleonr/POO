import javax.swing.JOptionPane;
public class interfaz{

	public int menu(){
		String[] opciones = { "Consultar saldo", "Depositar", "Retirar", "Salir" };
		return JOptionPane.showOptionDialog(null,"Que operacion deseas realizar?","Banco",JOptionPane.YES_NO_CANCEL_OPTION,
   		JOptionPane.QUESTION_MESSAGE,null,opciones,null);
	}

	public void consultar(float f){
		JOptionPane.showMessageDialog(null,"Saldo actual: "+Float.toString(f), "Banco", JOptionPane.INFORMATION_MESSAGE); 
	}

	public float depositar(){
		
		try{
			float f;
			String s;
		
			s = JOptionPane.showInputDialog(null,"Ingresa la cantidad a depositar:\n","Banco",JOptionPane.QUESTION_MESSAGE);
			f = Float.parseFloat(s);

			if(f<0){
				JOptionPane.showMessageDialog(null,"No se puede depositar valores negativos", "Banco", JOptionPane.ERROR_MESSAGE); 	
				f=0;
			}
			return f;
		}catch(Exception e){
			System.out.println("Espacio vacio");
		}

		return 0;	
	}

	public float retirar(float saldo){

		try{

			String[] opciones = { "Aceptar","Declinar"};

			int res;
			float n;
			boolean ban=true;
			String s;
		
			s = JOptionPane.showInputDialog(null,"Ingresa la cantidad a retirar:\n","Banco",JOptionPane.QUESTION_MESSAGE);
			n = Float.parseFloat(s);

			if(n<0) n*=(-1);

			if((n+30.5)>saldo){
				ban=false;
				n=0;
			}else if((saldo-n)<1000){
				if((saldo-(n+30.5))<0){
					ban=false;
					n=0;
				}else{
					n+=30.50;
					ban=true;
					res = JOptionPane.showOptionDialog(null,"Se cobrara una comision de $30.5","Banco",JOptionPane.YES_NO_CANCEL_OPTION,
   					JOptionPane.WARNING_MESSAGE,null,opciones,null);
   					
   					if(res==1)n=0;
				}
			}

			if(!ban) 
				JOptionPane.showMessageDialog(null,"Saldo insuficiente", "Banco", JOptionPane.WARNING_MESSAGE); 

			return n;

		}catch(Exception e){
			System.out.println("Espacio vacio");
		}

		return 0;
	}


	public long ingresarCliente(){
		try{
			long n;
			String s;
			s = JOptionPane.showInputDialog(null,"Numero de cuenta:\n","Banco",JOptionPane.QUESTION_MESSAGE);
			n = Long.parseLong(s);
		
			return n;
		}catch(Exception e){
			System.out.println("Espacio vacio");
		}
		return 0;
	}

	public void alerta(){
		JOptionPane.showMessageDialog(null,"Cliente no encontrado", "Banco", JOptionPane.WARNING_MESSAGE);
	}




}