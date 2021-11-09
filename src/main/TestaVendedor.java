package main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import classesBean.Roupa;
import classesBean.Vendedor;
import classesDAO.RoupaDAO;
import classesDAO.VendedorDAO;

public class TestaVendedor {

	public static void main(String[] args) {

		menuVendedor();

	}

	private static void menuVendedor() {

		Scanner menu = new Scanner(System.in);
		int resposta = 1;

		while (resposta == 1) {

			String opcao;

			System.out.print("##--Sistema de Gerenciamento--##\n");
			System.out.print("|-------------------------------|\n");
			System.out.print("| Opção 1 - Cadastrar vendedor  |\n");
			System.out.print("| Opção 2 - Alterar salário     |\n");
			System.out.print("| Opção 3 - Deletar vendedor    |\n");
			System.out.print("| Opção 4 - Listar vendedores   |\n");
			System.out.print("| Opção 5 - Sair                |\n");
			System.out.print("|-------------------------------|\n");
			System.out.print("Digite uma opção: ");
			opcao = menu.next();

			switch (opcao) {

			case "1":
				System.out.println("");
				System.out.println("Para cadastrar um novo empregado, complete as opções a seguir.");
				System.out.println("");
				testaInsert();

				break;

			case "2":
				System.out.println("");
				System.out.println("Para atualizar informações de um empregado, complete as opções a seguir.");
				System.out.println("");
				testaUpdate();

				break;

			case "3":
				System.out.println("");
				System.out.println("Para deletar um vendedor da base de dados digite o seu CPF.");
				System.out.println("");
				testaDelete();

				break;
			
			case "4" :
				System.out.println("");
				System.out.println("Lista de Vendedores.");
				System.out.println("");
				testaListaVendedores();

				break;
				
			case "5":
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

		Vendedor ven = new Vendedor();

		System.out.print("Digite o cpf do vendedor: ");
		String cpf = sc.next();
		ven.setCpf(cpf);

		System.out.print("Digite o sexo do vendedor(M/F): ");
		String sexo = sc.next().toUpperCase();
		ven.setSexo(sexo);

		System.out.print("Digite o nome do vendedor: ");
		String nome = sc.next();
		ven.setNome(nome);
		sc.nextLine();
		
		System.out.print("Digite o endereço do vendedor: ");
		String rua = sc.nextLine();
		ven.setEndereco(rua);
		

		System.out.print("Digite o salário do vendedor: ");
		Double sal = sc.nextDouble();
		sc.nextLine();
		ven.setSalario(sal);

		VendedorDAO venDAO = null;

		try {
			venDAO = new VendedorDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		venDAO.cadastrarVendedor(ven);

	}

	public static void testaUpdate() {
		Scanner sc = new Scanner(System.in);

		Vendedor ven = new Vendedor();

		System.out.print("Digite o CPF do empregado para alterar o seu salário: ");
		String cpf = sc.next();
		ven.setCpf(cpf);
		sc.nextLine();

		System.out.print("Digite o valor do novo salário: ");
		Double sal = sc.nextDouble();
		sc.nextLine();
		ven.setSalario(sal);

		VendedorDAO venDAO = null;

		try {
			venDAO = new VendedorDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		venDAO.updateVendedor(ven);
	}

	public static void testaDelete() {
		Scanner sc = new Scanner(System.in);

		Vendedor ven = new Vendedor();

		System.out.print("CPF: ");
		String cpf = sc.next();
		ven.setCpf(cpf);

		VendedorDAO venDAO = null;

		try {

			venDAO = new VendedorDAO();

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

		venDAO.deleteVendedor(ven);

	}
	
	private static void testaListaVendedores() {

		VendedorDAO vendedorDAO = null;

		try {
			vendedorDAO = new VendedorDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		List<Vendedor> listaVendedores = vendedorDAO.listarvendedores();

		for (Vendedor vendedor : listaVendedores) {
			System.out.println("CPF: " + vendedor.getCpf() + " | Nome: " + vendedor.getNome() + " | Endereço: "
					+ vendedor.getEndereco() + " | Sexo: " + vendedor.getSexo() + " | Salário: " + vendedor.getSalario());
		}

	}
}
