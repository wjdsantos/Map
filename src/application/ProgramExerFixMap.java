package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProgramExerFixMap {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			Map<String, Integer> resultado = new HashMap<>();
			
//			int acumulado = 0;
			
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				String nome = fields[0];
				Integer votos = Integer.parseInt(fields[1]);
				
				if (resultado.containsKey(nome)) {
					int votos_urna = resultado.get(nome);
					votos += votos_urna;
				}
				resultado.put(nome, votos);
				
				line = br.readLine();
			}
			
			for (String nome : resultado.keySet()) {
				System.out.println(nome + ": " + resultado.get(nome));
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();
	}

}
