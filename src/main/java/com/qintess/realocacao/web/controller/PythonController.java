package com.qintess.realocacao.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qintess.realocacao.domain.Java;
import com.qintess.realocacao.domain.Python;
import com.qintess.realocacao.service.PythonService;

@Controller
@RequestMapping("/pythons")
public class PythonController {
	
	@Autowired
	private PythonService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Python python) {
		return "python/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pythons", service.buscarTodos());
		return "python/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Python python, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "python/cadastro";
		}
		
		service.salvar(python);
		attr.addFlashAttribute("success", "Currículo inserido com sucesso.");
		return "redirect:/pythons/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("python", service.buscarPorId(id));
		return "python/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Python python, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "python/cadastro";
		}
		
		service.editar(python);
		attr.addFlashAttribute("success", "Currículo editado com sucesso.");
		return "redirect:/pythons/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
			service.excluir(id);
			model.addAttribute("success", "Currículo excluído com sucesso.");
			return listar(model);	
	}
		
	@GetMapping("/detalhes/{id}")
	public String detalhe(@PathVariable("id")Long id, Python python, Model model) {
		python = service.buscarPorId(id);
		model.addAttribute("python", python);
		return "/python/detalhes";
	}


	
}
