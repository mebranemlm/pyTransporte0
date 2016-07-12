package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.faces.mgbean.ManagedBeanPreProcessingException.Type;

@Entity
@Table(name="tbl_usuario")
public class Usuario {

	@Id
	private String usuario;
	private String clave;
	
	@Temporal(TemporalType.DATE)
	private Date f_regstro;
	private int estado;
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public Date getF_regstro() {
		return f_regstro;
	}
	public void setF_regstro(Date f_regstro) {
		this.f_regstro = f_regstro;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	
}
