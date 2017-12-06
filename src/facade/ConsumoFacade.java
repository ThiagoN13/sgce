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

public class ConsumoFacade {
	ConsumoDAO consumoDAO = new ConsumoDAO();
	static ArrayList<Consumo> consumos = new ArrayList<Consumo>();
	
	@GET
	@Path("/consumos")
	@Produces("application/json")
	public ArrayList<Consumo> total(int id_usuario){
		return consumoDAO.listar(id_usuario);
	}
	
	@GET
	@Path("/consumototal")
	@Produces("application/json")
	public ArrayList<Consumo> consumoTotal(int id_usuario){
		return consumoDAO.consumoTotal(id_usuario);
	}
}
