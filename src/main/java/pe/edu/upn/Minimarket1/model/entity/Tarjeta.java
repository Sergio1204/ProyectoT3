package pe.edu.upn.Minimarket1.model.entity;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Tarjeta")
public class Tarjeta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codT;
	
	@Column(name = "numero", length = 16)
	private String numero;
	
	@Column(name = "fechaVencimiento")
	private String fechaVencimiento;
	
	@Column(name = "codigoSeguridad")
	private int codigoSeguridad;
	
	@Column(name = "saldo")
	private float saldo;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	public Tarjeta() {
		
	}
	
	public Tarjeta(String numero, String fechaVencimiento, int codigoSeguridad, float saldo, String nombre,
			String apellidos) {
		this.numero = numero;
		this.fechaVencimiento = fechaVencimiento;
		this.codigoSeguridad = codigoSeguridad;
		this.saldo = saldo;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}


	public int getCod() {
		return codT;
	}

	public void setCod(int codT) {
		this.codT = codT;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public int getCodigoSeguridad() {
		return codigoSeguridad;
	}

	public void setCodigoSeguridad(int codigoSeguridad) {
		this.codigoSeguridad = codigoSeguridad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	
}
