package facade;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Aparelho;
import model.Consumo;
import dao.ConsumoDAO;

@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})

@Consumes({MediaType.APPLICATION_JSON})

@Path("/consumos")
public class ConsumoFacade {
	ConsumoDAO consumoDAO = new ConsumoDAO();
	static ArrayList<Consumo> consumos = new ArrayList<Consumo>();
	
	static {
		consumos.add(new Consumo("12/11/2017", 1200, 3, 2, new Aparelho("TV",100, "quarto"), 120));
	}
	
	@GET
	@Path("/listar")
	@Produces("application/json")
	public ArrayList<Consumo> listarTodos(){
		return consumos;
//		return consumoDAO.listar(id_usuario);
	}
	
	@GET
	@Path("/consumototal")
	@Produces("application/json")
	public int consumoTotal(int id_usuario){
		return consumoDAO.consumoTotal(id_usuario);
	}
	
	@POST 
	@Path("/inserir")
	@Consumes("application/json")
	public void executaPost(Consumo consumo) throws Exception{
		consumo.setValor_em_preco(consumo.calculaConsumoDiario(consumo.aparelho, consumo.getConsumo_em_horas(), consumo.bandeira, consumo.getQuantidade_de_aparelhos()));
		consumos.add(consumo);
//		consumoDAO.cadastro(consumo.getData(), consumo.getValor_em_preco(), consumo.getQuantidade_de_aparelhos(), consumo.getConsumo_em_horas(), consumo.aparelho.getId_aparelho(), consumo.usuario.getId_usuario(), consumo.bandeira.getId_bandeira());
    }
}
