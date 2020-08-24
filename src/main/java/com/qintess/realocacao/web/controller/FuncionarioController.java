package com.qintess.realocacao.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qintess.realocacao.domain.Funcionario;
import com.qintess.realocacao.domain.Objetivo;
import com.qintess.realocacao.service.FuncionarioService;
import com.qintess.realocacao.service.ObjetivoService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private ObjetivoService objetivoService;


	@GetMapping("/cadastrar")
	public String cadastrar(Funcionario funcionario) {
		return "funcionario/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("funcionarios", funcionarioService.buscarTodos());
		return "funcionario/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Funcionario funcionario, RedirectAttributes attr) {
		funcionarioService.salvar(funcionario);
		attr.addFlashAttribute("success", "Funcionário inserido com sucesso.");
		return "redirect:/funcionarios/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("funcionario", funcionarioService.buscarPorId(id));
		return "funcionario/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attr) {
		funcionarioService.editar(funcionario);
		attr.addFlashAttribute("success", "Funcionário editado com sucesso.");
		return "redirect:/funcionarios/cadastrar";
	}	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		funcionarioService.excluir(id);
		attr.addFlashAttribute("success", "Funcionário removido com sucesso.");
		return "redirect:/funcionarios/listar";
	}	
	
	@GetMapping("/buscar/objetivo")
	public String getPorObjetivo(@RequestParam("objetivo") String nome, ModelMap model) {		
		model.addAttribute("funcionarios", funcionarioService.buscarPorObjetivo(nome));
		return "funcionario/lista";
	}
	
	@GetMapping("/detalhes/{id}")
	public String detalhe(@PathVariable("id")Long id, Funcionario funcionario, Model model) {
		funcionario = funcionarioService.buscarPorId(id);
		model.addAttribute("funcionario", funcionario);
		return "/funcionario/detalhes";
	}
	
	@ModelAttribute("objetivos")
	public List<Objetivo> listaDeObjetivos() {
		return objetivoService.buscarTodos();
	}
	
}