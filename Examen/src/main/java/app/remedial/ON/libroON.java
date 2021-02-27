package app.remedial.ON;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import app.remedial.DAO.libroDAO;
import app.remedial.modelo.Categoria;
import app.remedial.modelo.Libro;

public class libroON {
	@Inject
	private libroDAO daolibro;
	
	
		public List<Libro> buscarLibro(String categoria){
			return daolibro.getLibros(categoria);
		}
		
	
		
		public void Crear(Libro libro) {
			try {
				daolibro.insertJPA(libro);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//public List<Categoria> buscarCategoria(){
			//return ; 
		//}
		
	
		
		
}
