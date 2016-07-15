package DAOI;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.swing.JOptionPane;

import util.conexion;
import model.Usuario;
import DAOL.UsuarioDAOL;

public class UsuarioDAOI implements UsuarioDAOL
{
    conexion cn=new conexion();
	@Override
	public String validar(Usuario obj) throws Exception 
	{
	  cn.abrir();
	  String resultado="ERROR";
	  String sentencia="select u from Usuario u where u.usuario =:usuario and u.clave =:clave";
	  Query q=cn.em.createQuery(sentencia);
	  q.setParameter("usuario",obj.getUsuario());
      q.setParameter("clave",obj.getClave());
      List<Usuario> lista=new ArrayList<Usuario>();
      lista=q.getResultList();
      int cantidad=lista.size();
      if(cantidad==0)
      {
    	  resultado="ERROR";
      }
      else
      {
    	  resultado="PRINCIPAL";
      }
		return resultado;
	}
	

}
