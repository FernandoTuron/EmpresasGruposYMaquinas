package es.ftm.gxgz.calculadoraproduccion.model;

import java.util.Set;

public class Empresa {
	private String idEmpresa;
	private String nombre;
	
	private boolean activo;
	
	private Set<String> listaGrupoMaquinas;
	private Set<Maquina> listaMaquinas;
	
	public Empresa(String idEmpresa, String nombre, int activo) {
		this.idEmpresa = idEmpresa;
		this.nombre = nombre;
		this.activo = (activo==1) ? true : false;
	}

	public String getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}	
}
