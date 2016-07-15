package bean;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;


import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.validation.ValidationException;

import DAOI.UsuarioDAOI;
import model.Usuario;

public class UsuarioBean 
{

	public String usuario;
	public String clave;
	public Date f_regstro;
	public String estado;
	
	UsuarioDAOI oUsuarioDAOI=new UsuarioDAOI();
	
	public String validar() throws Exception
	{
	    Thread.sleep(5000);
		Usuario oUsuario=new Usuario();
		
		oUsuario.setUsuario(getUsuario());
		oUsuario.setClave(getClave());
		String resultado=oUsuarioDAOI.validar(oUsuario);
		
	
		return resultado;
	}
	
	//metodo para validar con textos (primerfaces)
	public void validaUsuario(FacesContext arg0,UIComponent arg1,Object arg2) throws Exception	
	{
		//El arg2 es el valor que le enviamos. Si el length (tamaño) es menor que 1
		//entonces retornamos el mensaje de "Debe ingresar un valor"
		if(((String)arg2).length()<1)
		{
			throw new ValidatorException(new FacesMessage("Debe ingresar un valor"));			
		}
		else
		{
			return;
		}
	}

	
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
