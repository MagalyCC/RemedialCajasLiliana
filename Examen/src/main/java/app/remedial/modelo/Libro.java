package app.remedial.modelo;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Libro implements Serializable{
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLibro;
	private String titulo;
	private int stock;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Libro")
	private List<Autores> ingreso=new ArrayList<Autores>();
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "Libro")
	private Categoria Categoria;
	
	public int getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public List<Autores> getIngreso() {
		return ingreso;
	}
	public void setIngreso(List<Autores> ingreso) {
		this.ingreso = ingreso;
	}

	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Categoria getCategoria() {
		return Categoria;
	}
	public void setCategoria(Categoria categoria) {
		Categoria = categoria;
	}
	

}
