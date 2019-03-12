package es.ftm.gxgz.calculadoraproduccion.model;

public class GrupoMaquina {
	private String idGrupoMaquina;
	private String nombre;
	private String descripcion;	
	
	public GrupoMaquina(String idGrupoMaquina, String nombre) {
		this.idGrupoMaquina = idGrupoMaquina;
		this.nombre = nombre;
	}
	
	public String getIdGrupoMaquina() {
		return idGrupoMaquina;
	}
	public void setIdGrupoMaquina(String idGrupoMaquina) {
		this.idGrupoMaquina = idGrupoMaquina;
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
}
