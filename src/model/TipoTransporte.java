package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tipoTransporte")
public class TipoTransporte {
	
	@Id
	private int idTipoTransporte;
	private String descTipoTransporte;
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;
	public int getIdTipoTransporte() {
		return idTipoTransporte;
	}
	public void setIdTipoTransporte(int idTipoTransporte) {
		this.idTipoTransporte = idTipoTransporte;
	}
	public String getDescTipoTransporte() {
		return descTipoTransporte;
	}
	public void setDescTipoTransporte(String descTipoTransporte) {
		this.descTipoTransporte = descTipoTransporte;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	
	
}
