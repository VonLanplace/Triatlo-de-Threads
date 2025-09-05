package model.listaSimples;

public class ListaSimples<T> {
	private No<T> primeiro = null;

	// append - Adiciona o elemento no final;
	// get - Retorna um no dado um index;
	// index - Retorna um indice de um elemento;
	// insert - Insere um elemento em uma determinada posição;
	// last - Retorna o ultimo elemento;
	// remove - Remove um elemento dado o index;
	// total - Retorna o total de elementos;

	public void append(T conteudo) {
		// Criamos o no a ser adicionado
		No<T> adicionado = new No<>(conteudo);

		// checamos se o primeiro No existe
		if (this.primeiro == null) {
			// se não o adicionado será o primeiro
			this.primeiro = adicionado;
		} else {
			// se sim procuramos o ultimo valor e colocamos o novo como próximo dele
			this.last().setProximo(adicionado);
		}
	}

	public No<T> get(int index) throws IllegalArgumentException {
		// A lista esta vazia entao retorna um erro
		if (this.primeiro == null) {
			throw new IllegalArgumentException("A lista esta vazia.");
		}

		// Cria uma temporária para ser o retorno e a checagem
		No<T> temp = this.primeiro;

		// Olhamos elemento por elemento até chegar no elemento do index
		for (int i = 0; i < index; i++) {
			// Testamos se tem uma casa apos a atual
			if (temp.getProximo() == null) {
				// Decobrimos que não temos uma casa então retonamos um erro
				throw new IllegalArgumentException("Não existe o index na lista.");
			}
			// tem uma casa então pegamos seu conteudo para checar
			temp = temp.getProximo();
		}
		// como o FOR acaba no index o temp se ele for completado sera o conteudo dele
		return temp;
	}

	public int index(T conteudo) throws IllegalArgumentException {
		// Testa se o primeio é nulo
		if (this.primeiro == null) {
			// Se é retorna um erro
			throw new IllegalArgumentException("A lista esta vazia.");
		} // Se não é seque

		// Cria o temporario auxiliar
		No<T> temp = this.primeiro;

		// cria o contador do index
		int index = 0;

		// enquanto o temp não for nulo
		while (temp != null) {

			// se a id é a procurada
			if (temp.getConteudo() == conteudo) {
				// retorna o index
				return index;
			}
			// se não é carrega o proximo e aumenta o contador
			temp = temp.getProximo();
			index++;
		}
		// chegou no final da lista e não achou
		throw new IllegalArgumentException("conteudo não encontrado.");
	}

	public void insert(int index, T conteudo) throws IllegalArgumentException {
		// Primeiro checamos se quer adicionar o primeiro
		if (index == 0) {
			// Se sim checa se esta vazio
			if (this.primeiro == null) {
				// está então so coloca o novo
				this.primeiro = new No<>(conteudo);
			} else {
				// separa o velho
				No<T> temp = this.primeiro;
				// troca o velho pelo novo na referencia da Lista
				this.primeiro = new No<>(conteudo);
				// aponta o novo para o velho
				this.primeiro.setProximo(temp);
			}
		} else {
			// Se não procura o elemento anteriror a o que sera trocado
			No<T> anteriorIndex = this.get(--index);
			// ai vc pega o anterior
			No<T> velhoIndex = anteriorIndex.getProximo();
			// e cria o novo elemento
			No<T> novoIndex = new No<>(conteudo);
			// troca o velho pelo novo no anterior
			anteriorIndex.setProximo(novoIndex);
			// aponta o novo para o velho
			novoIndex.setProximo(velhoIndex);
		}
	}

	public No<T> last() {
		if (primeiro == null) {
			throw new IllegalArgumentException("A lista esta vazia.");
		}
		No<T> objeto = primeiro;
		while (objeto.getProximo() != null) {
			objeto = objeto.getProximo();
		}
		return objeto;
	}

	public void remove(int index) {
		if (index == 0) {
			this.primeiro.setConteudo(null);
			if (this.primeiro.getProximo() == null) {
				this.primeiro = null;
			} else {
				No<T> novo = this.primeiro.getProximo();
				this.primeiro.setProximo(null);
				this.primeiro = novo;
			}
		}
		No<T> anterior = this.get(--index);
		No<T> velho = this.get(index);
		No<T> posterior = this.get(++index);
		velho.setConteudo(null);
		velho.setProximo(null);
		anterior.setProximo(posterior);
	}

	public int total() {
		if (this.primeiro == null) {
			return 0;
		}

		No<T> atual = this.primeiro;
		int total = 1;
		while (atual.getProximo() != null) {
			total++;
			atual = atual.getProximo();
		}
		return total;
	}

	public String toString() {
		if (this.primeiro == null) {
			return "[]";
		}
		StringBuilder text = new StringBuilder("[");
		No<T> atual = this.primeiro;
		while (atual != null) {
			text.append(atual.toString()).append(",");
			atual = atual.getProximo();
		}
		text.append("]");
		return text.toString();
	}
}
