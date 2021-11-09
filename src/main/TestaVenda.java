package main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import classesBean.Roupa;
import classesBean.Venda;
import classesBean.Vendedor;
import classesDAO.RoupaDAO;
import classesDAO.VendaDAO;
import classesDAO.VendedorDAO;

public class TestaVenda {

	public static void main(String[] args) {

		menuVendas();

	}

	private static void menuVendas() {

		Scanner menu = new Scanner(System.in);
		int resposta = 1;

		while (resposta == 1) {

			String opcao;

			System.out.print("##--Sistema de Gerenciamento--##\n");
			System.out.print("|-------------------------------|\n");
			System.out.print("| Opção 1 - Cadastrar uma Venda |\n");
			System.out.print("| Opção 2 - Alterar uma venda   |\n");
			System.out.print("| Opção 3 - Deletar uma venda   |\n");
			System.out.print("| Opção 4 - Listar Vendas       |\n");
			System.out.print("| Opção 5 - Consultar Estoque   |\n");
			System.out.print("| Opção 6 - Sair	        |\n");
			System.out.print("|-------------------------------|\n");
			System.out.print("Digite uma opção: ");
			opcao = menu.next();

			switch (opcao) {
			case "1":
				System.out.println("");
				System.out.println("Para cadastrar uma nova venda, complete as opções a seguir.");
				System.out.println("");
				testaInsert();

				break;

			case "2":
				System.out.println("");
				System.out.println("Para atualizar informações de uma venda, complete as opções a seguir.");
				System.out.println("");
				testaUpdate();

				break;

			case "3":
				System.out.println("");
				System.out.println("Para deletar uma venda da base de dados digite o id da Venda.");
				System.out.println("");
				testaDelete();

				break;
			
			case "4":
				System.out.println("");
				System.out.println("Lista de Vendas.");
				System.out.println("");
				testaListaVendas();
				break;
			
			case "5":
				System.out.println("");
				System.out.println("Consulta de Estoque.");
				System.out.println("");
				testaListaEstoque();
				break;
				
			case "6":
				System.out.println("Até Logo!");
				break;

			default:
				System.out.println("Opção inválida!");
				break;
			}

			System.out.println("");
			System.out.println("Deseja acessar o menu novamente? [1]sim [2]não");
			resposta = menu.nextInt();
			menu.nextLine();
			System.out.println("");
			if (resposta != 1) {
				System.out.println("Finalizado!");
				menu.close();
			}

		}

	}

	public static void testaInsert() {

		Scanner sc = new Scanner(System.in);

		Venda venda = new Venda();

		Vendedor vendedor = new Vendedor();

		System.out.print("Digite o identificador do vendedor: ");
		String cpf = sc.next();
		vendedor.setCpf(cpf);

		System.out.print("Digite o código da roupa: ");
		String codR = sc.next();
		Roupa roupa = new Roupa();
		roupa.setCodR(codR);

		System.out.print("Digite o valor da peça: ");
		Double valor = sc.nextDouble();
		venda.setValor(valor);

		System.out.print("Digite a quantidade: ");
		int qtd = sc.nextInt();
		venda.setQtd(qtd);

		venda.setVendedor(vendedor);
		venda.setRoupa(roupa);

		VendaDAO vendaDAO = null;

		try {
			vendaDAO = new VendaDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		vendaDAO.cadastrarVenda(venda);

	}

	public static void testaUpdate() {

		Scanner sc = new Scanner(System.in);

		Venda venda = new Venda();

		System.out.print("Digite o id da venda: ");
		int nome = sc.nextInt();
		venda.setId_venda(nome);

		System.out.print("Digite o novo valor de venda: ");
		Double valor = sc.nextDouble();
		venda.setValor(valor);

		VendaDAO vendaDAO = null;

		try {
			vendaDAO = new VendaDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		vendaDAO.realizarUpdateVenda(venda);
	}

	public static void testaDelete() {

		Scanner sc = new Scanner(System.in);

		Venda venda = new Venda();

		System.out.println("Digite o id da venda: ");
		int valor = sc.nextInt();
		venda.setId_venda(valor);

		VendaDAO vendaDAO = null;

		try {
			vendaDAO = new VendaDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		vendaDAO.realizarDelecaoVenda(venda);
	}
	
	private static void testaListaVendas() {

		VendaDAO vendaDAO = null;

		try {
			vendaDAO = new VendaDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		List<Venda> listaVendas = vendaDAO.listarVendas();

		for (Venda venda : listaVendas) {
			System.out.println("Id_Venda: " + venda.getId_venda() + " | Quantidade: " + venda.getQtd() + " | Valor: "
					+ venda.getValor() + " | Data: " + venda.getDataCompra());
		}

	}
	
	private static void testaListaEstoque() {
		
		RoupaDAO roupaDAO = null;

		try {
			roupaDAO = new RoupaDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		List<Roupa> listaRoupaPorID = roupaDAO.listarRoupaPorID();
		
		for (Roupa roupa : listaRoupaPorID) {
			System.out.println("Código: " + roupa.getCodR() + " | Tamanho: " + roupa.getTamanho() + " | Tipo: "
					+ roupa.getTipo() + " | Cor: " + roupa.getCor() + " | Marca: " + roupa.getMarca() + " | Gênero: "
					+ roupa.getGenero() + " | Quantidade: " + roupa.getQtd());
		}
		
	}

}
