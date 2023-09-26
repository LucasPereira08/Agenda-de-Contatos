package agenda_de_contatos;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Menu {
	Scanner scan = new Scanner(System.in);
	Contato c = new Contato();
	
	boolean verificacao = false;

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
		do {
			System.out.print("Digite o número do contato: ");
			String numeroContato = scan.nextLine();
			
			if (c.apenasNumeros(numeroContato)) {
				c.setNumero(Integer.parseInt(numeroContato));
				verificacao = true;
			} else {
				System.out.println("Digite apenas números!");
			}
		} while (verificacao == false);
	}

	public void buscarContato(List<Contato> lista) {
		System.out.print("Digite o nome do contato que deseja buscar: ");
		String entrada = scan.nextLine();

		int busca = 0;
		boolean encerrarLoop = false;
		do {
			for (Contato contato : lista) {
				if (contato.getNome().equalsIgnoreCase(entrada)) {
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
		System.out.println();
		System.out.println("****Seus Contatos****");

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
			if (lista.get(i).getNome().equalsIgnoreCase(entrada)) {
				busca.add(i);
			}
		}

		if (busca.size() == 0) {
			System.out.println("Nenhum contato encontrado!");
			System.out.println();
		} else if (busca.size() == 1) {
			for (int valor : busca) {
				lista.remove(valor);
				System.out.println("Contato apagado com sucesso!");
				System.out.println();
			}
		} else if (busca.size() > 1) {
			for (int valor : busca) {
				System.out.println("Nome: " + lista.get(valor).getNome());
				System.out.println("Nome: " + lista.get(valor).getNumero());
				System.out.println();
			}
			
			String confirmarNumero;
			int numeroVerificado = 0;
			
			do {
				System.out.print("Digite o número do contato que deseja apagar: ");
				confirmarNumero = scan.nextLine();
				
				if (c.apenasNumeros(confirmarNumero)) {
					numeroVerificado = Integer.parseInt(confirmarNumero);
				} else {
					System.out.println("Digite um número válido!");
				}
			} while (!c.apenasNumeros(confirmarNumero));

			int i = 0;
			for (int valor : busca) {
				if (lista.get(valor).getNome().equalsIgnoreCase(entrada) && lista.get(valor).getNumero() == numeroVerificado) {
					lista.remove(valor);
					System.out.println("Contato apagado com sucesso!");
					System.out.println();
				} else if (lista.get(valor).getNome().equalsIgnoreCase(entrada) && lista.get(valor).getNumero() != numeroVerificado
						&& i == (busca.size() - 1)) {
					System.out.println("Nenhum contato com o número digitado foi encontrado!");
					System.out.println();
				}

				i++;
			}
		}
	}
}
