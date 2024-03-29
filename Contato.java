package agenda_de_contatos;

public class Contato {
	String nome;
	int numero;

	public String toString() {
		return getNome();
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return this.nome;
	}

	public int getNumero() {
		return this.numero;
	}
	
	public boolean apenasNumeros(String teste) {
		for (int i = 0; i < teste.length(); i++) {
			if (!Character.isDigit(teste.charAt(i))) {
				return false;
			}
		}
		
		return true;
	}
}
