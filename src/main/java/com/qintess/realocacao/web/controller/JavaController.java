package com.qintess.realocacao.web.controller;

import java.util.Optional;

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
import com.qintess.realocacao.service.JavaService;



@Controller
@RequestMapping("/javas")
public class JavaController {
	
	@Autowired
	private JavaService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Java java) {
		return "java/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("javas", service.buscarTodos());
		return "java/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Java java, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "java/cadastro";
		}
		
		service.salvar(java);
		attr.addFlashAttribute("success", "Currículo inserido com sucesso.");
		return "redirect:/javas/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("java", service.buscarPorId(id));
		return "java/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Java java, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "java/cadastro";
		}
		
		service.editar(java);
		attr.addFlashAttribute("success", "Currículo editado com sucesso.");
		return "redirect:/javas/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
			service.excluir(id);
			model.addAttribute("success", "Currículo excluído com sucesso.");
			return listar(model);	
	}
		
	@GetMapping("/detalhes/{id}")
	public String detalhe(@PathVariable("id")Long id, Java java, Model model) {
		java = service.buscarPorId(id);
		model.addAttribute("java", java);
		return "/java/detalhes";
	}
	
}
