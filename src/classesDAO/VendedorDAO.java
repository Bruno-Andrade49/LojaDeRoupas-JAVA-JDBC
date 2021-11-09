package classesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classesBean.Venda;
import classesBean.Vendedor;
import conectaPg.Conecta;

public class VendedorDAO {

	private Connection con;

	public VendedorDAO() throws SQLException, ClassNotFoundException {
		con = Conecta.criarConexao();
	}

	public void cadastrarVendedor(Vendedor ven) {
		String sql = "INSERT INTO Vendedor(cpf, sexo, nome, endereco, salario) VALUES(?,?,?,?,?)"; // Comando SQL

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, ven.getCpf());
			preparador.setString(2, ven.getSexo());
			preparador.setString(3, ven.getNome());
			preparador.setString(4, ven.getEndereco());
			preparador.setDouble(5, ven.getSalario());

			preparador.execute();
			preparador.close();
			
			System.out.println("");
			System.out.println("Inserção realizada!");

		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
	}

	public void updateVendedor(Vendedor ven) {
		String sql = "UPDATE Vendedor SET salario = ? WHERE cpf = ?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setDouble(1, ven.getSalario());
			preparador.setString(2, ven.getCpf());
			preparador.execute();
			preparador.close();
			System.out.println("");
			System.out.println("Alteração realizada!");
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
	}

	public void deleteVendedor(Vendedor ven) {
		
		String sql = "DELETE FROM Vendedor WHERE cpf = ?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setString(1, ven.getCpf());

			preparador.execute();

			preparador.close();

			System.out.println("");
			System.out.println("Deleção realizada!");

		} catch (SQLException e) {

			System.out.println("Erro - " + e.getMessage());

		}

	}
	
	public List<Vendedor> listarvendedores() {

		String sql = "SELECT * FROM Vendedor";

		List<Vendedor> lista = new ArrayList<Vendedor>();

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultados = preparador.executeQuery();

			while (resultados.next()) {

				Vendedor vendedor = new Vendedor();

				vendedor.setCpf(resultados.getString("cpf"));
				vendedor.setSexo(resultados.getString("sexo"));
				vendedor.setNome(resultados.getString("nome"));
				vendedor.setEndereco(resultados.getString("endereco"));
				vendedor.setSalario(resultados.getDouble("salario"));
				

				lista.add(vendedor);
			}
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}

		return lista;

	}
}
