package agenda_de_contatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContatosTeste {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Menu menu = new Menu();

		List<Contato> lista = new ArrayList<Contato>();

		int entrada;

		do {
			menu.menuPrincipal();
			entrada = scan.nextInt();
			scan.nextLine();

			switch (entrada) {
			case 1:
				Contato c = new Contato();
				menu.adicionarContato(c);
				lista.add(c);
				break;

			case 2:
				menu.buscarContato(lista);
				break;

			case 3:
				menu.verContatos(lista);
				break;

			case 4:
				menu.apagarContato(lista);
				break;
			}
		} while (entrada != 5);

		scan.close();
	}
}
