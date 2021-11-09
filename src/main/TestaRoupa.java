package main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import classesBean.Roupa;
import classesDAO.RoupaDAO;

public class TestaRoupa {

	public static void main(String[] args) {

		menuVendedor();

	}

	private static void menuVendedor() {

		Scanner menuRoupa = new Scanner(System.in);
		int resposta = 1;

		while (resposta == 1) {

			String opcao;

			System.out.print("##---------Sistema de Gerenciamento--------##\n");
			System.out.print("|-------------------------------------------|\n");
			System.out.print("| Opção 1 - Cadastrar Nova Roupa            |\n");
			System.out.print("| Opção 2 - Alterar Dados da Roupa [Marca]  |\n");
			System.out.print("| Opção 3 - Alterar Dados da Roupa [Tipo]   |\n");
			System.out.print("| Opção 4 - Deletar Roupa                   |\n");
			System.out.print("| Opção 5 - Listar Roupas por Tamanho       |\n");
			System.out.print("| Opção 6 - Listar Roupas por Tipo          |\n");
			System.out.print("| Opção 7 - Listar Roupas por Marca         |\n");
			System.out.print("| Opção 8 - Listar Roupas por ID            |\n");
			System.out.print("| Opção 9 - Sair                            |\n");
			System.out.print("|-------------------------------------------|\n");
			System.out.print("Digite uma opção: ");
			opcao = menuRoupa.next();

			switch (opcao) {

			case "1":
				System.out.println("");
				System.out.println("Para cadastrar uma nova roupa, complete as opções a seguir.");
				System.out.println("");
				testaInsertRoupa();

				break;

			case "2":
				System.out.println("");
				System.out.println("Para atualizar informações da Marca de uma Roupa, complete as opções a seguir.");
				System.out.println("");
				testaUpdateMarcaRoupa();

				break;

			case "3":
				System.out.println("");
				System.out.println("Para atualizar informações do Tipo da Roupa, complete as opções a seguir.");
				System.out.println("");
				testaUpdateTipoRoupa();

				break;

			case "4":
				System.out.println("");
				System.out.println("Para excluir uma roupa da base de dados informe o ID.");
				System.out.println("");
				testaDeleteRoupa();

				break;

			case "5":
				System.out.println("");
				System.out.println("Lista de Roupas por Tamanho.");
				System.out.println("");
				testaListaRoupaPorTamanho();

				break;

			case "6":
				System.out.println("");
				System.out.println("Lista de Roupas por Tipo.");
				System.out.println("");
				testaListaRoupaPorTipo();

				break;

			case "7":
				System.out.println("");
				System.out.println("Lista de Roupas por Marca.");
				System.out.println("");
				testaListaRoupaPorMarca();

				break;

			case "8":
				System.out.println("");
				System.out.println("Lista de Roupas por ID.");
				System.out.println("");
				testaListaRoupaPorID();

				break;

			case "9":
				System.out.println("Até Logo!");
				break;

			default:
				System.out.println("Opção inválida!");
				break;
			}

			System.out.println("");
			System.out.println("Deseja acessar o menu novamente? [1]sim [2]não");
			resposta = menuRoupa.nextInt();
			menuRoupa.nextLine();
			System.out.println("");
			if (resposta != 1) {
				System.out.println("Finalizado!");
				menuRoupa.close();
			}

		}

	}

