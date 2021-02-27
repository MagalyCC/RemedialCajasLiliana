package app.remedial.DAO;

import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import app.remedial.modelo.Categoria;
import app.remedial.modelo.Libro;
@Stateless
public class libroDAO {
	@Inject
	private Connection con;
	@Inject
	private EntityManager em;
	//DAO crear
	public boolean insertJPA(Libro entity) throws SQLException {
			em.persist(entity);
			return true;
		}
	public boolean insertCategoria(Categoria entity) throws SQLException {
		em.persist(entity);
		return true;
	}
	//DAO actualizar
		public void updateJPA(Libro entity) throws Exception {
	        try {
	            em.merge(entity);
	        } catch (Exception e) {
	            throw new Exception("Erro actualizar Cliente " +e.getMessage());
	        }
	    }
		
	//DAO borrar
	    public void deleteId(int id) throws Exception {
	        try {
	            em.remove(read(id));
	        } catch (Exception e) {
	            throw new Exception("Error Eliminar Cliente " +e.getMessage());
	        }
	    }

	//DAO buscar
	    public Libro read(int id) throws Exception {
	        try {
	            return em.find(Libro.class, id);
	        } catch (Exception e) {
	            throw new Exception("Erro leer Cliente " +e.getMessage());
	        }
	    }





	//NOOO DAO buscar debuelve lista este no se esta usando
		public List<Categoria> getLibros(String categoria) {
			String jpql= "Select c from Categoria c where c.tipo =?1";
			Query q = em.createQuery(jpql, Categoria.class);
			q.setParameter(1, categoria);
			return (List<Categoria>) q.getResultList();
		}
		
		
		public List<Categoria> getCategorias() {
			String jpql= "Select c from Categoria c ";
			Query q = em.createQuery(jpql, Categoria.class);
			return (List<Categoria>) q.getResultList();
		}
}
