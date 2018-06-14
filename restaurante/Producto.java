package restaurante;

public class Producto {
	protected String name;
	protected float importe;
	
	public Producto(String n, float i) {
		// TODO Auto-generated constructor stub
		name = n;
		importe = i;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}
	
	public Producto() {
		// TODO Auto-generated constructor stub
		name = "";
		importe = 1;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+" - "+importe;
	}
}
