package agenda_de_contatos;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Menu {
	Scanner scan = new Scanner(System.in);

	public void menuPrincipal() {
		System.out.println("****Agenda de Contatos****");
		System.out.println();
		System.out.println("1 - Adicionar Contato");
		System.out.println("2 - Buscar Contato");
		System.out.println("3 - Ver Lista de Contatos");
		System.out.println("4 - Apagar Contato");
		System.out.println("5 - Sair");
		System.out.println();
		System.out.print("Escolha uma opção: ");
	}

	public void adicionarContato(Contato c) {
		System.out.print("Digite o nome do contato: ");
		c.setNome(scan.nextLine());
		System.out.print("Digite o número do contato: ");
		c.setNumero(scan.nextInt());
		scan.nextLine();
	}

	public void buscarContato(List<Contato> lista) {
		System.out.print("Digite o nome do contato que deseja buscar: ");
		String entrada = scan.nextLine();

		int busca = 0;
		boolean encerrarLoop = false;
		do {
			for (Contato contato : lista) {
				if (contato.getNome().equals(entrada)) {
					System.out.println("Nome: " + contato.getNome());
					System.out.println("Número: " + contato.getNumero());
					System.out.println();
					busca++;
				}
			}

			if (busca == 0) {
				System.out.println("Nenhum contato encontrado!");
				System.out.println();
				encerrarLoop = true;
			} else {
				encerrarLoop = true;
			}
		} while (encerrarLoop != true);
	}

	public void verContatos(List<Contato> lista) {
		for (Contato contato : lista) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Número: " + contato.getNumero());
			System.out.println();
		}
	}

	public void apagarContato(List<Contato> lista) {
		System.out.print("Digite o nome do contato que deseja apagar: ");
		String entrada = scan.nextLine();

		Set<Integer> busca = new TreeSet<>();

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getNome().equals(entrada)) {
				busca.add(i);
			}
		}

		if (busca.size() == 0) {
			System.out.println("Nenhum contato encontrado!");
		} else if (busca.size() == 1) {
			for (int valor : busca) {
				lista.remove(valor);
			}
		} else if (busca.size() > 1) {
			for (int valor : busca) {
				System.out.println("Nome: " + lista.get(valor).getNome());
				System.out.println("Nome: " + lista.get(valor).getNumero());
				System.out.println();
			}

			System.out.print("Digite o número do contato que deseja apagar: ");
			int confirmarNumero = scan.nextInt();
			scan.nextLine();

			int i = 0;
			for (int valor : busca) {
				if (lista.get(valor).getNome().equals(entrada) && lista.get(valor).getNumero() == confirmarNumero) {
					lista.remove(valor);
				} else if (lista.get(valor).getNome().equals(entrada) && lista.get(valor).getNumero() != confirmarNumero
						&& i == (busca.size() - 1)) {
					System.out.println("Nenhum contato com o número digitado foi encontrado!");
				}

				i++;
			}
		}
	}
}
