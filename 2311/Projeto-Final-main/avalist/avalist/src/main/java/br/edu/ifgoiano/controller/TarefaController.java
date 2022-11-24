package br.edu.ifgoiano.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifgoiano.entidade.Tarefa;
import br.edu.ifgoiano.servico.TarefaService;
import br.edu.ifgoiano.servico.TarefaServiceImpl;

@Controller
public class TarefaController {
	
	private final TarefaService tarefaServiceImpl;
	
	public TarefaController(TarefaServiceImpl tarefaServiceImpl) {
		this.tarefaServiceImpl = tarefaServiceImpl;
	}
	
	@GetMapping ("/tarefas") // caminho para entrar na página principal do site
	public String listarTarefa (Model model) {
		model.addAttribute("tarefas", tarefaServiceImpl.listarTarefas());
		
		/*Obtenção de dados da classe "lista.java", para retornar ao html
		 que vai renderizar e mostrar a página da lista */
		return "listar-tarefas";
	}
	
	@GetMapping ("/tarefa/nova") //inserção de novas tarefas na lista 
	public String abrirNovaTarefa(Model model) {
		
		Tarefa tarefa = new Tarefa();
		model.addAttribute("tarefa", tarefa);
		
		return "inserir-tarefa";
	}
	@PostMapping ("/tarefas/inserir")
	public String inserirTarefa (Tarefa tarefa) {
		this.tarefaServiceImpl.inserir(tarefa);
		
		return "redirect:/tarefas"; /* Vai buscar as novas tarefas inseridas e retornar 
		para a página principal*/
	}
	
	@GetMapping ("tarefas/alterar/{id}")
	public String abrirAlterarLivro(@PathVariable Long id, Model model) {
		
		Tarefa tarefa = this.tarefaServiceImpl.obterTarefa(id);
		
		model.addAttribute("tarefa", tarefa);
		
		return "alterar-tarefa";
	}

	@PostMapping("/tarefas/alterar")
	public String alterarTarefa(Tarefa tarefa) {
		this.tarefaServiceImpl.alterarTarefa(tarefa);
		
		return "redirect:/tarefas";
	}
	@GetMapping ("/tarefas/excluir/{id}")
	public String excluirTarefa(@PathVariable Long id) {
		this.tarefaServiceImpl.excluirTarefa(id);
	
		return "redirect:/tarefas";
	
	}
}

