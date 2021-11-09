package classesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classesBean.Roupa;
import conectaPg.Conecta;

public class RoupaDAO {

	private Connection con;

	public RoupaDAO() throws SQLException, ClassNotFoundException {

		con = Conecta.criarConexao();

	}

	public void cadastrarRoupa(Roupa roupa) {

		String sql = "INSERT INTO roupa (codR, tamanho, tipo, cor, marca, genero, "
				+ "qtd) VALUES (?, ?, ?, ?, ?, ?, ?)"; // Comando SQL

		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setString(1, roupa.getCodR());
			preparador.setString(2, roupa.getTamanho());
			preparador.setString(3, roupa.getTipo());
			preparador.setString(4, roupa.getCor());
			preparador.setString(5, roupa.getMarca());
			preparador.setString(6, roupa.getGenero());
			preparador.setInt(7, roupa.getQtd());

			preparador.execute();
			preparador.close();

			System.out.println("");
			System.out.println("Inserção realizada!");

		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
	}

	public void alterarMarcaRoupa(Roupa roupa) {

		String sql = "UPDATE Roupa SET marca = ? WHERE codR = ?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setString(1, roupa.getMarca());
			preparador.setString(2, roupa.getCodR());

			preparador.execute();
			preparador.close();

			System.out.println("");
			System.out.println("Alteração realizada!");

		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}

	}

	public void alterarTipoRoupa(Roupa roupa) {

		String sql = "UPDATE Roupa SET tipo = ? WHERE codR = ?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setString(1, roupa.getTipo());
			preparador.setString(2, roupa.getCodR());

			preparador.execute();
			preparador.close();

			System.out.println("");
			System.out.println("Alteração realizada!");

		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}

	}

	public void deletarRoupa(Roupa roupa) {

		String sql = "DELETE FROM Roupa WHERE codR = ?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setString(1, roupa.getCodR());

			preparador.execute();
			preparador.close();

			System.out.println("");
			System.out.println("Roupa - ID: " + roupa.getCodR() + ", excluída com sucesso!");

		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}

	}

	public List<Roupa> listarRoupaPorTamanho() {

		String sql = "SELECT * FROM Roupa GROUP BY tamanho, codR";

		List<Roupa> lista = new ArrayList<Roupa>();

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultados = preparador.executeQuery();

			while (resultados.next()) {

				Roupa roupa = new Roupa();

				roupa.setCodR(resultados.getString("codR"));
				roupa.setTamanho(resultados.getString("tamanho"));
				roupa.setTipo(resultados.getString("tipo"));
				roupa.setCor(resultados.getString("cor"));
				roupa.setMarca(resultados.getString("marca"));
				roupa.setGenero(resultados.getString("genero"));
				roupa.setQtd(resultados.getInt("qtd"));

				lista.add(roupa);
			}
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}

		return lista;

	}

	public List<Roupa> listarRoupaPorTipo() {

		String sql = "SELECT * FROM Roupa GROUP BY tipo, codR";

		List<Roupa> lista = new ArrayList<Roupa>();

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultados = preparador.executeQuery();

			while (resultados.next()) {

				Roupa roupa = new Roupa();

				roupa.setCodR(resultados.getString("codR"));
				roupa.setTamanho(resultados.getString("tamanho"));
				roupa.setTipo(resultados.getString("tipo"));
				roupa.setCor(resultados.getString("cor"));
				roupa.setMarca(resultados.getString("marca"));
				roupa.setGenero(resultados.getString("genero"));
				roupa.setQtd(resultados.getInt("qtd"));

				lista.add(roupa);
			}
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}

		return lista;

	}

	public List<Roupa> listarRoupaPorMarca() {

		String sql = "SELECT * FROM Roupa GROUP BY marca, codR";

		List<Roupa> lista = new ArrayList<Roupa>();

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultados = preparador.executeQuery();

			while (resultados.next()) {

				Roupa roupa = new Roupa();

				roupa.setCodR(resultados.getString("codR"));
				roupa.setTamanho(resultados.getString("tamanho"));
				roupa.setTipo(resultados.getString("tipo"));
				roupa.setCor(resultados.getString("cor"));
				roupa.setMarca(resultados.getString("marca"));
				roupa.setGenero(resultados.getString("genero"));
				roupa.setQtd(resultados.getInt("qtd"));

				lista.add(roupa);
			}
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}

		return lista;

	}

	public List<Roupa> listarRoupaPorID() {

		String sql = "SELECT * FROM Roupa ORDER BY codR ASC";

		List<Roupa> lista = new ArrayList<Roupa>();

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultados = preparador.executeQuery();

			while (resultados.next()) {

				Roupa roupa = new Roupa();

				roupa.setCodR(resultados.getString("codR"));
				roupa.setTamanho(resultados.getString("tamanho"));
				roupa.setTipo(resultados.getString("tipo"));
				roupa.setCor(resultados.getString("cor"));
				roupa.setMarca(resultados.getString("marca"));
				roupa.setGenero(resultados.getString("genero"));
				roupa.setQtd(resultados.getInt("qtd"));

				lista.add(roupa);
			}
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}

		return lista;

	}

}
