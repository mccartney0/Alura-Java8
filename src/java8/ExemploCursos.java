package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

class Curso {

	private String nome;
	private int alunos;

	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public int getAlunos() {
		return alunos;
	}

}

public class ExemploCursos {
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("C", 55));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("JavaScript", 150));

		cursos.sort(Comparator.comparing(Curso::getAlunos));
//		cursos.forEach(c -> System.out.println(c.getNome()));

		// No Stream, n�o impacta na lista original
		// Design Pattern - Interface Fluente
		cursos.stream()
			.filter(c -> c.getAlunos() >= 50)
			.map(Curso::getAlunos)
			.forEach(System.out::println);

		Stream<String> nomes = cursos.stream().map(Curso::getNome);
		
		cursos.stream()
			.filter(c -> c.getAlunos() >=50)
			.map(Curso::getNome)
			.forEach(System.out::println);

	}

}
