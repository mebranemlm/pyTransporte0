package bean;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import model.Usuario;
import DAOI.UsuarioDAOI;

public class UsuarioBean {
	
	public String usuario;
	
	public String clave;

	public Date f_regstro;
	public int estado;
	
	//DAOI que usaremos
	private UsuarioDAOI oUsuarioDAOI = new UsuarioDAOI();
	
	//Creamos la función validar que usaremos:
	
	public String validar() throws Exception{
		//Esta es la función de espera
		Thread.sleep(5000);
		
		//Creamos el objeto Usuario que enviaremos
		Usuario oUsuario = new Usuario();
		oUsuario.setUsuario(getUsuario());
		oUsuario.setClave(getClave());
		
		//Obtenemos el resultado del DAO
		String resultado = oUsuarioDAOI.validar(oUsuario);
		
		//Retornamos el resultado (EXITO o ERROR)
		return resultado;
	}
	
	//Esta es la estructura que se usa para el Primefaces (FacesContext arg0,UIComponent arg1,Object arg2)
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
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	

}
