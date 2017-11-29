package facade;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Usuario;
import dao.UsuarioDAO;

@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})

@Consumes({MediaType.APPLICATION_JSON})

@Path("/usuarios")

public class UsuarioFacade {
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

	@GET
	@Produces("application/json")
	public ArrayList<Usuario> executaGet(){
        return usuarios;
	}
	
	@POST 
	public void executaPost(Usuario usuario) throws Exception{
		usuarioDAO.cadastro(usuario.getNome(), usuario.getLogin(), usuario.getEmail(), usuario.getSenha(), usuario.getTipo_usuario());
    }
}
