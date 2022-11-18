package br.edu.ifg.enus;


public enum OcorrenciaDoVoo {
	ATERRISANDO("aterrissando"),
	DECOLANDO("decolando");
	
	private String ocorrencia;
	
	OcorrenciaDoVoo(String ocorrencia) {
		this.ocorrencia = ocorrencia;
	}
	
	public String getOcorrencia() {
		return this.ocorrencia;
	}
}