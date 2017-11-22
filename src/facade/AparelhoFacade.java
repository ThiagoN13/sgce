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
	AparelhoDAO aparelhoDao = new AparelhoDAO();
	static ArrayList<Aparelho> aparelhos = new ArrayList<Aparelho>();

	static {
		aparelhos.add(new Aparelho("TV", 12, "quarto"));
	}
	
	@GET
	@Produces("application/json")
	public ArrayList<Aparelho> executaGet(){
        return aparelhos;
//		return aparelhoDao.listar();
	}
	
	@POST 
	public void executaPost(Aparelho aparelho) throws Exception{
		aparelhoDao.cadastro(aparelho.getNome(), aparelho.getPotencia(), aparelho.getComodo());
    }
}