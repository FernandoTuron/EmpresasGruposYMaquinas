package es.ftm.gxgz.calculadoraproduccion.model;

import java.util.Set;
import java.util.TreeSet;

public class Empresa implements Comparable<Empresa>{
	//El idEmpresa esta formado por un prefijo y tres digitos
	private String idEmpresa;
	private String nombre;
	
	private boolean activo;	
	
	private Set<GrupoMaquina> listaGrupoMaquinas;
	private Set<Maquina> listaMaquinas;
	
	public Empresa(String idEmpresa, String nombre, int activo) {
		this.idEmpresa = idEmpresa;
		this.nombre = nombre;
		this.activo = (activo==1) ? true : false;
		
		this.listaGrupoMaquinas = new TreeSet<GrupoMaquina>();
		this.listaMaquinas = new TreeSet<Maquina>();
	}
	
	@Override
	public int hashCode() {
		int result = 0;		
		result = Integer.parseInt(this.idEmpresa.substring(4, 6));
		
		return result;
	}
	
	 @Override
	 public boolean equals(Object objeto) {
		 if (this == objeto) {
			 return true;
		 }
		 
		 if (objeto == null) {
			 return false;
		 }
		 
		 if (getClass() != objeto.getClass()) {
			 return false;
		 }
		 
		 Empresa otraEmpresa = (Empresa) objeto;
		 if (nombre == null) {
			 if (otraEmpresa.nombre != null) {
				 return false;
			 }
		 } 
		 else if (!nombre.equals(otraEmpresa.nombre)) {
			 return false;
		 }
	 
		 return true;
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

	public Set<GrupoMaquina> getListaGrupoMaquinas() {
		return listaGrupoMaquinas;
	}

	public boolean addListaGrupoMaquinas(GrupoMaquina grupoMaquina){
		return this.listaGrupoMaquinas.add(grupoMaquina);
	}

	public Set<Maquina> getListaMaquinas() {
		return listaMaquinas;
	}

	public boolean addListaMaquinas(Maquina maquina){
		return this.listaMaquinas.add(maquina);
	}

	@Override
	public int compareTo(Empresa empresa) {
		// TODO Auto-generated method stub
		return this.idEmpresa.compareTo(empresa.getIdEmpresa());
	}	
}
