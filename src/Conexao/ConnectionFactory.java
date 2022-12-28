package Conexao;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public static Connection createConnection() {
		String stringDeConexao = "jdbc:mysql://localhost:3306/db_combustivel";
		String usuario = "root";
		String senha = "";
		Connection conexao = null;
		try {
			conexao = DriverManager.getConnection(stringDeConexao, usuario, senha);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conexao;
	}
}
