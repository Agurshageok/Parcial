package restaurante;

import java.util.ArrayList;
import java.util.List;

public class Cuenta {
	enum estados {
		ABIERTA, CERRADA
	}

	private static int proxcod = 1;
	private int cod;
	private List<Mesa> mesas;
	private estados estado;
	private List<Pedido> pedidos;
	private float importe;

	public Cuenta() {
		// TODO Auto-generated constructor stub
		cod = proxcod;
		proxcod++;
		mesas = new ArrayList<>();
		pedidos = new ArrayList<>();
	}

	public void abrirCuenta() throws CuentaCerradaException {
		if (estado == estados.CERRADA) {
			throw new CuentaCerradaException();
		} else {
			estado = estados.ABIERTA;
		}
	}

	public void cerrarCuenta() throws CuentaCerradaException {
		if (estado == estados.CERRADA) {
			throw new CuentaCerradaException();
		} else {
			estado = estados.CERRADA;
		}
	}

	
	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public void agregarMesa(Mesa m) throws MesaNoDisponibleException {
		if (m.estaLibre()) {
			mesas.add(m);
			m.ocupar();
		} else {
			throw new MesaNoDisponibleException();

		}
	}

	public float calcularExtraPorExteriores() {
		float i = 1;
		for (Mesa m : mesas) {
			if (m instanceof Exterior) {
				i = i + (float) 0.10;
			}
		}
		return i;
	}

	public void agregarPedido(Pedido p) throws CuentaCerradaException {
		if (estado == estados.CERRADA) {
			throw new CuentaCerradaException();
		} else {
			pedidos.add(p);
		}
	}

	public void cancelarPedido(Pedido p) throws PedidoNoCancelableException, PedidoInexistenteException {
		if (pedidos.contains(p)) {
			try {
				p.cancelar();
			} catch (PedidoNoCancelableException e) {
				// TODO: handle exception
				System.out.println("El pedido que intento cancelar no puede ser cancelado.");
			}
		} else {
			throw new PedidoInexistenteException();
		}
	}

	public void calcularImporteTotal() throws CuentaSinPedidosException {
		if (!pedidos.isEmpty()) {
			for (Pedido p : pedidos) {
				if (!p.isCancelado()) {
					try {
						p.calcularTotal();
						importe = importe + p.getTotal();
					} catch (PedidoSinProductosException e) {
						System.out.println("Pedido sin productos");
					}
				}
			}
			if (!mesas.isEmpty()) {
				importe = importe * calcularExtraPorExteriores();
			}
		} else {
			throw new CuentaSinPedidosException();
		}
	}

	public void imprimirTicket() {
		System.out.println("Cuenta Nro: " + cod);
		if (mesas.isEmpty()) {
			System.out.println("Esta Cuenta no tiene mesas Asignadas");
		} else {
			System.out.println("Este Cuenta tiene: " + mesas.size() + " mesa/s asignada/s.");
			System.out.println("A utilizado las mesa/s: ");
			for (Mesa m : mesas) {
				System.out.println(m.cod);
			}
		}
		if (pedidos.isEmpty()) {
			System.out.println("Esta Cuenta no ha realizado Pedidos aun.");
		} else {
			System.out.println("Esta cuenta ha realizado los siguientes pedidos:");
			for (Pedido p : pedidos) {
				p.generarListado();
			}
			try {
				calcularImporteTotal();
			} catch (CuentaSinPedidosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("El importe total de esta Cuenta es: " + importe);
			System.out.println("Gracias!");
		}
	}
}
