package DAOI;

import java.util.List;

import util.conexion;
import model.TipoModelo;
import DAOL.TipoModeloDAOL;

public class TipoModeloDAOI implements TipoModeloDAOL {

	conexion cn = new conexion();
	@Override
	public List<TipoModelo> leer() throws Exception {
		cn.abrir();
		List<TipoModelo> lista = cn.em.createQuery("select tm from TipoModelo tm").getResultList();
		return lista;
	}

}
