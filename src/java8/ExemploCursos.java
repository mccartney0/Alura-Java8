package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
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

		// No Stream, não impacta na lista original
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

//		Mais Streams, Collectors e APIs
		
		//Options para tratarmos o null
		Optional<Curso> optionalcurso = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.findAny();
		
		Curso curso = optionalcurso.orElse(null);
		System.out.println(curso.getNome());
		
		optionalcurso.ifPresent(c -> System.out.println(c.getNome()));
		
		//Voltar de um STREAM para uma Collection
		List<Curso> filtrado = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.collect(Collectors.toList());
		
		Map<String, Integer> map = cursos.stream()
				.filter(c -> c.getAlunos() >= 100)
				.collect(Collectors.toMap(
						c -> c.getNome(),
						c -> c.getAlunos()));
		
		System.out.println(map);
		
		cursos.stream()
				.filter(c -> c.getAlunos() >= 100)
				.collect(Collectors.toMap(
						c -> c.getNome(),
						c -> c.getAlunos()))
				.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));;
	}
}
