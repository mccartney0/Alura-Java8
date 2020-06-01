package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

	public static void main(String[] args) {

		// FORMA ANTIGA
		List<String> nomes = new ArrayList<String>();

		nomes.add("Socorro de Almeida");
		nomes.add("Bruno Rodrigues");
		nomes.add("Allan Gomes");

		System.out.println(nomes);
		
		//O Lambda pode ser convertido para uma Interface Funcional
		//Lambda - Interface Funcional quando temos apenas um m�todo
//		nomes.sort((n1, n2) -> {
//				if (n1.length() < n2.length())
//					return -1;
//				if (n1.length() > n2.length())
//					return 1;
//				return 0;
//		});
		
		nomes.sort((n1, n2) -> Integer.compare(n1.length(),n2.length()));
		
		System.out.println(nomes);

//		Consumer<String> impressor = s -> System.out.println(s);
//		nomes.forEach(impressor);
		
		// Classe an�nima
		// Quando temos uma interface onde s� tem um m�todo que est� sendo implementado
		// Utilizamos Lambda
		nomes.forEach(s -> System.out.println(s));
		
		

	}

}
