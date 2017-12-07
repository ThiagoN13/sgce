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

@Path("/aparelhos")
public class AparelhoFacade {
	AparelhoDAO aparelhoDao = new AparelhoDAO();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public ArrayList<Aparelho> executaGet(Aparelho aparelho){
		System.out.println(aparelho.getComodo());
		return aparelhoDao.listar(aparelho.usuario.getId_usuario(), aparelho.getComodo());
	}
	
	@POST 
	@Consumes({MediaType.APPLICATION_JSON})
	public void executaPost(Aparelho aparelho) throws Exception{
		aparelhoDao.cadastro(aparelho.getNome(), aparelho.getPotencia(), aparelho.getComodo(), aparelho.usuario.getId_usuario());
    }
}