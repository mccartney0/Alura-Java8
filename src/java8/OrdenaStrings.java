package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class OrdenaStrings {

	public static void main(String[] args) {

		// FORMA ANTIGA
		List<String> nomes = new ArrayList<String>();

		nomes.add("Socorro de Almeida");
		nomes.add("Bruno Rodrigues");
		nomes.add("Allan Gomes");
		nomes.add("Utarian Pedro");
		
		System.out.println(nomes);

		// O Lambda pode ser convertido para uma Interface Funcional
		// Lambda - Interface Funcional quando temos apenas um método
//		nomes.sort((n1, n2) -> {
//				if (n1.length() < n2.length())
//					return -1;
//				if (n1.length() > n2.length())
//					return 1;
//				return 0;
//		});

//		nomes.sort((n1, n2) -> Integer.compare(n1.length(),n2.length()));
//		
//		System.out.println(nomes);
//
////		Consumer<String> impressor = s -> System.out.println(s);
////		nomes.forEach(impressor);
//		
//		// Classe anônima
//		// Quando temos uma interface onde só tem um método que está sendo implementado
//		// Utilizamos Lambda
//		nomes.forEach(s -> System.out.println(s));
//		
//		new Thread(new Runnable() {
//
//		    @Override
//		    public void run() {
//		        System.out.println("Executando um Runnable");
//		    }
//
//		}).start();
//		
//		new Thread(() -> System.out.println("Executando um Runnable")).start();
//		
//		-------------------------------------------------------------------------------------

		// LAMBDA
		nomes.sort((n1, n2) -> n1.length() - n2.length());

		// Essas três linhas sem LAMBDA
		Function<String, Integer> funcao = new Function<String, Integer>() {
			@Override
			public Integer apply(String n) {
				return n.length();
			}
		};
		Comparator<String> comparador = Comparator.comparing(funcao);
		nomes.sort(comparador);

		System.out.println(nomes);
		
//		-----------------------------------------------------------------------
		
//		Código mais sucinto com Method references
		
		nomes.sort(Comparator.comparing(s -> s.length()));
		nomes.sort(Comparator.comparing(String::length));
		
		nomes.sort(String.CASE_INSENSITIVE_ORDER);
		
		Function<String, Integer> funcao2 = String::length;
		Function<String, Integer> funcao3 = s -> s.length();
		
		Consumer<String> impressor = System.out::println;
		nomes.forEach(impressor);
		
		nomes.forEach(System.out::println);
		
	}

}
