package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tipoModelo")
public class TipoModelo {
	@Id
	private int idTipoModelo;
	private String descTipoModelo;
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;
	public int getIdTipoModelo() {
		return idTipoModelo;
	}
	public void setIdTipoModelo(int idTipoModelo) {
		this.idTipoModelo = idTipoModelo;
	}
	public String getDescTipoModelo() {
		return descTipoModelo;
	}
	public void setDescTipoModelo(String descTipoModelo) {
		this.descTipoModelo = descTipoModelo;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	} 
	
	
}
