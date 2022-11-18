package br.edu.ifg;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String,Voo> voos = new HashMap<>();
		int quantVoos;
		int i = 1;
		
		System.out.println("Quantos voos deseja criar:");
		quantVoos = sc.nextInt();
		clearBuffer(sc);
		
		do {
			
			String empresaDoVoo;
			String numeroDoVoo;
			String ocorrenciaDOVoo;
			
			System.out.println("Digite o nome da empresa do voo");
			empresaDoVoo = sc.nextLine();
			
			System.out.println("Digite o numero do voo:");
			numeroDoVoo = sc.nextLine();
			
			System.out.println("O voo esta aterrissando ou decolando:");
			ocorrenciaDOVoo = sc.nextLine();
			
			Voo voo = new Voo(empresaDoVoo, numeroDoVoo, null, null, null, null, ocorrenciaDOVoo);
			
			i++;
			
		}while(i >= quantVoos);
	}
	
	private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}
