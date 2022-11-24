package br.edu.ifgoiano.servico;

import java.util.List;
import br.edu.ifgoiano.entidade.Tarefa;

public interface TarefaService {

	public List<Tarefa> listarTarefas();
	
	public void inserir(Tarefa tarefa);

	public Tarefa obterTarefa(Long id);

	public void alterarTarefa(Tarefa tarefa);

	public void excluirTarefa(Long id);

}
