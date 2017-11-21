package facade;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.AparelhoDAO;
import model.Aparelho;
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})

@Consumes({MediaType.APPLICATION_JSON})


@Path("/aparelhos")
public class AparelhoFacade {
	static ArrayList<Aparelho> aparelhos = new ArrayList<Aparelho>();
	
	@GET
	public ArrayList<Aparelho> executaGet(){
		return aparelhos;
	}
	
	@POST 
	public void postMessage(Aparelho aparelho) throws Exception{
		AparelhoDAO aparelhoDao = new AparelhoDAO();
		aparelhoDao.cadastro(aparelho.getNome(), aparelho.getPotencia(), aparelho.getComodo());
    }
}