package es.ftm.gxgz.calculadoraproduccion.application;
	
import es.ftm.gxgz.calculadoraproduccion.controller.BBDD;
import es.ftm.gxgz.calculadoraproduccion.controller.VentanaPrincipalController;
import es.ftm.gxgz.calculadoraproduccion.model.Configuracion;
import es.ftm.gxgz.calculadoraproduccion.model.Empresa;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	private Configuracion configuracion;

	private Empresa empresa;	
	private String tituloVentana;	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			this.configuracion = new Configuracion();
			
			BBDD miBBDD = new BBDD();
			miBBDD.connect(configuracion.getRutaBBDD(),configuracion.getEmpresaPredeterminada());
			
			empresa = miBBDD.readEmpresa(this.configuracion.getEmpresaPredeterminada());
			miBBDD.close();
			
			tituloVentana = empresa.getNombre();
			
			FXMLLoader fXMLloader = new FXMLLoader(getClass().getClassLoader().getResource("config\\ventanaPrincipal.fxml"));
			
			//Crear instancia del controlador
			VentanaPrincipalController controller = new VentanaPrincipalController();
			
			//Se establece en FXMLloader
			fXMLloader.setController(controller);		

			BorderPane root = fXMLloader.load();
			
			controller.setEmpresa(empresa,configuracion);			
						
			Scene scene = new Scene(root);
			
	        primaryStage.setTitle(tituloVentana);	        
	        primaryStage.setScene(scene);	        
	        primaryStage.show();			
		} 
		
		catch(Exception e) {
			e.printStackTrace();
		} 
		
		catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
