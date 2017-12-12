package facade;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Usuario;
import dao.UsuarioDAO;

@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})

@Consumes({MediaType.APPLICATION_JSON})

@Path("/usuario")
public class UsuarioFacade {
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			
	@POST 
	@Path("/cadastro")
	@Produces("application/json")
	public void cadastro(Usuario usuario) throws Exception{
		usuarios.add(usuario);
//		usuarioDAO.cadastro(usuario.getNome(), usuario.getLogin(), usuario.getEmail(), usuario.getSenha(), usuario.getTipo_usuario());
    }
	
	@POST 
	@Path("/login")
	@Produces("application/json")
	public Usuario login(Usuario usuario) throws Exception{
		
		return usuario;
//		return usuarioDAO.login(usuario.getEmail(), usuario.getSenha());
    }
}
