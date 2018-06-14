package restaurante;

public class Mesa {
	private static int proxcod = 1;
	protected int cod;
	protected int capacidad;
	protected boolean estaLibre;	
	
	public Mesa(){
		cod = proxcod;
		proxcod ++;
		estaLibre = true;
	}
	public Mesa(int c) {
		super();
		capacidad = c;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public boolean estaLibre() {
		return estaLibre;
	}
	public void setEstaLibre(boolean estaLibre) {
		this.estaLibre = estaLibre;
	}
	public void ocupar() {
		// TODO Auto-generated method stub
		estaLibre = false;
		
	}
	public void desocupar() {
		estaLibre = true;
	}
	
	

}
