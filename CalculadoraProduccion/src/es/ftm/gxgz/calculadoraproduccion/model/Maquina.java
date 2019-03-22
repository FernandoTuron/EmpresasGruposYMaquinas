package es.ftm.gxgz.calculadoraproduccion.model;

public class Maquina  implements Comparable<Maquina>{
	//El idGrupoMaquina esta formado por un prefijo de dos letras y tres digitos
	//El idMaquina esta formado por un prefijo de tres letras y tres digitos	
	private Empresa empresa;
	private GrupoMaquina grupoMaquina;
	private String idMaquina;
	private String nombre;
	private String descripcion;

	public Maquina(GrupoMaquina grupoMaquina, String idMaquina, String nombre) {
		this.grupoMaquina = grupoMaquina;
		this.idMaquina = idMaquina;
		this.nombre = nombre;		
	}

	@Override
	public int hashCode() {
		int result = 0;		
		
		result += Integer.parseInt(this.grupoMaquina.getIdGrupoMaquina().substring(3, 4))*100;		
		result += Integer.parseInt(this.getIdMaquina().substring(3, 5));
		
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
		 
		 Maquina otraMaquina = (Maquina) objeto;
		 if (nombre == null) {
			 if (otraMaquina.nombre != null) {
				 return false;
			 }
		 } 
		 else if (!nombre.equals(otraMaquina.nombre)) {
			 return false;
		 }
	 
		 return true;
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
	
	@Override
	public int compareTo(Maquina maquina) {
		// TODO Auto-generated method stub
		return this.idMaquina.compareTo(maquina.getIdMaquina());
	}	
}
