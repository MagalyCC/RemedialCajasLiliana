package app.remedial.ON;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import app.remedial.DAO.libroDAO;
import app.remedial.modelo.Libro;

public class libroON {
	@Inject
	private libroDAO daolibro;
	
	//Registrar libros
		public boolean registrarlibro(Libro libro) throws Exception {
			try {
				daolibro.insertJPA(libro);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new Exception("Error al registrar");
			}
			return true;
		}
		public List<Libro> buscarLibro(String categoria){
			return daolibro.getLibros(categoria);
		}
}
