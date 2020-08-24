package com.qintess.realocacao.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qintess.realocacao.domain.Objetivo;
import com.qintess.realocacao.domain.Python;
import com.qintess.realocacao.service.ObjetivoService;

	@Controller
	@RequestMapping("/objetivos")
	public class ObjetivoController {

		@Autowired
		private ObjetivoService service;

		@GetMapping("/cadastrar")
		public String cadastrar(Objetivo objetivo) {
			return "objetivo/cadastro";
		}

		@GetMapping("/listar")
		public String listar(ModelMap model) {
			model.addAttribute("objetivos", service.buscarTodos());
			return "objetivo/lista";
		}

		@PostMapping("/salvar")
		public String salvar(@Valid Objetivo objetivo, BindingResult result, RedirectAttributes attr) {
			
			if (result.hasErrors()) {
				return "objetivo/cadastro";
			}
			
			service.salvar(objetivo);
			attr.addFlashAttribute("success", "Objetivo inserido com sucesso.");
			return "redirect:/objetivos/cadastrar";
		}

		@GetMapping("/editar/{id}")
		public String preEditar(@PathVariable("id") Long id, ModelMap model) {
			model.addAttribute("java", service.buscarPorId(id));
			return "objetivo/cadastro";
		}

		@PostMapping("/editar")
		public String editar(Objetivo objetivo, BindingResult result, RedirectAttributes attr) {
			
			if (result.hasErrors()) {
				return "objetivo/cadastro";
			}
			service.editar(objetivo);
			attr.addFlashAttribute("success", "Objetivo editado com sucesso.");
			return "redirect:/objetivos/cadastrar";
		}

		@GetMapping("/excluir/{id}")
		public String excluir(@PathVariable("id") Long id, ModelMap model) {
			service.excluir(id);
			model.addAttribute("success", "Objetivo excluído com sucesso.");
			return listar(model);
		}
	}