	private static void testaInsertRoupa() {

		Scanner sc = new Scanner(System.in);

		Roupa roupa = new Roupa();

		System.out.print("Digite o código da roupa: ");
		String codR = sc.next();
		roupa.setCodR(codR);

		System.out.print("Digite o tamanho da roupa [P|M|G|GG]: ");
		String tamanho = sc.next();
		roupa.setTamanho(tamanho);

		System.out.print("Digite o tipo da roupa [Camisa|Camiseta|Calça|Bermuda]: ");
		String tipo = sc.next();
		roupa.setTipo(tipo);

		System.out.print("Digite a cor da roupa: ");
		String cor = sc.next();
		roupa.setCor(cor);

		System.out.print("Digite a marca da roupa: ");
		String marca = sc.next();
		roupa.setMarca(marca);

		System.out.print("Digite o gênero da roupa [M|F]: ");
		String genero = sc.next();
		roupa.setGenero(genero);

		System.out.print("Digite a quantidade de peças de roupa: ");
		int qtd = sc.nextInt();
		roupa.setQtd(qtd);

		RoupaDAO roupaDAO = null;

		try {
			roupaDAO = new RoupaDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		roupaDAO.cadastrarRoupa(roupa);
	}

	private static void testaUpdateMarcaRoupa() {

		Scanner sc = new Scanner(System.in);

		Roupa roupa = new Roupa();

		System.out.print("Digite o código da Roupa que deseja alterar os dados da Marca: ");
		String codR = sc.next();
		roupa.setCodR(codR);

		System.out.println("Digite a nova Marca da Roupa: ");
		String marca = sc.next();
		roupa.setMarca(marca);

		RoupaDAO roupaDAO = null;

		try {
			roupaDAO = new RoupaDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		roupaDAO.alterarMarcaRoupa(roupa);

	}

	private static void testaUpdateTipoRoupa() {

		Scanner sc = new Scanner(System.in);

		Roupa roupa = new Roupa();

		System.out.print("Digite o código da Roupa que deseja alterar os dados do Tipo: ");
		String codR = sc.next();
		roupa.setCodR(codR);

		System.out.println("Digite o Novo Tipo da Roupa: ");
		String tipo = sc.next();
		roupa.setTipo(tipo);

		RoupaDAO roupaDAO = null;

		try {
			roupaDAO = new RoupaDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		roupaDAO.alterarTipoRoupa(roupa);

	}

	private static void testaDeleteRoupa() {

		Scanner sc = new Scanner(System.in);

		Roupa roupa = new Roupa();

		System.out.print("ID da Roupa que deseja Excluir: ");
		String codR = sc.next();
		roupa.setCodR(codR);

		RoupaDAO roupaDAO = null;

		try {
			roupaDAO = new RoupaDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		roupaDAO.deletarRoupa(roupa);

	}

	private static void testaListaRoupaPorTamanho() {

		RoupaDAO roupaDAO = null;

		try {
			roupaDAO = new RoupaDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		List<Roupa> listaRoupaPorTamanho = roupaDAO.listarRoupaPorTamanho();

		for (Roupa roupa : listaRoupaPorTamanho) {
			System.out.println("Tamanho: " + roupa.getTamanho() + " | Código: " + roupa.getCodR() + " | Tipo: "
					+ roupa.getTipo() + " | Cor: " + roupa.getCor() + " | Marca: " + roupa.getMarca() + " | Gênero: "
					+ roupa.getGenero() + " | Quantidade: " + roupa.getQtd());
		}

	}

	private static void testaListaRoupaPorTipo() {

		RoupaDAO roupaDAO = null;

		try {
			roupaDAO = new RoupaDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		List<Roupa> listaRoupaPorTipo = roupaDAO.listarRoupaPorTipo();

		for (Roupa roupa : listaRoupaPorTipo) {
			System.out.println("Tipo: " + roupa.getTipo() + " | Código: " + roupa.getCodR() + " | Tamanho: "
					+ roupa.getTamanho() + " | Cor: " + roupa.getCor() + " | Marca: " + roupa.getMarca() + " | Gênero: "
					+ roupa.getGenero() + " | Quantidade: " + roupa.getQtd());
		}

	}

	private static void testaListaRoupaPorMarca() {

		RoupaDAO roupaDAO = null;

		try {
			roupaDAO = new RoupaDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		List<Roupa> listaRoupaPorMarca = roupaDAO.listarRoupaPorMarca();

		for (Roupa roupa : listaRoupaPorMarca) {
			System.out.println("Marca: " + roupa.getMarca() + " | Código: " + roupa.getCodR() + " | Tamanho: "
					+ roupa.getTamanho() + " | Tipo: " + roupa.getTipo() + " | Cor: " + roupa.getCor() + " | Gênero: "
					+ roupa.getGenero() + " | Quantidade: " + roupa.getQtd());
		}

	}

	private static void testaListaRoupaPorID() {

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