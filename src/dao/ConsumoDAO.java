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
    
    public void cadastro(String data, double valor_em_preco, int quantidade_de_aparelhos, int consumo_em_horas, int fk_aparelho, int fk_usuario){
   	 try{
            String sql= "INSERT INTO historico_consumo (data, double valor_em_preco, quantidade_de_aparelhos, consumo_em_horas, fk_aparelho, fk_usuario) VALUES (?,?,?,?,?,?)";
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, data);
            stmt.setDouble(2, valor_em_preco);
            stmt.setInteger(3, quantidade_de_aparelhos);
            stmt.setInteger(4, consumo_em_horas);
            stmt.setInteger(5, fk_aparelho);
            stmt.setInteger(6, fk_usuario);
            stmt.execute();
            stmt.close();
            con.close();
            System.out.println("here");

        }catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
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
	
	public ArrayList<Consumo> consumoTotal(){
        ArrayList<Consumo> consumos = new ArrayList<Consumo>();
        Consumo consumo;
        try{
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("SELECT SUM (valor_em_preco) FROM `historico_consumo`");
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
