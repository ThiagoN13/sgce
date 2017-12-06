package facade;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.AparelhoDAO;
import model.Aparelho;

@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})

@Consumes({MediaType.APPLICATION_JSON})

@Path("/aparelhos")
public class AparelhoFacade {
	AparelhoDAO aparelhoDao = new AparelhoDAO();
	
	@GET
	@Produces("application/json")
	public ArrayList<Aparelho> executaGet(int id_usuario){
		System.out.println(id_usuario);
		return aparelhoDao.listar(id_usuario);
	}
	
	@POST 
	public void executaPost(Aparelho aparelho) throws Exception{
		aparelhoDao.cadastro(aparelho.getNome(), aparelho.getPotencia(), aparelho.getComodo(), aparelho.usuario.getId_usuario());
    }
}