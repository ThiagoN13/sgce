package dao;
import java.sql.*;

public class Conexao {

	public Connection getConexaoMySQL() throws SQLException, ClassNotFoundException{
	    Class.forName("com.mysql.jdbc.Driver");

	    return DriverManager.getConnection(
	            String.format("jdbc:mysql://%s/%s", "localhost", "sgce"),
	            "root", 
	            ""
	    );        	
	}
	
	public void conectar() {
		try {
			this.getConexaoMySQL();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public boolean FecharConexao() throws ClassNotFoundException {
        try {
			this.getConexaoMySQL().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}