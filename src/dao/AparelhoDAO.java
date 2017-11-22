package dao;
import model.Aparelho;
import model.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.sql.Connection;

public class AparelhoDAO {
	Conexao conexao;

    public AparelhoDAO(){
        conexao = new Conexao();
    }

    public void cadastro(String nome_aparelho, long potencia, String comodo){
    	 try{
             String sql= "INSERT INTO aparelho (nome_aparelho, potencia, comodo) VALUES (?,?,?)";
             Connection con = conexao.getConnection();
             PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
             stmt.setString(1, nome_aparelho);
             stmt.setLong(2, potencia);
             stmt.setString(3, comodo);
             stmt.execute();
             stmt.close();
             con.close();
             System.out.println("here");

         }catch(Exception e){
             System.out.println("Erro: "+e.getMessage());
         }
    }
    
    public ArrayList<Aparelho> listar(){
        ArrayList<Aparelho> aparelhos = new ArrayList<Aparelho>();
        Aparelho aparelho;
        try{
            Connection con = conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("Select * from aparelho");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            	aparelho = new Aparelho();
            	aparelho.setId_aparelho(rs.getInt("id_aparelho"));
            	aparelho.setNome(rs.getString("nome"));
            	aparelho.setPotencia(rs.getLong("potencia"));
            	aparelho.setComodo(rs.getString("comodo"));
                aparelhos.add(aparelho);
            }

        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        } 
        
        return aparelhos;
    }
}
