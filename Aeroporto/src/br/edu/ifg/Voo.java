package br.edu.ifg;

import br.edu.ifg.enus.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Voo {
	private String empresaDoVoo;
	private String numeroDoVoo;
	private GregorianCalendar horario;
	private Aviao aviao;
	private int quantPassageiros;
	private int quantAeromocas;
	private Piloto piloto;
	private CoPiloto coPiloto;
	private Aeromoca aeromocas;
	private Passageiro passageiro;
	private OcorrenciaDoVoo ocorrenciaDoVoo;
	private Scanner sc = new Scanner(System.in);
	
	public Voo(String empresaDoVoo,
				String numeroDoVoo,
				Piloto piloto,
				CoPiloto coPiloto,
				Aeromoca aeromocas,
				Passageiro passageiro,
				String ocorrenciaDoVoo) {
		
		this.empresaDoVoo = empresaDoVoo;
		this.numeroDoVoo = numeroDoVoo;
		this.piloto = piloto;
		this.coPiloto = coPiloto;
		this.aeromocas = aeromocas;
		this.passageiro = passageiro;
		this.ocorrenciaDoVoo = OcorrenciaDoVoo.valueOf(ocorrenciaDoVoo);
		this.definirNumeroDoVoo();
		this.definirQuantPassageiros();
		this.definirQuantAeromocas();
		this.definirHorario();
		
	}
	
	public void definirNumeroDoVoo() {
		String numeroDoVoo;
		
		System.out.println("Digite o numero do voo");
		numeroDoVoo = sc.nextLine();
		
		this.setNumeroDoVoo(numeroDoVoo);
	}
	
	public void definirQuantPassageiros() {
		int passageiros;
		
		System.out.println("Quantos passageiros o voo "
							+this.getNumeroDoVoo()+" vai ter:");
		passageiros = sc.nextInt();
		
		this.setQuantPassageiros(passageiros);
	}
	
	public void definirQuantAeromocas() {
		int quantAeromocas;
		
		System.out.println("Quantas aeromocas o voo "
							+this.getNumeroDoVoo()+" vai ter:");
		quantAeromocas = sc.nextInt();
		
		this.setQuantAeromocas(quantAeromocas);
	}
	
	public void definirHorario() {
		GregorianCalendar horario;
		int dia, mes, ano, hora, minuto;
		
		System.out.println("Digite o dia da saida:");
		dia = sc.nextInt();
		
		System.out.println("Digite o mes em numero:");
		mes = sc.nextInt();
		mes = mes -1;
		
		System.out.println("Digite o ano:");
		ano = sc.nextInt();
		
		System.out.println("Digite a hora:");
		hora = sc.nextInt(); 
		
		System.out.println("Digite o minuto");
		minuto = sc.nextInt();
		horario = new GregorianCalendar(ano, mes, dia, hora, minuto);
		
		this.setHorario(horario);
	}

	public String getEmpresaDoAviao() {
		return empresaDoVoo;
	}

	public void setEmpresaDoAviao(String empresaDoAviao) {
		this.empresaDoVoo = empresaDoAviao;
	}

	public String getNumeroDoVoo() {
		return numeroDoVoo;
	}

	public void setNumeroDoVoo(String numeroDoVoo) {
		this.numeroDoVoo = numeroDoVoo;
	}


	public Aviao getAviao() {
		return aviao;
	}

	public void setAviao(Aviao aviao) {
		this.aviao = aviao;
	}

	public int getQuantPassageiros() {
		return quantPassageiros;
	}

	public void setQuantPassageiros(int quantPassageiros) {
		this.quantPassageiros = quantPassageiros;
	}
	
	public int getQuantAeromocas() {
		return quantAeromocas;
	}

	public void setQuantAeromocas(int quantAeromocas) {
		this.quantAeromocas = quantAeromocas;
	}

	public Piloto getPiloto() {
		return piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	public CoPiloto getCoPiloto() {
		return coPiloto;
	}

	public void setCoPiloto(CoPiloto coPiloto) {
		this.coPiloto = coPiloto;
	}

	public Aeromoca getAeromocas() {
		return aeromocas;
	}

	public void setAeromocas(Aeromoca aeromocas) {
		this.aeromocas = aeromocas;
	}

	public Passageiro getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}

	public GregorianCalendar getHorario() {
		return horario;
	}

	public void setHorario(GregorianCalendar horario) {
		this.horario = horario;
	}		
}