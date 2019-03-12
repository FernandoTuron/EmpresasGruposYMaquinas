package es.ftm.gxgz.calculadoraproduccion.controller;

import java.net.URL;
import java.util.ResourceBundle;

import es.ftm.gxgz.calculadoraproduccion.model.Configuracion;
import es.ftm.gxgz.calculadoraproduccion.model.Empresa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class VentanaPrincipalController implements Initializable {
	//private Empresa empresa;
	
    @FXML    
    private Label lblPie;
    
    @FXML
    void handleArchivoConfiguracionAction(ActionEvent event) {
    	System.out.println("Archivo-Configuracion");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
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