package dao;

import model.Consumo;
import model.Conexao;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ConsumoDAO {
	Conexao conexao;

    public ConsumoDAO(){
        conexao = new Conexao();
    }
	
	public ArrayList<Consumo> listar(){
        ArrayList<Consumo> consumos = new ArrayList<Consumo>();
        Consumo consumo;
        try{
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM historico_consumo");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            	consumo = new Consumo();
            	consumo.setFk_usuario(rs.getInt("fk_usuario"));
            	consumo.setData(rs.getString("data"));
            	consumo.setValor_em_preco(rs.getDouble("valor_em_preco"));
            	consumo.setQuantidade_de_aparelhos(rs.getInt("quantidade_de_aparelhos"));
            	consumo.setQuantidade_da_potencia(rs.getInt("quantidade_da_potencia"));
            	consumos.add(consumo);
            }

        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        } 
        
        return aparelhos;
    }
	
}
