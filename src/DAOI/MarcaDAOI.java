package DAOI;

import java.util.List;

import javax.persistence.Query;

import util.conexion;
import model.Marca;
import DAOL.MarcaDAOL;

public class MarcaDAOI implements MarcaDAOL {

	conexion cn = new conexion();
	
	@Override
	public List<Marca> leer() throws Exception {
		cn.abrir();
		
		Query q=cn.em.createQuery("select m from Marca m");
		List<Marca> marcas = q.getResultList();
		
		//List<Marca> lista = cn.em.createQuery("select m from Marca m").getResultList();
		
		// TODO Auto-generated method stub
		return marcas;
	}

}
