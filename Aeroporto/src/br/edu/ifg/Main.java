package br.edu.ifg;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String,Voo> voos = new HashMap<>();
		Map<String,Aviao> avioes = new HashMap<>();
		int quantVoos;
		int quantAvioes;
		int i = 1;
		
		System.out.println("Quantos avioes deseja criar:");
		quantAvioes = sc.nextInt();
		clearBuffer(sc);
		
		do {
			
			Aviao aviao = new Aviao();
			String key = aviao.getIdentificadorAviao();
			avioes.put(key, aviao);
					
			i++;
			
		}while(i <= quantAvioes);
		
		i = 1;
		
		System.out.println("Quantos voos deseja criar:");
		quantVoos = sc.nextInt();
		clearBuffer(sc);
		
		do {
			
			String empresaDoVoo;
			String ocorrenciaDoVoo;
			
			System.out.println("Digite o nome da empresa do voo");
			empresaDoVoo = sc.nextLine();
			
			System.out.println("O voo esta aterrissando ou decolando:");
			ocorrenciaDoVoo = sc.nextLine();
			ocorrenciaDoVoo = ocorrenciaDoVoo.toUpperCase();
			
			while(!ocorrenciaDoVoo.equals("ATERRISSANDO") && !ocorrenciaDoVoo.equals("DECOLANDO")) {
				
				System.out.println("Innfoormmacao incorreta: "
									+ "Digite se o voo esta aterrissando ou decolando:");
				ocorrenciaDoVoo = sc.nextLine();
				ocorrenciaDoVoo = ocorrenciaDoVoo.toUpperCase();
			}
						
			Voo voo = new Voo(empresaDoVoo,ocorrenciaDoVoo,avioes);
			String key = voo.getNumeroDoVoo();
			
			voos.put(key, voo);
			i++;
			
		}while(i <= quantVoos);
		
		for(String key : voos.keySet()) {

			SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MMM/yyyy HH:mm");
			
			System.out.println("Resumo doo voo: " + voos.get(key).getNumeroDoVoo());
			
			System.out.println("Empresa responsavel: "+voos.get(key).getEmpresaDoVoo());
			System.out.println("O voo esta: "+voos.get(key).getOcorrenciaDoVoo());
			System.out.println("Aviao que realizara o voo: "+voos.get(key).getAviao().getIdentificadorAviao());
			System.out.println("Horario: "+dataFormatada.format(voos.get(key).getHorario().getTime()));
			System.out.println("Piloto: "+voos.get(key).getPiloto().getNome());
			System.out.println("Co-Piloto: "+voos.get(key).getCoPiloto().getNome());
			
			for(Aeromoca aeromoca : voos.get(key).getAeromocas()) {
				System.out.println("Aeromoca: "+aeromoca.getNome());
			}
			
			ArrayList<Passageiro> passageiros = ordenarListaPassageiros(voos.get(key).getPassageiros());
			System.out.printf("Poltrona \t\t Passageiro\n");
			for(Passageiro passageiro : passageiros) {
				System.out.printf("  %d \t\t\t  %s\n",passageiro.getNumeroDaPoltrona(),passageiro.getNome());
			}
		}
	}
	
	public static ArrayList<Passageiro> ordenarListaPassageiros(Map<Integer,Passageiro> passageiros) {
		ArrayList<Passageiro> passageirosOrdenados = new ArrayList<Passageiro>();
		
		for(int key : passageiros.keySet()) {
			passageirosOrdenados.add(passageiros.get(key));
		}
		
		for(int i=0;i<passageirosOrdenados.size()-1;i++) {
			if(passageirosOrdenados.get(i).getNumeroDaPoltrona() > passageirosOrdenados.get(i+1).getNumeroDaPoltrona()) {
				Passageiro passageiro = passageirosOrdenados.get(i+1);
				passageirosOrdenados.remove(i+1);
				passageirosOrdenados.add(i,passageiro);
			}
		}
		
		return passageirosOrdenados;
	}
	
	private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}
