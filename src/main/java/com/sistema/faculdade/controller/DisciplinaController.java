package com.sistema.faculdade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.faculdade.dto.DisciplinaDTO;
import com.sistema.faculdade.service.DisciplinaService;

import jakarta.validation.Valid;

@Controller
public class DisciplinaController {
	public DisciplinaService service;
	
	public DisciplinaController(DisciplinaService service) {
		this.service = service;
	}
	
	@GetMapping("/cadastrar/disciplina")
	public String formulario(Model model) {
		model.addAttribute("disciplinaDTO", new DisciplinaDTO());
		return "form_disciplina";
	}
	
	@PostMapping("/cadastrar/disciplina")
	public String salvarDisciplina(@ModelAttribute("disciplinaDTO") @Valid DisciplinaDTO disciplinaDTO, BindingResult result) {
		if(result.hasErrors()){
			return "form_disciplina";
		}
		service.salvarDisciplina(disciplinaDTO);
		return "redirect:/cadastrar/disciplina";
	}
	
	//ListarDisciplinas ("/disciplinas")
	@GetMapping("/disciplinas")
	public String listarDisciplinas(Model model) {
		model.addAttribute("disciplinas", service.listarDisciplinas());
		return "disciplinas";
	}
	
	//EditarDisciplina ("/disciplinas/editar/{id}")
	//AtualizarDisciplina ("/disciplinas/atualizar/{id}")
	//ExcluirDisciplina ("/disciplinas/excluir/{id}")
}