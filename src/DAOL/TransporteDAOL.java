package DAOL;

import java.util.List;

import model.Transporte;

public interface TransporteDAOL {
	
	
	
	//INSERTAR -> Mando: oTransporte Recupero: --
	public abstract void insertar(Transporte obj) throws Exception;
	
	//MODIFICAR -> Mando: oTransporte Recupero: --
	public abstract void modificar(Transporte obj) throws Exception;
	
	//ELIMINAR -> Mando: oTransporte Recupero: --
	public abstract void eliminar(Transporte obj) throws Exception;
	
	//BUSCAR -> Mando: oTransporte Recupero: List<oTransporte>
	public abstract List<Transporte> buscar(Transporte obj) throws Exception;
	
	//LEER -> Mando: -- Recupero: List<oTransporte>
	public abstract List<Transporte> leer() throws Exception;
}
