public class proyecto1{
	public static void main(String []args){
		
		long r;
		interfaz i = new interfaz();
		cliente c = new cliente();		
		
		while(true){
			r = i.ingresarCliente();
			if(r==c.getId()){
				while(true){
					switch(i.menu()){
						case 0:
							i.consultar(c.verSaldo());
						break;
						case 1:
							c.depositarEfectivo(i.depositar());
						break;
						case 2:
							c.retirarEfectivo(i.retirar(c.getSaldo()));
						break;
						case 3:
							System.exit(0);
						break;
					}
				}
			}else{
				i.alerta();
			}
		}
	}
}