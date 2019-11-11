package pe.edu.upn.Minimarket1.model.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPedido")
	private Integer codPedido;

	@Column(name="fechaEmision")
	@Temporal(TemporalType.DATE)
	private Date fechaEmisionP;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codVenta")
	private Venta venta;
	
	public Pedido() {
		
	}
	
	public Pedido(String fechaEmisionP) throws ParseException {
		Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaEmisionP);
		
		this.fechaEmisionP = fecha;
	}

	public Date getFechaEmisionP() {
		return fechaEmisionP;
	}

	public void setFechaEmisionP(Date fechaEmisionP) {
		this.fechaEmisionP = fechaEmisionP;
	}
	
	public Venta getTransaccion() {
		return venta;
	}

	public void setTransaccion(Venta venta) {
		this.venta = venta;
	}
}
