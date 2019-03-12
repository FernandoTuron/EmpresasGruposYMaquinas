package es.ftm.gxgz.calculadoraproduccion.model;

import java.io.InputStream;
import java.util.Properties;

public class Configuracion {	
	private String rutaBBDD;
	private String empresaPredeterminada;
	private String user;
	private String userName;
	
	private Properties properties;
	private InputStream RUTACONFIG;		
	
	public Configuracion() {
		this.properties = new Properties();
		this.RUTACONFIG = getClass().getClassLoader().getResourceAsStream("config\\config.properties");
		
		this.leerConfiguracion();
	}
	
	public String getRutaBBDD() {
		return rutaBBDD;
	}
	
	public void setRutaBBDD(String rutaBBDD) {
		this.rutaBBDD = rutaBBDD;
	}
	
	public String getEmpresaPredeterminada() {
		return empresaPredeterminada;
	}
	
	public void setEmpresaPredeterminada(String empresaPredeterminada) {
		this.empresaPredeterminada = empresaPredeterminada;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	private void leerConfiguracion(){
		try {
			// load a properties file
			properties.load(RUTACONFIG);

			// get the property value and print it out
			this.rutaBBDD = properties.getProperty("ruta");
			this.empresaPredeterminada = properties.getProperty("empresa");
			this.user = properties.getProperty("user");
			this.userName = properties.getProperty("userName");
			
			System.out.println("INFO -> Se ha establecido la siguiente ruta de acceso a la BBDD: " + this.rutaBBDD);
			System.out.println("INFO -> Se ha establecido la siguiente empresa predeterminada: " + this.empresaPredeterminada);
			System.out.println("INFO -> Se ha establecido el siguiente usuario: " + this.user);
			System.out.println("INFO -> Se ha establecido el siguiente nombre de usuario: " + this.userName);
		}
		
		catch(Exception ex) {
			System.out.println("ERROR -> Se ha producido el siguiente mensaje al leer la configuración: " + ex.getMessage());
		}		
	}		
}
