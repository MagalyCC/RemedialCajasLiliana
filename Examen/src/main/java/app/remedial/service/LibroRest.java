package app.remedial.service;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Path;

@Path("ex")
public class LibroRest {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/json")
	@Path("login{correo}/{contrasena}")
	public String login(@PathParam("correo") String correo, @PathParam("contrasena") String contrasena) {
		try {
			String rol = lo.buscarPersona(correo, contrasena);
			if (rol.equals("Cliente")) {
				return "ok";
			} else {
				return rol;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Error al loguearse";
		}
	}
}
