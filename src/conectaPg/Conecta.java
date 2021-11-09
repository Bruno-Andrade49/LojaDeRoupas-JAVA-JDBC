package conectaPg;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conecta {
	static final String URL = "jdbc:postgresql://localhost:5432/LojaDeRoupas";
	static final String USER = "postgres";
	static final String PASS = "1234567";
	
	public static Connection criarConexao() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		Connection conecta = DriverManager.getConnection(URL, USER, PASS);
		
		if(conecta != null) {
			
			return conecta;
		}
		System.out.println("Não conectado");
		return null;
	}
}
