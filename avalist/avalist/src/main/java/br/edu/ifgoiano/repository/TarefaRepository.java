package br.edu.ifgoiano.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifgoiano.entidade.Tarefa;

	public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
	
}

