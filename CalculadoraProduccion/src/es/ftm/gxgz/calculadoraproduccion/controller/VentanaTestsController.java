package es.ftm.gxgz.calculadoraproduccion.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.Map;
import java.util.TreeSet;
import java.util.TreeMap;

import es.ftm.gxgz.calculadoraproduccion.model.Configuracion;
import es.ftm.gxgz.calculadoraproduccion.model.Empresa;
import es.ftm.gxgz.calculadoraproduccion.model.GrupoMaquina;
import es.ftm.gxgz.calculadoraproduccion.model.Maquina;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class VentanaTestsController implements Initializable {
	private int numMaximoEmpresas;
	private int numMaximoGruposMaquinas;
	private int numMaximoMaquinas;
	
	private Set<Empresa> listaEmpresas;

    @FXML
    private TextField txtNumMaximoEmpresas;

    @FXML
    private TextField txtNumMaximoGruposMaquina;    

    @FXML
    private TextField txtNumMaximoMaquinas;    

    @FXML
    private Label lblEmpresasCreadas;

    @FXML
    private Label lblGruposMaquinaCreadas;

    @FXML
    private Label lblMaquinasCreadas;    

    @FXML
    private TextArea idTxtAreaEjecucion;
    
    @FXML    
    private Label lblPie;		    
    
    @FXML
    void verEmpresasClic(ActionEvent event) {
    	this.idTxtAreaEjecucion.appendText("EJECUCION -> 	Se recorre con un Stream el TreeSet de Empresas." + "\n");
    	
    	this.listaEmpresas.stream()
    		.forEach(e->
    			this.idTxtAreaEjecucion.appendText(
    					"\t" +
    					e.getIdEmpresa() + 
    					"\t" +
    					e.getNombre() +
    					"\n"
    				)
    			);
    }

    @FXML
    void verGruposDeMaquinasClic(ActionEvent event) {
    	this.idTxtAreaEjecucion.appendText("EJECUCION -> 	Se recorre con un Stream el TreeSet de Grupos de Maquinas." + "\n");
    	
    	for(Empresa empresa:this.listaEmpresas) {
			this.idTxtAreaEjecucion.appendText(
					"\tEmpresa: " +
					empresa.getIdEmpresa() + 
					"\t" +
					empresa.getNombre() +
					"\n"
				);
			
	    	empresa.getListaGrupoMaquinas().stream()
	    		.forEach(gm->
	    			this.idTxtAreaEjecucion.appendText(
	    					"\t\t" +
	    					gm.getIdGrupoMaquina() + 
	    					"\t" +
	    					gm.getNombre() +
	    					"\n"
	    				)
	    			);
    	}
    }

    @FXML
    void verMaquinasClic(ActionEvent event) {
    	this.idTxtAreaEjecucion.appendText("EJECUCION -> 	Se recorre con un Stream el TreeSet de Maquinas." + "\n");
    	
    	for(Empresa empresa:this.listaEmpresas) {
			this.idTxtAreaEjecucion.appendText(
					"\tEmpresa: " +
					empresa.getIdEmpresa() + 
					"\t" +
					empresa.getNombre() +
					"\n"
				);
			
			for(GrupoMaquina grupoMaquina:empresa.getListaGrupoMaquinas()) {
				this.idTxtAreaEjecucion.appendText(
						"\t\tGrupo Maquina: " +								
						grupoMaquina.getIdGrupoMaquina() + 
						"\t" +
						grupoMaquina.getNombre() +
						"\n"
					);
			
		    	empresa.getListaMaquinas().stream()
		    		.forEach(m->
		    			this.idTxtAreaEjecucion.appendText(
		    					"\t\t\t" +
		    					m.getIdMaquina() + 
		    					"\t" +
		    					m.getNombre() +
		    					"\n"
		    				)
		    			);
			}
    	}
    }     
	
    @FXML
    public void crearEmpresasClic(ActionEvent event){
    	this.listaEmpresas = new TreeSet<Empresa>();
    	Empresa empresa;    	
    	StringBuilder idEmpresa = null, nombre = null;    	
    	
    	System.out.println("EJECUCION -> Se intentará dar de alta " + numMaximoEmpresas + " empresas.");    	   	

    	for(int i = 1; i <= this.numMaximoEmpresas; i++) {
    		int id = (int) (Integer.parseInt(this.txtNumMaximoEmpresas.getText())*Math.random());
    		idEmpresa = new StringBuilder();
    		nombre = new StringBuilder();    		
    		
    		idEmpresa.append("EMP" + String.format("%03d", id));
    		nombre.append("Nombre Empresa ");
    		nombre.append(idEmpresa);
    		empresa = new Empresa(idEmpresa.toString(),nombre.toString(),1);    		
    		
    		this.idTxtAreaEjecucion.appendText("EJECUCION -> Se intenta dar de alta la empresa " + idEmpresa + "\n");
    		if(this.listaEmpresas.add(empresa)) {
    			this.idTxtAreaEjecucion.appendText("RESULTADO -> \tExito\n");
    		}
    		else {
    			this.idTxtAreaEjecucion.appendText("RESULTADO -> \tNo es posible. Ya existe\n");
    		}    	
    		
    	}   
    	
    }

    @FXML
    void crearGruposDeMaquinasClic(ActionEvent event) {
    	GrupoMaquina grupoMaquina;
    	StringBuilder idGrupoMaquina = null, nombre = null;
    	
    	for(Empresa empresa:this.listaEmpresas) {    		
        	for(int i = 1; i <= this.numMaximoGruposMaquinas; i++) {
        		int id = (int) (Integer.parseInt(this.txtNumMaximoGruposMaquina.getText())*Math.random());
        		
        		idGrupoMaquina = new StringBuilder();
        		nombre = new StringBuilder();    		
        		
        		idGrupoMaquina.append("GM" + String.format("%02d", id));
        		nombre.append("Nombre Grupo Maquina ");
        		nombre.append(idGrupoMaquina);
        		grupoMaquina = new GrupoMaquina(idGrupoMaquina.toString(),nombre.toString());    		
        		
        		this.idTxtAreaEjecucion.appendText("EJECUCION -> Se intenta dar de alta el Grupo de Maquinas " + idGrupoMaquina + " en la empresa " + empresa.getIdEmpresa() + "\n");
        		if(empresa.addListaGrupoMaquinas(grupoMaquina)) {
        			this.idTxtAreaEjecucion.appendText("RESULTADO -> \tExito\n");
        		}
        		else {
        			this.idTxtAreaEjecucion.appendText("RESULTADO -> \tNo es posible. Ya existe\n");
        		} 
        		
        	}      		
    		
    	}
    	
    }

    @FXML
    void crearMaquinasClic(ActionEvent event) {
    	Maquina maquina;
    	StringBuilder idMaquina = null, nombre = null;
    	
    	for(Empresa empresa:this.listaEmpresas) {
    		for(GrupoMaquina grupoMaquina:empresa.getListaGrupoMaquinas()) {
	        	for(int i = 1; i <= this.numMaximoMaquinas; i++) {
	        		int id = (int) (Integer.parseInt(this.txtNumMaximoMaquinas.getText())*Math.random());
	        		
	        		idMaquina = new StringBuilder();
	        		nombre = new StringBuilder();    		
	        		
	        		idMaquina.append("MAQ" + String.format("%03d", id));
	        		nombre.append("Nombre Maquina ");
	        		nombre.append(idMaquina);
	        		maquina = new Maquina(grupoMaquina,idMaquina.toString(),nombre.toString());    		
	        		
	        		this.idTxtAreaEjecucion.appendText("EJECUCION -> Se intenta dar de alta la Máquina " + idMaquina + " del grupo de máquinas " + grupoMaquina.getIdGrupoMaquina() + " en la empresa " + empresa.getIdEmpresa() + "\n");
	        		if(empresa.addListaMaquinas(maquina)) {
	        			this.idTxtAreaEjecucion.appendText("RESULTADO -> \tExito\n");
	        		}
	        		else {
	        			this.idTxtAreaEjecucion.appendText("RESULTADO -> \tNo es posible. Ya existe\n");
	        		} 
	        		
	        	}
    		
    		}    		

    	}
    }

    @FXML
    void establecerNumeroEmpresasClic(ActionEvent event) {
    	try {
    		numMaximoEmpresas = (int) (Integer.parseInt(this.txtNumMaximoEmpresas.getText())*Math.random());    		
    		this.lblEmpresasCreadas.setText(String.format("%d", numMaximoEmpresas));
    	}
    	
    	catch(Exception exc) {
    		System.out.println("ERROR -> No ha establecido un número máximo de empresas: " + exc.getMessage());
    		
    		String mensaje = "Ha de introducir un número positivo.";
        		
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error al establecer Empresas");
    		alert.setHeaderText(null);
    		alert.setContentText(mensaje);
    		alert.showAndWait();    		
    	}
    }

    @FXML
    void establecerNumeroGruposMaquinasClic(ActionEvent event) {
    	try {
    		numMaximoGruposMaquinas = (int) (Integer.parseInt(this.txtNumMaximoGruposMaquina.getText())*Math.random());    		
    		this.lblGruposMaquinaCreadas.setText(String.format("%d", numMaximoGruposMaquinas));
    	}
    	
    	catch(Exception exc) {
    		this.idTxtAreaEjecucion.appendText("EJECUCION -> Se va a generar un listado de Grupos de Máquina por Empresas" + "\n");
    		
    		String mensaje = "Ha de introducir un número positivo.";
        		
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error al establecer Grupos de Máquinas");
    		alert.setHeaderText(null);
    		alert.setContentText(mensaje);
    		alert.showAndWait();    		
    	}
    }

    @FXML
    void establecerNumeroMaquinasClic(ActionEvent event) {
    	try {
    		numMaximoMaquinas = (int) (Integer.parseInt(this.txtNumMaximoMaquinas.getText())*Math.random());    		
    		this.lblMaquinasCreadas.setText(String.format("%d", numMaximoMaquinas));
    	}
    	
    	catch(Exception exc) {
    		System.out.println("ERROR -> No ha establecido un número máximo de máquinas: " + exc.getMessage());
    		
    		String mensaje = "Ha de introducir un número positivo.";
        		
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error al establecer Máquinas");
    		alert.setHeaderText(null);
    		alert.setContentText(mensaje);
    		alert.showAndWait();    		
    	}

    }	
    
    @FXML
    void obtenerInformacion(ActionEvent event) {
    	this.idTxtAreaEjecucion.appendText("EJECUCION -> Se va a obtener un TreeMap de Grupos de Máquinas como clave y la lista de Empresas asociadas como valor.\n");
    	
    	Map<GrupoMaquina,Set<Empresa>> listaGrupoMaquinasYEmpresas = new TreeMap<GrupoMaquina,Set<Empresa>>();    	
    	
    	for(Empresa empresa:this.listaEmpresas) {        	    		
    		for(GrupoMaquina grupoMaquina:empresa.getListaGrupoMaquinas()) {
    			listaGrupoMaquinasYEmpresas.put(grupoMaquina, listaEmpresaPorGrupoMaquinas(grupoMaquina));    			
    		}
    	}
    	
    	listaGrupoMaquinasYEmpresas
    		.forEach((key,value)->
    			{
    				this.idTxtAreaEjecucion.appendText("\t\t" + key.getIdGrupoMaquina() + "\t" + key.getNombre() + "\n");
    				for(Empresa empresa:value)
    					this.idTxtAreaEjecucion.appendText("\t\t\t" + empresa.getIdEmpresa() + "\t" + empresa.getNombre() + "\n");
    			}
    		);
    	
    	//
    }    
    
    private Set<Empresa> listaEmpresaPorGrupoMaquinas(GrupoMaquina grupoMaquina) {
    	Set<Empresa> listaEmpresasPorGrupoMaquinas = new TreeSet<Empresa>();
    	for(Empresa empresa:this.listaEmpresas) {
    		if(empresa.getListaGrupoMaquinas().contains(grupoMaquina)) {
    			listaEmpresasPorGrupoMaquinas.add(empresa);
    		}
    	}
		
    	return listaEmpresasPorGrupoMaquinas;    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
    public void setEmpresa(Empresa empresa,Configuracion configuracion) {    
    	StringBuilder pieFormulario = new StringBuilder();
    	pieFormulario.append("Empresa: ");
    	pieFormulario.append(empresa.getIdEmpresa());
    	pieFormulario.append(" - ");
    	pieFormulario.append(empresa.getNombre());
    	pieFormulario.append("\t Usuario: ");
    	pieFormulario.append(configuracion.getUser());
    	pieFormulario.append(" - " );
    	pieFormulario.append(configuracion.getUserName());
    	
    	lblPie.setText(pieFormulario.toString());
    }	

}
