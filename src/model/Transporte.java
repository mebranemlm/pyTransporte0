package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="transporte")
public class Transporte {
	@Id
	private int idTransporte;
	
	@ManyToOne
	@JoinColumn(name="idTipoTransporte")
	private TipoTransporte idTipoTransporte;
	
	private String descTransporte;
	private double costo;
	private int stock;
	
	@ManyToOne
	@JoinColumn(name="idModelo")
	private Modelo idModelo;
	
	@ManyToOne
	@JoinColumn(name="idMarca")
	private Marca idMarca;
	
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;

	public int getIdTransporte() {
		return idTransporte;
	}

	public void setIdTransporte(int idTransporte) {
		this.idTransporte = idTransporte;
	}

	public TipoTransporte getIdTipoTransporte() {
		return idTipoTransporte;
	}

	public void setIdTipoTransporte(TipoTransporte idTipoTransporte) {
		this.idTipoTransporte = idTipoTransporte;
	}

	public String getDescTransporte() {
		return descTransporte;
	}

	public void setDescTransporte(String descTransporte) {
		this.descTransporte = descTransporte;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Modelo getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(Modelo idModelo) {
		this.idModelo = idModelo;
	}

	public Marca getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Marca idMarca) {
		this.idMarca = idMarca;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	} 
	
	
	
}
