package DAOL;

import java.util.List;

import model.TipoTransporte;

public interface TipoTransporteDAOL {

	public abstract List<TipoTransporte> leer()throws Exception;
}
