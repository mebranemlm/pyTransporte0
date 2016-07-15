package DAOI;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import util.conexion;
import model.Transporte;
import DAOL.TransporteDAOL;

public class TransporteDAOI implements TransporteDAOL {

	conexion cn = new conexion();
	@Override
	public void insertar(Transporte obj) throws Exception {
		cn.abrir();
		try {
			cn.em.getTransaction().begin();
			cn.em.persist(obj);
			cn.em.getTransaction().commit();
			
		} catch (Exception e) {
			cn.em.getTransaction().rollback();
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(Transporte obj) throws Exception {
		cn.abrir();
		try {
			cn.em.getTransaction().begin();
			cn.em.merge(obj);
			cn.em.getTransaction().commit();
			
		} catch (Exception e) {
			cn.em.getTransaction().rollback();
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		
	}

	@Override
	public void eliminar(Transporte obj) throws Exception {
		cn.abrir();
		try {
			
			cn.em.getTransaction().begin();
			Transporte oTransporte=cn.em.find(Transporte.class, obj.getIdTransporte());
			cn.em.remove(oTransporte);
			cn.em.getTransaction().commit();
			
		} catch (Exception e) {
			cn.em.getTransaction().rollback();
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		
	}

	@Override
	public List<Transporte> buscar(Transporte obj) throws Exception {
		//Abro conexion
		cn.abrir();
		
		//Creo el parámetro
		String descTransporte=obj.getDescTransporte();
		descTransporte='%'+descTransporte.toLowerCase() +'%';
		
		//System.out.println("Descripción: "+descTransporte);
		//Creo sentencia
		String sentencia= "select t, "
				+"t.idTipoTransporte.idTipoTransporte, "
				+"t.idMarca.idMarca, "
				+"t.idModelo.idModelo "
				+"from Transporte t "
				+"where lower(t.descTransporte) like :descTransporte";
		
		//Creo query
		Query q= cn.em.createQuery(sentencia);
		
		//Envío el parámetro al query
		q.setParameter("descTransporte", descTransporte);
		
		//Ejecuto el query (me devuelve una lista array)
		List<Object[]> lista_objetos =q.getResultList();

		//Creo lista Transporte vacía
		List<Transporte> lista = new ArrayList<Transporte>();
		
		//Convierto lista de arrays en lista de transportes
		//Lleno la lista vacía con los transportes de la lista array
		for(Object objs[]: lista_objetos){
			Transporte transporte=(Transporte) objs[0];
			lista.add(transporte);
		}

		//Retorno la lista de transportes
		return lista;
	}

	@Override
	public List<Transporte> leer() throws Exception {
		cn.abrir();
		List<Object[]> lista_objetos = cn.em.createQuery(
				"select t, "
				+"t.idTipoTransporte.idTipoTransporte, "
				+"t.idMarca.idMarca, "
				+"t.idModelo.idModelo, "
				+"from Transporte t").getResultList();

		// TODO Auto-generated method stub
		
		List<Transporte> lista = new ArrayList<Transporte>();
		
		for(Object objs[]: lista_objetos){
			Transporte transporte=(Transporte) objs[0];
			lista.add(transporte);
		}
		return lista;
	}

}
