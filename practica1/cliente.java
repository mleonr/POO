public class cliente{
	
	private long id;
	private String nombre;
	private String dir;
	private float saldo;

	public cliente(){
		id=2015140414L;
		nombre = "Marcos Leon Reyes";
		dir = "Caballo Bayo 158, Colonia Benito Juarez, Cd. Nezahualcoyotl, Edo. de. Mex.";
		saldo= 1500.0f;
	}

	public long getId(){
		return id;
	}

	public void setId(long i){
		id=i;
	} 

	public String getNombre(){
		return nombre;
	}

	public void setNombre(String n){
		nombre=n;
	}

	public String getDir(){
		return dir;
	}

	public void setDir(String d){
		dir=d;
	}

	public float getSaldo(){
		return saldo;
	}

	public void setSaldo(float s){
		saldo=s;
	}


	public float verSaldo(){
		return saldo;
	}

	public void depositarEfectivo(float n){
		saldo +=n;
	}
	
	public void retirarEfectivo(float n){
		saldo-=n;			
	}

}
