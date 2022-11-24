package br.edu.ifg;

import br.edu.ifg.enus.*;
import br.edu.ifg.interfaces.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Voo implements IVoo {
	private String empresaDoVoo;
	private String numeroDoVoo;
	private GregorianCalendar horario;
	private Aviao aviao;
	private int quantPassageiros;
	private int quantAeromocas;
	private Piloto piloto;
	private CoPiloto coPiloto;
	private ArrayList<Aeromoca> aeromocas;
	private Map<Integer,Passageiro> passageiros;
	private OcorrenciaDoVoo ocorrenciaDoVoo;
	private Scanner sc = new Scanner(System.in);
	
	public Voo(String empresaDoVoo,
				String ocorrenciaDoVoo,
				Map<String,Aviao> avioes) {
		
		this.empresaDoVoo = empresaDoVoo;
		this.ocorrenciaDoVoo = OcorrenciaDoVoo.valueOf(ocorrenciaDoVoo);
		this.definirNumeroDoVoo();
		this.definirQuantPassageiros();
		this.definirQuantAeromocas();
		this.piloto = this.criarPiloto();
		this.coPiloto = this.criarCoPiloto();
		this.aeromocas = this.criarAeromocas();
		this.definirHorario();
		this.aviao = this.definirAviao(avioes);
		this.criarPassageiros();
		
	}
	
	@Override
	public void definirNumeroDoVoo() {
		String numeroDoVoo;
		
		System.out.println("Digite o numero do voo");
		numeroDoVoo = sc.nextLine();
		
		this.setNumeroDoVoo(numeroDoVoo);
	}
	
	@Override
	public void definirQuantPassageiros() {
		int quantPassageiros;
		
		System.out.println("Quantos passageiros o voo "
							+this.getNumeroDoVoo()+" vai ter:");
		quantPassageiros = sc.nextInt();
		
		this.setQuantPassageiros(quantPassageiros);
	}
	
	@Override
	public void definirQuantAeromocas() {
		int quantAeromocas;
		
		System.out.println("Quantas aeromocas o voo "
							+this.getNumeroDoVoo()+" vai ter:");
		quantAeromocas = sc.nextInt();
		clearBuffer();
		
		this.setQuantAeromocas(quantAeromocas);
	}
	
	@Override
	public void definirHorario() {
		GregorianCalendar horario;
		int dia, mes, ano, hora, minuto;
		
		System.out.println("Digite o dia:");
		dia = sc.nextInt();
		
		System.out.println("Digite o mes em numero:");
		mes = sc.nextInt();
		this.clearBuffer();
		mes = mes -1;
		
		System.out.println("Digite o ano:");
		ano = sc.nextInt();
		this.clearBuffer();
		
		System.out.println("Digite a hora:");
		hora = sc.nextInt(); 
		this.clearBuffer();
		
		System.out.println("Digite o minuto");
		minuto = sc.nextInt();
		this.clearBuffer();
		
		horario = new GregorianCalendar(ano, mes, dia, hora, minuto);

		this.setHorario(horario);
	}
	
	@Override
	public Aviao definirAviao(Map<String,Aviao> avioes) {	
		for(String key : avioes.keySet()) {
			int quantMinimaPassageiroPraViajem;
			quantMinimaPassageiroPraViajem = (int) (avioes.get(key).getQuantLugares()*0.2);
			
			if(quantMinimaPassageiroPraViajem <= this.getQuantPassageiros() && this.getQuantPassageiros() <= avioes.get(key).getQuantLugares()) {
				return avioes.get(key);
			}
		}
		
		System.out.println("Quantidade de passageiros abaixo do minimo ou a cima da capacidade total"
							+"\nSem avioes disponiveis");
		System.out.println("Crie um novo aviao:");
		
		Aviao aviao = new Aviao();
		return aviao;
	}
	
	@Override
	public void criarPassageiros() {
		int quantPassageiro = this.getQuantPassageiros();
		int i = 1;
		
		
		String numeroDoVoo = this.getNumeroDoVoo();
		while(i<= quantPassageiro) {
			String nome;
			String cpf;
			int numeroDaPoltrona;
			
			System.out.println("Digite o nome do passageiro");
			nome = sc.nextLine();
			
			System.out.println("Informe o CPF");
			cpf = sc.nextLine();
			
			Passageiro passageiro = new Passageiro(nome, cpf, numeroDoVoo);
			numeroDaPoltrona = passageiro.definirNumeroDaPoltrona(this.getAviao().getQuantLugares(),this.getPassageiros());
			
			if(this.getPassageiros() == null) {
				Map<Integer,Passageiro> passageiros = new HashMap<>();
				passageiros.put(numeroDaPoltrona, passageiro);
				this.setPassageiros(passageiros);
			}else {
				Map<Integer,Passageiro> passageiros = this.getPassageiros();
				passageiros.put(numeroDaPoltrona, passageiro);
				this.setPassageiros(passageiros);
			}
			
			i++;
			
		}
	}
	
	@Override
	public Piloto criarPiloto() {
		String nome; 
		String cpf;
		String numeroDoVoo;
		String licenca;
		
		numeroDoVoo = this.getNumeroDoVoo();
		licenca = "Piloto";

		System.out.println("Digite o nome do piloto");
		nome = sc.nextLine();
		
		System.out.println("Informe o CPF do Piloto");
		cpf = sc.nextLine();
		
		Piloto piloto = new Piloto(nome,cpf,numeroDoVoo,licenca);
		
		return piloto;
	}
	
	@Override
	public CoPiloto criarCoPiloto() {
		String nome; 
		String cpf;
		String numeroDoVoo;
		String licenca;
		
		numeroDoVoo = this.getNumeroDoVoo();
		licenca = "Co-Piloto";

		System.out.println("Digite o nome do Co-Piloto");
		nome = sc.nextLine();
		
		System.out.println("Informe o CPF do Co-Piloto");
		cpf = sc.nextLine();
		
		CoPiloto coPiloto = new CoPiloto(nome,cpf,numeroDoVoo,licenca);
		
		return coPiloto;
	}
	
	@Override
	public ArrayList<Aeromoca> criarAeromocas() {
		String nome; 
		String cpf;
		String numeroDoVoo;
		String formacao;
		ArrayList<Aeromoca> aeromocas = new ArrayList<Aeromoca>();
		int quantAeromocas = this.getQuantAeromocas();
		int i = 1;
		
		numeroDoVoo = this.getNumeroDoVoo();
		formacao = "Aeromoca";
		
		while(i<=quantAeromocas) {
			System.out.println("Digite o nome da Aeromoca");
			nome = sc.nextLine();
			
			System.out.println("Informe o CPF da Aeromoca");
			cpf = sc.nextLine();
			
			Aeromoca aeromoca = new Aeromoca(nome, cpf, numeroDoVoo, formacao);
			aeromocas.add(aeromoca);
			
			i++;
		}
		
		return aeromocas;
	}
	
	private void clearBuffer() {
        if (sc.hasNextLine()) {
            sc.nextLine();
        }
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

	public ArrayList<Aeromoca> getAeromocas() {
		return aeromocas;
	}

	public void setAeromocas(ArrayList<Aeromoca> aeromocas) {
		this.aeromocas = aeromocas;
	}
	
	public String getEmpresaDoVoo() {
		return empresaDoVoo;
	}

	public void setEmpresaDoVoo(String empresaDoVoo) {
		this.empresaDoVoo = empresaDoVoo;
	}

	public Map<Integer, Passageiro> getPassageiros() {
		return passageiros;
	}

	public void setPassageiros(Map<Integer, Passageiro> passageiros) {
		this.passageiros = passageiros;
	}

	public GregorianCalendar getHorario() {
		return horario;
	}

	public void setHorario(GregorianCalendar horario) {
		this.horario = horario;
	}

	public String getOcorrenciaDoVoo() {
		String ocorrenciaDoVoo = "";
		
		switch (this.ocorrenciaDoVoo) {
		case ATERRISSANDO:
			ocorrenciaDoVoo = "aterrissando";
			break;
			
		case DECOLANDO:
			ocorrenciaDoVoo = "decolando";
			break;
		}
		return ocorrenciaDoVoo;
	}
	

	public void setOcorrenciaDoVoo(OcorrenciaDoVoo ocorrenciaDoVoo) {
		this.ocorrenciaDoVoo = ocorrenciaDoVoo;
	}	
	
	
}