package es.ftm.gxgz.calculadoraproduccion.controller;

import java.net.URL;
import java.util.ResourceBundle;

import es.ftm.gxgz.calculadoraproduccion.model.Configuracion;
import es.ftm.gxgz.calculadoraproduccion.model.Empresa;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class VentanaConfiguracionController  implements Initializable {
	private Empresa empresa;
	private Configuracion configuracion;
	
    @FXML    
    private Label lblPie;	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
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

}
