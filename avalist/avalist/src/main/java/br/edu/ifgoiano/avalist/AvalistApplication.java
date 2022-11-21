package br.edu.ifgoiano.avalist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifgoiano.entidade.Tarefa;
import br.edu.ifgoiano.repository.TarefaRepository;


@SpringBootApplication
public class AvalistApplication implements CommandLineRunner {
	
	@Autowired
	private TarefaRepository tarefaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AvalistApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Tarefa tarefa1 = new Tarefa();
		tarefa1.setDisciplina("Química");
		tarefa1.setCategoria("Seminário");
		tarefa1.setData("01/12/22");
		
		tarefaRepository.save(tarefa1);
		
	}

}
