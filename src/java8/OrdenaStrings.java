package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

	public static void main(String[] args) {

		//FORMA ANTIGA
		List<String> nomes = new ArrayList<String>();
		
		nomes.add("Socorro de Almeida");
		nomes.add("Bruno Rodrigues");
		nomes.add("Allan Gomes");
		
		Comparator<String> comparador = new ComparadorPorTamanho();
//		Collections.sort(nomes, comparador); ANTIGO
		nomes.sort(comparador);
		System.out.println(nomes);
		
//		ANTIGO
//		for (String n : nomes) {
//			System.out.println(n);
//		}
		
		
		//Consumidor, nova forma de iterar uma coleção
		Consumer<String> consumidor = new ImprimeNaLinha();
		nomes.forEach(consumidor);
		
	}

}

class ImprimeNaLinha implements Consumer<String>{

	@Override
	public void accept(String s) {

		System.out.println(s);
	}
	
}

//ANTIGO
class ComparadorPorTamanho implements Comparator<String>{

	@Override
	public int compare(String n1, String n2) {
		if(n1.length() < n2.length())
			return -1;
		if(n1.length() > n2.length())
			return 1;
		return 0;
	}
	
}
