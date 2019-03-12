package es.ftm.gxgz.calculadoraproduccion.model;

public class Maquina {
	private String idMaquina;
	private String nombre;
	private String descripcion;
	
	private GrupoMaquina grupoMaquina;

	public Maquina(String idMaquina, String nombre, GrupoMaquina grupoMaquina) {
		this.idMaquina = idMaquina;
		this.nombre = nombre;
		this.grupoMaquina = grupoMaquina;
	}

	public String getIdMaquina() {
		return idMaquina;
	}

	public void setIdMaquina(String idMaquina) {
		this.idMaquina = idMaquina;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public GrupoMaquina getGrupoMaquina() {
		return grupoMaquina;
	}

	public void setGrupoMaquina(GrupoMaquina grupoMaquina) {
		this.grupoMaquina = grupoMaquina;
	}	
}
