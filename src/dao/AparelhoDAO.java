package dao;

import model.Aparelho;
import model.Conexao;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AparelhoDAO {
	Conexao conexao;

    public AparelhoDAO(){
        conexao = new Conexao();
    }

    public void cadastro(String nome_aparelho, long potencia, String comodo, int id_usuario){
    	 try{
             String sql= "INSERT INTO aparelho (nome_aparelho, potencia, comodo, id_usuario) VALUES (?,?,?,?)";
             Connection con = (Connection) conexao.getConnection();
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
    
    public ArrayList<Aparelho> listar(int id_usuario, String comodo){
        ArrayList<Aparelho> aparelhos = new ArrayList<Aparelho>();
        Aparelho aparelho;
        try{
            Connection con = (Connection) conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM aparelho WHERE id_usuario=? AND comodo=?");
            stmt.setInt(1, id_usuario);
            stmt.setString(2, comodo);
            ResultSet rs = stmt.executeQuery();
            stmt.close();
            con.close();
            while(rs.next()){
            	aparelho = new Aparelho();
            	aparelho.setId_aparelho(rs.getInt("id_aparelho"));
            	aparelho.setNome(rs.getString("nome_aparelho"));
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
