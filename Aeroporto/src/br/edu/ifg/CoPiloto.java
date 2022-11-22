package br.edu.ifg;

public class CoPiloto extends Pessoa {
private String licenca;
	
	public CoPiloto(String nome, String cpf,String numeroDoVoo,String licenca) {
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
