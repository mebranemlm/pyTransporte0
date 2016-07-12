package DAOI;

import java.util.List;

import util.conexion;
import model.TipoTransporte;
import DAOL.TipoTransporteDAOL;

public class TipoTransporteDAOI implements TipoTransporteDAOL {

	conexion cn = new conexion();
	@Override
	public List<TipoTransporte> leer() throws Exception {
		cn.abrir();
		List<TipoTransporte> lista = cn.em.createQuery("select tt from TipoTransporte tt").getResultList();
		return lista;
	}

}
