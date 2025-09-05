package model.listaSimples;

public class No<T> {
	private T conteudo;
	private No<T> proximo;

	public No() {
		this.conteudo = null;
		proximo = null;
	}

	public No(T conteudo) {
		this.conteudo = conteudo;
		proximo = null;
	}

	public T getConteudo() {
		return conteudo;
	}

	public No<T> getProximo() {
		return proximo;
	}

	public void setConteudo(T conteudo) {
		this.conteudo = conteudo;
	}

	public void setProximo(No<T> proximo) {
		this.proximo = proximo;
	}

	@Override
	public String toString() {
		return conteudo.toString();
	}
}
