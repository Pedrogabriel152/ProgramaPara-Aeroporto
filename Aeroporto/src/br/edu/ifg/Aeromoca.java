package br.edu.ifg;

public class Aeromoca extends Pessoa{
	private String formacao;
	
	public Aeromoca(String nome, String cpf,String numeroDoVoo,String formacao) {
		super(nome,cpf,numeroDoVoo);
		this.formacao = formacao;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
}
