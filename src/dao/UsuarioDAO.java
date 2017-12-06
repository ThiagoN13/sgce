package dao;

import model.Usuario;
import model.Conexao;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuarioDAO {
	Conexao conexao;

    public UsuarioDAO(){
        conexao = new Conexao();
    }
    
    public void cadastro(String nome, String login, String email, String senha, String tipo_usuario){
   	 try{
            String sql= "INSERT INTO usuario (nome, login, email, senha, tipo_usuario) VALUES (?,?,?,?,?)";
            Connection con = (Connection) conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, login);
            stmt.setString(3, email);
            stmt.setString(4, senha);
            stmt.setString(5, tipo_usuario);
            stmt.execute();
            stmt.close();
            con.close();
            System.out.println("here");

        }catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
   }
    
    public Usuario login(String email, String senha){
        Usuario usuario = new Usuario();
        try{
            Connection con = (Connection) conexao.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM usuario WHERE email=? AND senha=?");
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            stmt.close();
            con.close();
            while(rs.next()){
            	usuario.setEmail(rs.getString("email"));
            	usuario.setSenha(rs.getString("senha"));
            }

        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        } 
        
        return usuario;
    }
}
