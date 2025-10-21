package com.sistema.faculdade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.sistema.faculdade.dto.ProfessorDTO;
import com.sistema.faculdade.service.ProfessorService;

import jakarta.validation.Valid;

@Controller
public class ProfessorController {
	private final ProfessorService professorService;
	
	public ProfessorController(ProfessorService professorService) {
		this.professorService = professorService;
	}
	
	@GetMapping("/cadastrar/professor")
	public String formulario(Model model) {
		model.addAttribute("professorDTO", new ProfessorDTO());
		return "professor_form";
	}
	
	@PostMapping("/cadastrar/professor")
	public String salvarProfessor(@ModelAttribute("professorDTO") @Valid ProfessorDTO professorDTO, BindingResult result) {
		if(result.hasErrors()) {
			return "professor_form";
		}
		professorService.salvarProfessor(professorDTO);
		return "redirect:/cadastrar/professor";
	}

	@GetMapping("/professores")
	public String listarProfessores(Model model) {
		model.addAttribute("professores", professorService.listarProfessores());
		return "professores";
	}
	
	@GetMapping("/professores/editar/{id}")
	public String editarProfessor(Model model, @PathVariable Long id) {
		ProfessorDTO dto = professorService.buscarPorId(id);
		model.addAttribute("professorDTO", dto);
		return "professor_form";
	}
	
	@PutMapping("/professores/atualizar/{id}")
	public String atualizarProfessor(@ModelAttribute ProfessorDTO professorDTO, @PathVariable Long id) {
		professorDTO.setId(id);
		professorService.salvarProfessor(professorDTO);
		return "redirect:/professores";
	}
	
	@DeleteMapping("/professores/excluir/{id}")
	public String excluirProfessor(@PathVariable Long id) {
		professorService.excluirProfessor(id);
		return "redirect:/professores";
	}
}