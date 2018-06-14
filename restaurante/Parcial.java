package restaurante;

public class Parcial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Restaurante res = new Restaurante("Asador Criollo");
		res.crearMesaExterior(4);
		res.crearMesaInterior(2);
		res.crearMesaInterior(4);
		res.crearCuenta();
		try {
		res.mostrarMesasLibres();
		res.asignarMesa(res.getCuentas().get(0));
		
		
		
		}catch (RestoSinMesasException e) {
			System.out.println("No hay mesas libres en este momento");
		}catch (MesaNoDisponibleException e) {
			System.out.println("No hay mesas libres en este momento");
		}
		
		Pedido p1 = new A_Domicilio("Av De Mayo 866");
		p1.setCancelable(true);
		Producto r1 = new Comida("Asado", 5);
		
		try {
			p1.agregarProducto(r1);
		} catch (TipoInvalidoException | ProductoNoEnviableException e) {
			// TODO Auto-generated catch block
			System.out.println("Ocurrio Un problema Con el Producto");
			e.printStackTrace();
		}
		try {
			res.getCuentas().get(0).agregarPedido(p1);
		} catch (CuentaCerradaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("La cuenta esta Cerrada.");
		}
		
		Pedido p2 = new Local();
		Producto r21 = new Bebida("Vino", 6);
		Producto r22 = new Comida("Asado", 5);
		
		try {
			p2.agregarProducto(r21);
			p2.agregarProducto(r22);
			res.getCuentas().get(0).agregarPedido(p2);
		} catch (TipoInvalidoException | ProductoNoEnviableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Ocurrio Un problema Con el Producto");
		} catch (CuentaCerradaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("La cuenta esta Cerrada.");
		}
		Pedido p3 = new Local();
		Producto r31 = new Bebida("Vino", 7);
		Producto r32 = new Comida("Asado", 5);
		
		try {
			p3.agregarProducto(r31);
			p3.agregarProducto(r32);
			res.getCuentas().get(0).agregarPedido(p3);
		} catch (TipoInvalidoException | ProductoNoEnviableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Ocurrio Un problema Con el Producto");
		} catch (CuentaCerradaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("La cuenta esta Cerrada.");
		}
		try {
			p1.cancelar();
		} catch (PedidoNoCancelableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Este pedido no puede ser cancelado.");
		}
		try {
			res.getCuentas().get(0).cerrarCuenta();
		} catch (CuentaCerradaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("La cuenta esta Cerrada.");
		}
		res.getCuentas().get(0).imprimirTicket();
		
	}

}
