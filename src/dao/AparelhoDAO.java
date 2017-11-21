package dao;
import model.Conexao;
import java.sql.PreparedStatement;
import java.sql.Connection;

public class AparelhoDAO {
	Conexao conexao;

    public AparelhoDAO(){
        conexao = new Conexao();
    }

    public void cadastro(String nome, long potencia, String comodo){
    	 try{
             String sql= "INSERT INTO aparelho (nome) VALUES (?,?,?;";
             Connection con = conexao.getConnection();
             PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
             stmt.setString(1, nome);
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
}
