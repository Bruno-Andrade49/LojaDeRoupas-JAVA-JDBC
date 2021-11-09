package classesDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import classesBean.Roupa;
import classesBean.Venda;
import conectaPg.Conecta;

public class VendaDAO {

	private Connection con;

	public VendaDAO() throws SQLException, ClassNotFoundException {
		con = Conecta.criarConexao();
	}

	public void cadastrarVenda(Venda venda) {

		String sql = "INSERT INTO Venda(valor, qtd, dataCompra, id_vendedor, id_roupa)" + " VALUES(?,?,?,?,?)";

		String sql02 = "CREATE OR REPLACE FUNCTION trigger_function() RETURNS TRIGGER AS $$" + "BEGIN "
				+ "UPDATE roupa " + "SET Qtd = Qtd - new.qtd " + "WHERE new.id_roupa = codR; " + "RETURN NEW; "
				+ "END; " + "$$ " + "LANGUAGE plpgsql; " +

				"CREATE TRIGGER ajustaNumRoupas " + "AFTER INSERT ON Venda " + "FOR EACH ROW "
				+ "EXECUTE PROCEDURE trigger_function();";

		String sql03 = "DROP TRIGGER IF EXISTS ajustanumroupas on venda";
		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			PreparedStatement preparador02 = con.prepareStatement(sql02);

			PreparedStatement preparador03 = con.prepareStatement(sql03);

			preparador03.execute();
			preparador03.close();

			preparador02.executeUpdate();
			preparador02.close();
			

			preparador.setDouble(1, venda.getValor());
			preparador.setInt(2, venda.getQtd());
			Date data = new Date(System.currentTimeMillis());
			preparador.setDate(3, data);
			preparador.setString(4, venda.getVendedor().getCpf());
			preparador.setString(5, venda.getRoupa().getCodR());

			preparador.executeUpdate();

			System.out.println("Venda realizada!!");

		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
			

	}

	public void realizarUpdateVenda(Venda venda) {

		String sql = "UPDATE Venda SET valor = ? WHERE id_venda = ?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setDouble(1, venda.getValor());
			preparador.setInt(2, venda.getId_venda());

			preparador.execute();
			preparador.close();
			System.out.println("Modificação realizada!!");

		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}

	}

	public void realizarDelecaoVenda(Venda venda) {

		String sql = "DELETE FROM Venda WHERE id_venda = ?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setInt(1, venda.getId_venda());

			preparador.execute();
			preparador.close();
			System.out.println("Deleção realizada!!");

		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}

	}

	public List<Venda> listarVendas() {

		String sql = "SELECT * FROM Venda";

		List<Venda> lista = new ArrayList<Venda>();

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultados = preparador.executeQuery();

			while (resultados.next()) {

				Venda venda = new Venda();

				venda.setId_venda(resultados.getInt("id_venda"));
				venda.setValor(resultados.getDouble("valor"));
				venda.setQtd(resultados.getInt("qtd"));
				venda.setDataCompra(resultados.getDate("dataCompra"));

				lista.add(venda);
			}
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}

		return lista;

	}
}