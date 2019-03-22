package es.ftm.gxgz.calculadoraproduccion.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import es.ftm.gxgz.calculadoraproduccion.model.Configuracion;
import es.ftm.gxgz.calculadoraproduccion.model.Empresa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VentanaPrincipalController implements Initializable {
	private Empresa empresa;
	private Configuracion configuracion;
	
    @FXML    
    private Label lblPie;
    
    @FXML
    private MenuItem idMnuArchivoCofiguracion;

    @FXML
    private MenuItem idMnuArchivoSalir;    

    @FXML
    void handleArchivoConfiguracionAction(ActionEvent event) throws IOException {
    	System.out.println("INFO -> Se ha elegido menu Archivo~Configuracion.");

    	this.abrirVentanaConfiguracion();   	
    }
        
    @FXML
    void handleArchivoSalirAction(ActionEvent event) {
    	System.out.println("INFO -> Se ha elegido menu Archivo~Salir.");
    	System.out.println("INFO -> Se cierra la aplicación. Adios.");
    	System.exit(0);
    }    
    
    @FXML
    void handleTestAbrirTestsAction(ActionEvent event) {
    	System.out.println("INFO -> Se ha elegido menu Test~AbrirTests.");

    	this.abrirVentanaTests();  
    }    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
    }	
    
    public void setEmpresa(Empresa empresa,Configuracion configuracion) {    
    	this.empresa = empresa;
    	this.configuracion = configuracion;
    	
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
    
    public void abrirVentanaConfiguracion() {
    	String tituloVentana;
    	
        try {
        	tituloVentana = "Utilidades GXGZ - Configuración";
        	
        	FXMLLoader fXMLloader = new FXMLLoader(getClass().getClassLoader().getResource("config\\ventanaConfiguracion.fxml"));			        	
        	
        	VentanaConfiguracionController controller = new VentanaConfiguracionController();
        	
        	fXMLloader.setController(controller);
			
        	BorderPane root = (BorderPane) fXMLloader.load();
        	
        	controller.setEmpresa(empresa,configuracion);
        	
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setOpacity(1);			
			stage.setTitle(tituloVentana);	        
			stage.setScene(new Scene(root,450,225));	        
			stage.showAndWait();		
        } 
        
        catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
    }
    
    public void abrirVentanaTests() {
    	String tituloVentana;
    	
        try {
        	tituloVentana = "Utilidades GXGZ - Tests";
        	
        	FXMLLoader fXMLloader = new FXMLLoader(getClass().getClassLoader().getResource("config\\ventanaTests.fxml"));			        	
        	
        	VentanaTestsController controller = new VentanaTestsController();
        	
        	fXMLloader.setController(controller);
			
        	BorderPane root = (BorderPane) fXMLloader.load();
        	
        	controller.setEmpresa(empresa,configuracion);
        	
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setOpacity(1);			
			stage.setTitle(tituloVentana);	        
			stage.setScene(new Scene(root,650,550));	        
			stage.showAndWait();
		
        } 
        
        catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }    
}