package com.sistema.faculdade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.faculdade.dto.ProfessorDTO;
import com.sistema.faculdade.service.ProfessorService;

import jakarta.validation.Valid;

@Controller
public class ProfessorController {
	public ProfessorService service;
	
	public ProfessorController(ProfessorService service) {
		this.service = service;
	}
	
	@GetMapping("/cadastrar/professor")
	public String formulario(Model model) {
		model.addAttribute("professorDTO", new ProfessorDTO());
		return "form_professor";
	}
	
	@PostMapping("/cadastrar/professor")
	public String salvarProfessor(@ModelAttribute("professorDTO") @Valid ProfessorDTO professorDTO, BindingResult result) {
		if(result.hasErrors()) {
			return "form_professor";
		}
		service.salvarProfessor(professorDTO);
		return "redirect:/cadastrar/professor";
	}

	@GetMapping("/professores")
	public String listarProfessores(Model model) {
		model.addAttribute("professores", service.listarProfessores());
		return "professores";
	}
	
	@GetMapping("/professores/editar/{id}")
	public String editarProfessor(Model model, @PathVariable Long id) {
		ProfessorDTO dto = service.buscarPorId(id);
		model.addAttribute("professorDTO", dto);
		return "form_professor";
	}
	
	//AtualizarProfessor ("/professores/atualizar/{id}")
	
	//ExcluirProfessor ("/professores/excluir/{id}")
	@DeleteMapping("/professores/excluir/{id}")
	public String excluirProfessor(@PathVariable Long id) {
		service.excluirProfessor(id);
		return "redirect:/professores";
	}
}