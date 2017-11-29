package facade;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Consumo;
import dao.ConsumoDAO;

@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})

@Consumes({MediaType.APPLICATION_JSON})

@Path("/consumos")

public class ConsumoFacade {
	ConsumoDAO consumoDAO = new ConsumoDAO();
	static ArrayList<Consumo> consumos = new ArrayList<Consumo>();
	
	@GET
	@Produces("application/json")
	public ArrayList<Consumo> executaGet(){
        return consumos;
	}
	
	@POST 
	public void executaPost(Consumo consumo) throws Exception{
		consumoDAO.cadastro(consumo.getData(), consumo.getQuantidade_de_aparelhos(), consumo.getConsumo_em_horas(), consumo.getFk_aparelho(), consumo.getFk_usuario());
    }
}
