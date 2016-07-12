package DAOI;

import java.util.List;

import util.conexion;
import model.Modelo;
import DAOL.ModeloDAOL;

public class ModeloDAOI  implements ModeloDAOL{

	conexion cn = new conexion();
	@Override
	public List<Modelo> leer() throws Exception {
		cn.abrir();
		List<Modelo> lista = cn.em.createQuery("select m from Modelo m").getResultList();
		// TODO Auto-generated method stub
		return lista;
	}

}
