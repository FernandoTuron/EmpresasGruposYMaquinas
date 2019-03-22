package es.ftm.gxgz.calculadoraproduccion.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import es.ftm.gxgz.calculadoraproduccion.model.Empresa;

public class BBDD {
	private String urlBBDD;
	private String empresaPredeterminada;
	private Connection connect;
	private PreparedStatement pst;
    private ResultSet rs;
    
	public void connect(String urlBBDD, String empresaPredeterminada){
		this.urlBBDD = urlBBDD;
		this.empresaPredeterminada = empresaPredeterminada;
		
		try {
			this.connect = DriverManager.getConnection("jdbc:sqlite:" + this.urlBBDD);
		}	        
		
		catch (SQLException ex) {
			System.err.println("ERROR -> No se ha podido conectar a la base de datos. " + ex.getMessage());
		}
	}

	public void close(){
		try {
			rs.close();
	        pst.close();	        
		
			connect.close();
		} 
		
		catch (SQLException ex) {
			//
		}
	}
	
	public void establecerEmpresaPredeterminada() throws SQLException {		
        try {
        	pst = connect.prepareStatement("SELECT IDEmpresa, NOMBRE FROM Empresa WHERE IdEmpresa=?");
        	pst.setString(1, this.empresaPredeterminada);	        	
            rs = pst.executeQuery();
	            
            while(rs.next()) {		            	
            	System.out.println("INFO -> Se ha conectado a la BBDD en la Empresa: " + rs.getString(1) + "-" + rs.getString(2));	            	
            }	            
	        	
            rs.close();
	        pst.close();	        	
        } 
	        
        catch (SQLException ex) {
        	System.out.println("ERROR -> No se ha podido establecer la empresa predeterminada. " + ex.getMessage());
        }
	        
        try {
        	rs.close();
			pst.close();
		} 
        
        catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		}		
	}
	
	public Empresa readEmpresa(String id){
		Empresa empresa = null;
		
		try {			
	        pst = connect.prepareStatement("SELECT IDEmpresa, NOMBRE, ACTIVO FROM Empresa WHERE IdEmpresa=?");
	        pst.setString(1, this.empresaPredeterminada);	        	
	           rs = pst.executeQuery();
	            
	        while(rs.next()) {		            	
	        	empresa = new Empresa(rs.getString(1),rs.getString(2),rs.getInt(3));	            		            	        	
	        } 
		}
	        
	    catch (SQLException ex) {
	    	System.out.println("ERROR -> No se puede acceder a la empresa de Id " + this.empresaPredeterminada + ": " + ex.getMessage());
		}
	        
	    finally{	    	
	        try {
	        	rs.close();
				pst.close();
			} 
	        
	        catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}			
	
		return empresa;
	}
}
