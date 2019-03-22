package es.ftm.gxgz.calculadoraproduccion.model;

public class GrupoMaquina implements Comparable<GrupoMaquina>{
	//El idGrupoMaquina esta formado por un prefijo de dos letras y tres digitos
	private String idGrupoMaquina;
	private String nombre;
	private String descripcion;	
	
	public GrupoMaquina(String idGrupoMaquina, String nombre) {
		this.idGrupoMaquina = idGrupoMaquina;
		this.nombre = nombre;
	}
	
	@Override	
	public int hashCode() {
		int result = 0;		
		
		result = Integer.parseInt(this.getIdGrupoMaquina().substring(3, 4));		
		
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
		 
		 GrupoMaquina otroGrupoMaquina = (GrupoMaquina) objeto;
		 if (nombre == null) {
			 if (otroGrupoMaquina.nombre != null) {
				 return false;
			 }
		 } 
		 else if (!nombre.equals(otroGrupoMaquina.nombre)) {
			 return false;
		 }
	 
		 return true;
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

	@Override
	public int compareTo(GrupoMaquina grupoMaquina) {
		// TODO Auto-generated method stub
		return this.idGrupoMaquina.compareTo(grupoMaquina.getIdGrupoMaquina());
	}
}
