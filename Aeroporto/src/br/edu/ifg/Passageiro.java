package br.edu.ifg;

import java.util.Map;
import java.util.Random;

public class Passageiro extends Pessoa {
	private int numeroDaPoltrona;

	public Passageiro(String nome, String cpf, String numeroDoVoo) {
		super(nome, cpf, numeroDoVoo);
	}
	
	public int definirNumeroDaPoltrona(int quantLugaresAviao,Map<Integer,Passageiro> passageiros) {
		Random aleatorio = new Random(); 
		int num = aleatorio.nextInt(quantLugaresAviao);
		num += 1;
		Boolean opcao = true;
		System.out.println(num);
		
		while(opcao) {
			try {
				if(passageiros.get(num) == null) {
					opcao = false;
					this.setNumeroDaPoltrona(num);
				}else {
					num = aleatorio.nextInt(quantLugaresAviao);
				}
			} catch (Exception e) {
				opcao = false;
				this.setNumeroDaPoltrona(num);
			}
		}
		
		System.out.println(this.getNumeroDaPoltrona());
		
		return this.getNumeroDaPoltrona();
	}

	public int getNumeroDaPoltrona() {
		return numeroDaPoltrona;
	}

	public void setNumeroDaPoltrona(int numeroDaPoltrona) {
		this.numeroDaPoltrona = numeroDaPoltrona;
	}

}
