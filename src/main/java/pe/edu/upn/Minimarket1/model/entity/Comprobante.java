package pe.edu.upn.Minimarket1.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Comprobante")
public class Comprobante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codComprobante")
	private Integer codComprobante;
	
	@Column(name="tipoPago",length=10)
	private String tipoPago;
	
	@Column(name="fechaEmision")
	@Temporal(TemporalType.DATE)
	private Date fechaEmision;
	
	@Column(name="subtotal")
	private float subtotal;
	
	@Column(name="total")
	private float total;
	
	@Column(name="descuento")
	private float descuento;
	
	@Column(name="estado",length=1,nullable=false)
	private char estado;
	
	@OneToMany(mappedBy = "comprobante", fetch = FetchType.LAZY)
	private List<Venta> ventas;
}
