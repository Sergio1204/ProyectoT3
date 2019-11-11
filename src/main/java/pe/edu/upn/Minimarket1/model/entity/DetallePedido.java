package pe.edu.upn.Minimarket1.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Detallepedido")
public class DetallePedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDetallePedido")
	private Integer codDetallePedido;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codProducto")
	private Producto producto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codPedido")
	private Pedido pedido;
	
	@Column(name = "cantidad")
	private int cantidad;

	public DetallePedido(Producto producto, Pedido pedido, int cantidad) {
		this.producto = producto;
		this.pedido = pedido;
		this.cantidad = cantidad;
	}

	public Integer getCodDetallePedido() {
		return codDetallePedido;
	}

	public void setCodDetallePedido(Integer codDetallePedido) {
		this.codDetallePedido = codDetallePedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	} 
	
	
	
	
}
