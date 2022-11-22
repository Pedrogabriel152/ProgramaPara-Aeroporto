package br.edu.ifg;

import java.util.Scanner;

import br.edu.ifg.interfaces.IAviao;

public class Aviao implements IAviao {
	
	private int quantLugares;
	private String identificadorAviao;
	private Scanner sc = new Scanner(System.in);
	
	public Aviao() {
		this.definirIndentificadorAviao();
		this.definirQuantLugares();
	}

	@Override
	public void definirQuantLugares() {
		int quantLugares;
		
		System.out.println("Quantos lugares o aviao "
							+this.getIdentificadorAviao()+" tem:");
		
		quantLugares = sc.nextInt();
		
		this.setQuantLugares(quantLugares);
	}

	@Override
	public void definirIndentificadorAviao() {
		String identificadorAviao;
		
		System.out.println("Qual a identificacao desse aviao:");
		identificadorAviao = sc.nextLine();
		
		this.setIdentificadorAviao(identificadorAviao);
		
	}

	public int getQuantLugares() {
		return this.quantLugares;
	}

	public void setQuantLugares(int quantLugares) {
		this.quantLugares = quantLugares;
	}

	public String getIdentificadorAviao() {
		return this.identificadorAviao;
	}

	public void setIdentificadorAviao(String identificadorAviao) {
		this.identificadorAviao = identificadorAviao;
	}
	
	

}
