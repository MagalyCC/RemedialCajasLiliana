package app.remedial.DAO;

import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
	//DAO actualizar
		public void updateJPA(Libro entity) throws Exception {
	        try {
	            em.merge(entity);
	        } catch (Exception e) {
	            throw new Exception("Erro actualizar Cliente " +e.getMessage());
	        }
	    }
		
	//DAO borrar
	    public void deleteId(String categoria) throws Exception {
	        try {
	            em.remove(read(categoria));
	        } catch (Exception e) {
	            throw new Exception("Error Eliminar Cliente " +e.getMessage());
	        }
	    }

	//DAO buscar
	    public Libro read(String categoria) throws Exception {
	        try {
	            return em.find(Libro.class, categoria);
	        } catch (Exception e) {
	            throw new Exception("Erro leer Cliente " +e.getMessage());
	        }
	    }





	//NOOO DAO buscar debuelve lista este no se esta usando
		public List<Libro> getLibros(String categoria) {
			String jpql= "Select c from Libro c where c.categoria =?1";
			Query q = em.createQuery(jpql, Libro.class);
			q.setParameter(1, categoria);
			return (List<Libro>) q.getResultList();
		}
}
