package restaurante;


import java.util.ArrayList;
import java.util.List;

public class Pedido implements Cancelable {
	protected float total;
	protected List<Producto> productos;
	protected boolean cancelable;
	protected boolean cancelado;
	
	public boolean isCancelado() {
		return cancelado;
	}

	public void setCancelado(boolean cancelado) {
		this.cancelado = cancelado;
	}

	public Pedido() {
		// TODO Auto-generated constructor stub
		total = 0;
		productos = new ArrayList<>();
		cancelable = false;
		cancelado = false;
	}
	
	public boolean isCancelable() {
		return cancelable;
	}

	public void setCancelable(boolean cancelable) {
		this.cancelable = cancelable;
	}
	

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public void agregarProducto(Producto p) throws TipoInvalidoException, ProductoNoEnviableException {
		if (p instanceof Comida || p instanceof Bebida){
			if (this instanceof A_Domicilio && p instanceof Bebida) {
				throw new ProductoNoEnviableException();
			}else {
				productos.add(p);
				System.out.println("Se agrego el producto: "+p.toString());
			}
		}else {
			throw new TipoInvalidoException();
		}
	}
	public void calcularTotal()throws PedidoSinProductosException {
		if(productos.isEmpty()) {
			throw new PedidoSinProductosException();
		}else {
			for(Producto p : productos) {
				total = total + p.getImporte();
			}
			if(this instanceof A_Domicilio) {
				total = total * (float)1.20;
			}
		}
	}

	public void cancelar() throws PedidoNoCancelableException{
		// TODO Auto-generated method stub
		if(isCancelable()) {
			cancelado = true;
			System.out.println("Pedido cancelado con exito.");
		}else {
			throw new PedidoNoCancelableException();
		}
		
	}

	public void generarListado() {
		// TODO Auto-generated method stub
		if(isCancelado()) {
			System.out.println("El siguiente pedido fue CANCELADO:");
		}else {
			System.out.println("Este pedido Consta de: ");
		}
		for(Producto p: productos) {
			System.out.println(p.toString());
		}
		
	}

}
