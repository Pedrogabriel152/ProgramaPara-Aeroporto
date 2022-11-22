package br.edu.ifg;

public class Pessoa {
	protected String nome;
	protected String cpf;
	protected String numeroDoVoo;
	
	public Pessoa(String nome, String cpf,String numeroDoVoo) {
		this.nome = nome;
		this.cpf = cpf;
		this.numeroDoVoo = numeroDoVoo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumeroDoVoo() {
		return numeroDoVoo;
	}

	public void setNumeroDoVoo(String numeroDoVoo) {
		this.numeroDoVoo = numeroDoVoo;
	}
	
	
}
