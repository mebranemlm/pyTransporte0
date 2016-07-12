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
@Table(name="modelo")
public class Modelo {
	@Id
	private int idModelo;
	
	@ManyToOne
	@JoinColumn(name="idTipoModelo")
	private TipoModelo idTipoModelo;
	
	private String descModelo;
	
	//Faltaba esta tontería -> version para torpes
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;
	public int getIdModelo() {
		return idModelo;
	}
	public void setIdModelo(int idModelo) {
		this.idModelo = idModelo;
	}
	public TipoModelo getIdTipoModelo() {
		return idTipoModelo;
	}
	public void setIdTipoModelo(TipoModelo idTipoModelo) {
		this.idTipoModelo = idTipoModelo;
	}
	public String getDescModelo() {
		return descModelo;
	}
	public void setDescModelo(String descModelo) {
		this.descModelo = descModelo;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	
	
}
