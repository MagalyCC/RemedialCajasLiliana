package app.remedial.bean;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import app.remedial.ON.libroON;
import app.remedial.modelo.Categoria;
import app.remedial.modelo.Libro;

@Named
@RequestScoped
public class LibroBean {
	@Inject
	private libroON libroOn;
	private String titulo;
	private int stock;
	private List<Categoria> categoria;
	
	public LibroBean() {
		init();
	}

	public void init() {
		titulo = null;
		//categoria=null;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}


	
	
	
	

	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}

	public void doCrear(){
		Libro lib= new Libro();
		lib.setTitulo(titulo);
		lib.setStock(stock);
		//lib.setCategoria(null);
	}
	
	
}
