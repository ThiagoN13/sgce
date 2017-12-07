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
    
    public void cadastro(String data, double valor_em_preco, int quantidade_de_aparelhos, int consumo_em_horas, int id_aprelho, int id_usuario, int id_bandeira){
   	 try{
            String sql= "INSERT INTO historico_consumo (data_atual, valor_em_preco, quantidade_de_aparelhos, consumo_em_horas, id_aprelho, id_usuario, id_bandeira) VALUES (?,?,?,?,?,?)";
            Connection con = (Connection) conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, data);
            stmt.setDouble(2, valor_em_preco);
            stmt.setInt(3, quantidade_de_aparelhos);
            stmt.setInt(4, consumo_em_horas);
            stmt.setInt(5, id_aprelho);
            stmt.setInt(6, id_usuario);
            stmt.setInt(7, id_bandeira);
            stmt.execute();
            stmt.close();
            con.close();
            System.out.println("here");

        }catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
   }
	
	public ArrayList<Consumo> listar(int id_usuario){
        ArrayList<Consumo> consumos = new ArrayList<Consumo>();
        Consumo consumo;
        try{
            Connection con = (Connection) conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM historico_consumo WHERE id_usuario");
            stmt.setInt(1, id_usuario);
            ResultSet rs = stmt.executeQuery();
            stmt.close();
            con.close();
            while(rs.next()){
            	consumo = new Consumo();
            	consumo.usuario.setId_usuario(rs.getInt("id_usuario"));
            	consumo.setData(rs.getString("data"));
            	consumo.setValor_em_preco(rs.getDouble("valor_em_preco"));
            	consumo.setQuantidade_de_aparelhos(rs.getInt("quantidade_de_aparelhos"));
            	consumo.setQuantidade_da_potencia(rs.getInt("quantidade_da_potencia"));
            	consumos.add(consumo);
            }

        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        } 
        
        return consumos;
    }
	
	public ArrayList<Consumo> consumoTotal(int id_usuario){
        ArrayList<Consumo> consumos = new ArrayList<Consumo>();
        Consumo consumo;
        try{
            Connection con = (Connection) conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("SELECT SUM (valor_em_preco) FROM historico_consumo WHERE id_usuario=?");
            stmt.setInt(1, id_usuario);
            ResultSet rs = stmt.executeQuery();
            stmt.close();
            con.close();
            while(rs.next()){
            	consumo = new Consumo();
            	consumo.usuario.setId_usuario(rs.getInt("id_usuario"));
            	consumo.setData(rs.getString("data"));
            	consumo.setValor_em_preco(rs.getDouble("valor_em_preco"));
            	consumo.setQuantidade_de_aparelhos(rs.getInt("quantidade_de_aparelhos"));
            	consumo.setQuantidade_da_potencia(rs.getInt("quantidade_da_potencia"));
            	consumos.add(consumo);
            }

        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        } 
        
        return consumos;
    }
}
