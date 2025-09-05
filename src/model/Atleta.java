package model;

public class Atleta {
	private String nome;
	private int id;
	private int pontuacao;

	public Atleta() {
		super();
	}

	public Atleta(int id, int pontuacao) {
		this.id = id;
		this.pontuacao = pontuacao;
		this.nome = "";
	}

	public Atleta(int id, int pontuacao, String nome) {
		this.id = id;
		this.pontuacao = pontuacao;
		this.nome = nome;
	}

	@Override
	public String toString() {
		StringBuilder text = new StringBuilder();
		text.append("[").append(id).append(",").append(nome).append(",").append(pontuacao).append("]\n");
		return text.toString();
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public Atleta copy() {
		return new Atleta(this.id, this.pontuacao, this.nome);
	}
}
