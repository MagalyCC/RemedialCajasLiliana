package app.remedial.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import app.remedial.ON.libroON;
import app.remedial.modelo.Categoria;
import app.remedial.modelo.Libro;

import javax.ws.rs.Path;

@Path("ex")
public class LibroRest {
	@Inject
	private libroON libroOn;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/json")
	@Path("login{categoria}")
	public List<Categoria> login(@PathParam("categoria") String categoria) {
		return libroOn.buscarLibro(categoria);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/json")
	@Path("resumen{categoria}")
	public String resumen(@PathParam("categoria") String categoria) {
		List<Categoria> c = libroOn.buscarLibro(categoria);
		String men = "";
		for (int i = 0; i < c.size(); i++) {
			men = "Titulo " + c.get(i).getLibro().getTitulo() + " Stock " + c.get(i).getLibro().getStock() + "Id: "
					+ c.get(i).getLibro().getIdLibro() + men;

		}

		return men;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/json")
	@Path("reservar")
	public void reservar(int id) {
		libroOn.actualizarLibro(id);
	}
}
