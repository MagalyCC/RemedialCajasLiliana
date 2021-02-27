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
	private String cate;
	private ArrayList<Categoria> listCat = null;
	
	public LibroBean() {
		init();
	}

	public void init() {
		titulo = null;
		cate=null;
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


	
	



	public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	public ArrayList<Categoria> getListCat() {
		//return listCat;
		
		
		if (listCat == null) {
			listCat = new ArrayList<Categoria>();
			for (int i = 0; i < 6; i++) {
				Categoria p = new Categoria();
				p.setLibro(null);
				listCat.add(p);
			}
		} else {
			listCat = (ArrayList<Categoria>) libroOn.buscarCategoria();
		}
		return listCat;
		
	}

	public void setListCat(ArrayList<Categoria> listCat) {
		this.listCat = listCat;
	}

	public void doCrear(){
		Libro lib= new Libro();
		lib.setTitulo(titulo);
		lib.setStock(stock);
		
		Categoria cat=new Categoria();
		cat.setLibro(lib);
		cat.setTipo(cate);
		libroOn.Crear(lib, cat);
	}
	
	
}
