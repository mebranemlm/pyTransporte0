package DAOI;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import util.conexion;
import model.Usuario;
import DAOL.UsuarioDAOL;

public class UsuarioDAOI  implements UsuarioDAOL{

	//Primero instanciamos la conexion
	
	conexion cn = new conexion();
	
	@Override
	public String validar(Usuario obj) throws Exception {
		//Abrimos la conexion
		cn.abrir();
		
		//Declaramos el String que devolveremos (EXITO o ERROR), 
		//por defecto lo ponemos en "ERROR"
		String resultado="ERROR";
		
		//Declaramos la sentencia JPQL que usaremos.
		//El u.usuario y el u.clave tiene que ser el mismo de la base de datos
		//El "Usuario u" es el nombre de clase, no de la tabla, así que debe ir en mayúsculas 
		String sentencia= "select u from Usuario u where u.usuario = :usuario and u.clave=:clave";
		
		//Creamos el query:
		Query q =cn.em.createQuery(sentencia);
		
		//Enviamos los parámetros usuario y clave del objeto que estamos recibiendo
		//Se le ponen los mismos nombres que declaramos en la sentencia como :usuario y :clave
		q.setParameter("usuario", obj.getUsuario());
		q.setParameter("clave", obj.getClave());
		
		//Declaramos la lista de Usuarios en la que recibiremos al usuario encontrado
		List<Usuario> lista = new ArrayList<Usuario>();
		
		//Ejecutamos el query
		lista=q.getResultList();
		
		//Obtenemos el tamaño de la lista (cantidad de usuarios)
		int cantidad=lista.size();
		
		//Validamos. 
		//Si encontramos cero usuarios (cantidad=0), devolvemos "ERROR". 
		//Si encontramos al menos un usuario, devolvemos "EXITO".
		
		if(cantidad==0){
			resultado="ERROR";
		}else{
			resultado="EXITO";
		}
		
		//Retornamos el String resultante (ERROR o EXITO).
		return resultado;
	}

}
