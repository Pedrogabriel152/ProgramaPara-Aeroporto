package br.edu.ifg;

public class Piloto extends Pessoa{
	private String licenca;
	
	public Piloto(String nome, String cpf,String numeroDoVoo,String licenca) {
		super(nome,cpf,numeroDoVoo);
		this.licenca = licenca;
	}

	public String getLicenca() {
		return licenca;
	}

	public void setLicenca(String licenca) {
		this.licenca = licenca;
	}
}
