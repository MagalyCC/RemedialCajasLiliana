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
	
	
		public List<Categoria> buscarLibro(String categoria){
			return daolibro.getLibros(categoria);
			//return daolibro.getCategorias();
		}
		
	
		
		public void Crear(Libro libro, Categoria categoria) {
			try {
				daolibro.insertJPA(libro);
				daolibro.insertCategoria(categoria);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		public List<Categoria> buscarCategoria(){
			return daolibro.getCategorias(); 
		}
		public void actualizarLibro(int id) {
			try {
				Libro l=daolibro.read(id);
				int sto=l.getStock();
				int rest=sto-1;
				l.setStock(rest);
				daolibro.updateJPA(l);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
		
}
