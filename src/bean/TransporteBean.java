package bean;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import model.Marca;
import model.Modelo;
import model.TipoModelo;
import model.TipoTransporte;
import model.Transporte;
import DAOI.MarcaDAOI;
import DAOI.ModeloDAOI;
import DAOI.TipoModeloDAOI;
import DAOI.TipoTransporteDAOI;
import DAOI.TransporteDAOI;

public class TransporteBean {
	
	//DAOI
	private MarcaDAOI oMarcaDAOI= new MarcaDAOI();
	private ModeloDAOI oModeloDAOI= new ModeloDAOI();
	private TipoModeloDAOI oTipoModeloDAOI= new TipoModeloDAOI();
	private TipoTransporteDAOI oTipoTransporteDAOI= new TipoTransporteDAOI();
	private TransporteDAOI oTransporteDAOI= new TransporteDAOI();
	
	//Campos de la tabla principal
	public int idTransporte;
	public TipoTransporte idTipoTransporte;
	public String descTransporte;
	public double costo;
	public int stock;
	public Modelo idModelo;
	public Marca idMarca;
	public Date fechaRegistro;
	
	//Listas que vamos a usar
	private List<TipoTransporte> listaTipoTransporte;
	private List<Modelo> listaModelo;
	private List<Marca> listaMarca;
	private List<TipoModelo> listaTipoModelo;
	private List<Transporte> listaTransporte;
	
	//Tamaño de la lista principal
	private int listaTransporte_size;
	
	//Booleano para editar
	private boolean sw_edit;
	
	//Fila seleccionada
	private int fila_seleccionada;

	
	public void llenar_combo_box() throws Exception{
		listaMarca=oMarcaDAOI.leer();
		listaModelo=oModeloDAOI.leer();
		listaTipoTransporte=oTipoTransporteDAOI.leer();
	}
	
	public boolean accion_insertar() throws Exception{
		sw_edit=false;
		llenar_combo_box();
		return sw_edit;
	}
	
	public boolean accion_editar() throws Exception{
		sw_edit=true;
		llenar_combo_box();
		return sw_edit;
	}
	
	public void listar_por_descripcion() throws Exception{
		Transporte oTransporte= new Transporte();
		
		oTransporte.setDescTransporte(getDescTransporte());
		listaTransporte=oTransporteDAOI.buscar(oTransporte);
		listaTransporte_size=listaTransporte.size();
	}
	
	public void agregar() throws Exception{
		Transporte oTransporte=new Transporte();
		oTransporte.setIdTransporte(getIdTransporte());
		oTransporte.setIdTipoTransporte(getIdTipoTransporte());
		oTransporte.setDescTransporte(getDescTransporte());
		oTransporte.setCosto(getCosto());
		oTransporte.setStock(getStock());
		oTransporte.setIdModelo(getIdModelo());
		oTransporte.setIdMarca(getIdMarca());
		oTransporte.setFechaRegistro(getFechaRegistro());
		
		oTransporteDAOI.insertar(oTransporte);
	}
	
	public void editar() throws Exception{
		Transporte oTransporte=new Transporte();
		oTransporte.setIdTransporte(getIdTransporte());
		oTransporte.setIdTipoTransporte(getIdTipoTransporte());
		oTransporte.setDescTransporte(getDescTransporte());
		oTransporte.setCosto(getCosto());
		oTransporte.setStock(getStock());
		oTransporte.setIdModelo(getIdModelo());
		oTransporte.setIdMarca(getIdMarca());
		oTransporte.setFechaRegistro(getFechaRegistro());
		
		oTransporteDAOI.modificar(oTransporte);
	}
	
	public void borrar() throws Exception{
		Transporte oTransporte= new Transporte();
		oTransporte.setIdTransporte(fila_seleccionada);
		oTransporteDAOI.eliminar(oTransporte);
		limpiar();
	}
	
	public void limpiar(){
		setIdTransporte(0);
		setDescTransporte(null);
		setFechaRegistro(null);
		setCosto(0);
		setStock(0);
		
		setIdMarca(new Marca());
		setIdTipoTransporte(new TipoTransporte());
		setIdModelo(new Modelo());
	}
	
	public void seleccionar_fila(ActionEvent e)
	{
		String fila=e.getComponent().getAttributes().get("attr_idTransporte").toString();
		System.out.println(fila);
		fila_seleccionada=Integer.parseInt(fila);
	}
	
	public int getIdTransporte() {
		return idTransporte;
	}

	public void setIdTransporte(int idTransporte) {
		this.idTransporte = idTransporte;
	}

	public TipoTransporte getIdTipoTransporte() {
		return idTipoTransporte;
	}

	public void setIdTipoTransporte(TipoTransporte idTipoTransporte) {
		this.idTipoTransporte = idTipoTransporte;
	}

	public String getDescTransporte() {
		return descTransporte;
	}

	public void setDescTransporte(String descTransporte) {
		this.descTransporte = descTransporte;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Modelo getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(Modelo idModelo) {
		this.idModelo = idModelo;
	}

	public Marca getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Marca idMarca) {
		this.idMarca = idMarca;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public List<TipoTransporte> getListaTipoTransporte() {
		return listaTipoTransporte;
	}

	public void setListaTipoTransporte(List<TipoTransporte> listaTipoTransporte) {
		this.listaTipoTransporte = listaTipoTransporte;
	}

	public List<Modelo> getListaModelo() {
		return listaModelo;
	}

	public void setListaModelo(List<Modelo> listaModelo) {
		this.listaModelo = listaModelo;
	}

	public List<Marca> getListaMarca() {
		return listaMarca;
	}

	public void setListaMarca(List<Marca> listaMarca) {
		this.listaMarca = listaMarca;
	}

	public List<TipoModelo> getListaTipoModelo() {
		return listaTipoModelo;
	}

	public void setListaTipoModelo(List<TipoModelo> listaTipoModelo) {
		this.listaTipoModelo = listaTipoModelo;
	}

	public List<Transporte> getListaTransporte() {
		return listaTransporte;
	}

	public void setListaTransporte(List<Transporte> listaTransporte) {
		this.listaTransporte = listaTransporte;
	}

	public int getListaTransporte_size() {
		return listaTransporte_size;
	}

	public void setListaTransporte_size(int listaTransporte_size) {
		this.listaTransporte_size = listaTransporte_size;
	}

	public boolean isSw_edit() {
		return sw_edit;
	}

	public void setSw_edit(boolean sw_edit) {
		this.sw_edit = sw_edit;
	}

	public int getFila_seleccionada() {
		return fila_seleccionada;
	}

	public void setFila_seleccionada(int fila_seleccionada) {
		this.fila_seleccionada = fila_seleccionada;
	}
	
	
	@PostConstruct
	public void init() {
	    idTipoTransporte=new TipoTransporte();
	    idModelo = new Modelo();
	    idMarca = new Marca();
	    
	}
}
