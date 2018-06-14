package restaurante;

import java.util.List;
import java.util.ArrayList;

public class Restaurante {
	private String name;
	private List<Cuenta> cuentas;
	private List<Mesa> mesas;
	
	public Restaurante() {
		cuentas = new ArrayList<>();
		mesas = new ArrayList<>();
		
	}
	
	public Restaurante(String s) {
		cuentas = new ArrayList<>();
		mesas = new ArrayList<>();
		name = s;
	}
	public void asignarMesa(Cuenta c)throws MesaNoDisponibleException {
		int index = 0;
		Mesa m = mesas.get(index);
		while (!m.estaLibre()) {
			index++;
			m = mesas.get(index);
		}
		if(index > mesas.size()) {
			System.out.println("No hay mesas Disponibles");
		}else {
		try {
			c.agregarMesa(m);
			System.out.println("Se agrego la mesa: "+m.cod+" a la cuenta: "+c.getCod());
		} catch (MesaNoDisponibleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
	
	public void crearMesaInterior(int c) {
		Mesa m = new Interior(c);
		mesas.add(m);
	}
	
	public void crearMesaExterior(int c) {
		Mesa m = new Exterior(c);
		mesas.add(m);
	}
	public void crearCuenta() {
		Cuenta c = new Cuenta();
		try {
			c.abrirCuenta();
		} catch (CuentaCerradaException e) {
			System.out.println("Cuenta Cerrada!");
		}
		cuentas.add(c);
	}
	public void mostrarMesasLibres()throws RestoSinMesasException {
		if(!mesas.isEmpty()) {
			for(Mesa m : mesas) {
				if(m.estaLibre()) {
					System.out.println("La mesa: "+m.cod+" esta libre");
				}
			}
		}else {
			throw new RestoSinMesasException();
		}
	}
	public void mostrarMesasOcupadas()throws RestoSinMesasException {
		if(!mesas.isEmpty()) {
			for(Mesa m : mesas) {
				if(!m.estaLibre()) {
					System.out.println("La mesa: "+m.cod+" esta ocupada");
				}
			}
		}else {
			throw new RestoSinMesasException();
		}
	}

	public String getName() {
		return name;
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public List<Mesa> getMesas() {
		return mesas;
	}
	public void agregarMesa(Mesa m) {
		mesas.add(m);
	}
	
	
}
